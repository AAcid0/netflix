package Sistema
import Pelicula.Pelicula
import Usuario.UsuarioNorm
import Usuario.Usuario

abstract class Sistema extends Pelicula with Usuario
{
    //MÉTODOS

    /*Recibe 1 usuario administrador y 1 usuario normal, verifica que
    el usuario normal debe mas de 4 meses y borra su cuenta de listaUsuarios*/
    def eliminarCuenta(userAdm : Usuario, userTarget : UsuarioNorm) : List[Usuario] =
    {
        if( userAdm._nivel == 1 && userTarget._mesNoPago >= 4 )
        {

        }
        return List()
    }
    /*Dar derechos de administrador a un usuario recibido*/
    def darAdmin(user : Usuario) : Usuario =
    {
        user._nivel = 1
        return user
    }

    /*Al un usuario comprar un plan, se debe modificar en la info del usario
    recibe un objeto tipo usuario y el nuevo plan adquirido*/
    def comprarPlan(user : UsuarioNorm, newPlan : String) : UsuarioNorm =
    {
        user._tipoPlan = newPlan
        return user
    }

    /*Crea un objeto con los datos de un usuario y lo agrega a listaUsuaios*/
    def crearUsuario(newEmail : String, newUser : String, newPassword : String) : Vector[Usuario] =
    {
        var user = UsuarioNorm(newEmail, newUser, newPassword)
        var add = listaUsuarios :+ user
        return listaUsuarios
    }
    /*Crea una nueva pelicula y la agrega a listaPelicula*/
    def crearPelícula(newNombre : String, newCreador : String) : Vector[Pelicula] =
    { 
        var obj = Pelicula(newNombre, newCreador)
        var add = listaPeliculas :+ obj
        return listaPeliculas
    }
}