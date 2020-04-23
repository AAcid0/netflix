package Usuario
import Pelicula._

class UsuarioNorm extends Usuario
{
    //Atributos

    override var _email : String = _
    override var _username : String = _
    override var _password : String = _
    override var _nivel = 0
    var _estadoCuenta : Int = 1 //1 = activo , 0 = inactivo
    var _mesNoPago : Int = 0
    var _saldo : Double = 0
    var _plan : Int = 1 //Plan basico = 1, plan medio = 2, plan definitivo = 3 
    var _peliculasCompradas : List[Pelicula] = List()


    //Constructor Auxiliar
    def this(e : String, u : String, p : String)
    {
        this()
        _email = e
        _username = u
        _password = p
    }

    //Getters
    override def email = _email
    override def username = _username
    override def password = _password
    override def nivel = _nivel
    def mesNoPago = _mesNoPago
    def plan = _plan
    def estadoCuenta = _estadoCuenta


    //Setters
    def plan_= (nuevoPlan : Int) = _plan = nuevoPlan

    //Metodos

     def pagarMes() : Boolean =
    {
        var pago : Boolean = false

        if(this._plan == 1)
        {
            if((this._saldo - 20000) >= 0)
            {
                this._saldo = this._saldo - 20000
                pago = true
            }   
        }

        if(this._plan == 2)
        {
            if((this._saldo - 15000) >= 0)
                {
                    this._saldo = this._saldo - 15000
                    pago = true
                }    
        }
        
        if(this._plan == 3)
        {
            if((this._saldo - 1000) >= 0)
            {
                this._saldo = this._saldo - 10000
                pago = true 
            }     
        }

        return pago
    }


    def recargarSaldo(saldoArecargar:Double) =
    {
        this._saldo = this._saldo + saldoArecargar
    }

    def comprarPelicula( nomPelicula: String, listPeliculas : List[Pelicula] ) : Unit =
    {
        if (this._estadoCuenta == 1)
        {
            for( i <- listPeliculas )
            {
                if( i._nombre == nomPelicula )
                {
                    if (this._saldo >= i._costoDescarga)
                    {
                        this._saldo = this._saldo - i._costoDescarga
                        _peliculasCompradas = i :: _peliculasCompradas
                    }
                }
            }
        }
    }

    def verPelicula(nombrePel : String, listPeliculas : List[Pelicula]) : Unit = 
    {
        if (this._estadoCuenta == 1) // habilitado
        {
            for( i <- listPeliculas )
            {
                if(i._nombre == nombrePel)
                {
                    _peliculasCompradas = i :: _peliculasCompradas
                    i._numVistas += 1
                }
            }
        }
    }

    /*Al un usuario comprar un plan, se debe modificar en la info del usario
    recibe un objeto tipo usuario y el nuevo plan adquirido*/
    def comprarPlan(newPlan : Int) : Unit =
    {
        this._plan = newPlan
    }

}