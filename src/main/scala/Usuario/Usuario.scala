package Usuario

trait Usuario
{

    //Atributos

    var _email : String 
    var _username : String
    var _password : String
    var _nivel : Int //0 = usuario, 1 = administrador
    var _estadoCuenta : String //activo o inactivo
    var listaUsuarios : List[Usuario]
    //Getters

    def email = _email
    def username = _username
    def password = _password
    def nivel = _nivel
    def estadoCuenta = _estadoCuenta

    //Setters

    def email_= (nuevoEmail : String) = _email = nuevoEmail
    def username_= (nuevoUsername : String) = _username = nuevoUsername
    def password_= (nuevaPassword : String) = _password = nuevaPassword
    def nivel_= (nuevoNivel : Int) = _nivel = nuevoNivel
    def estadoCuenta_= (nuevoEstado : String) = _estadoCuenta = estadoCuenta

}