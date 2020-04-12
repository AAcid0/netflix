package Usuario

abstract class UsuarioNorm extends Usuario
{
    //Atributos

    override var _email : String
    override var _username = ""
    override var _password = ""
    override var _nivel = 0
    var _mesNoPago : Int = 0
    var _tipoPlan : String = "Básico"
    

    //Constructor Auxiliar
    def this(e : String, u : String, p : String)
    {
        this()
        _email = e
        _username = u
        _password = p
    }

    //Getters
    def mesNoPago = _mesNoPago
    def tipoPlan = _tipoPlan

    //Setters
    def tipoPlan_= (nuevoPlan : String) = _tipoPlan = nuevoPlan
}