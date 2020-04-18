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
    var _tipoPlan : String = "Básico"
    var _peliculasCompradas : List[Pelicula] = _
    

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
    def tipoPlan = _tipoPlan
    def estadoCuenta = _estadoCuenta


    //Setters
    def tipoPlan_= (nuevoPlan : String) = _tipoPlan = nuevoPlan

    //Metodos

    def pagarMes() =
    {
        this._saldo = this._saldo - 15000
    }

    def recargarSaldo(saldoArecargar:Double) =
    {
        this._saldo = this._saldo + saldoArecargar
    }

    def comprarPelicula( nomPelicula: String ) =
    {
        if (this._estadoCuenta == 1)
        {
            for( i <- _listaPeliculas )
            {
                if( i._nombre == nomPelicula )
                {
                    if (this._saldo >= i._costoDescarga)
                    {
                        this._saldo = this._saldo - i._costoDescarga
                        var add = i :: this._peliculasCompradas
                        this._peliculasCompradas = add  
                    }
                }
            }
        }
    }

    /*Al un usuario comprar un plan, se debe modificar en la info del usario
    recibe un objeto tipo usuario y el nuevo plan adquirido*/
    def comprarPlan(user : UsuarioNorm, newPlan : String) : UsuarioNorm =
    {
        user._tipoPlan = newPlan
        return user
    }

}