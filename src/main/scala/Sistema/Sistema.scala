package Sistema
import Pelicula._
import Usuario._

abstract class Sistema extends Pelicula with Usuario
{
    //Atributos
    var user : UsuarioNorm
    var obj : Pelicula
    var listaAuxi : List[Usuario]
    var listaAuxi1 : List[Pelicula]

    // //MÉTODOS
    // /*Recibe 1 nombre valido de una pelicula y un usuario administrador, verifica
    // que la pelicula exista y la elimina de listaPeliculas*/
    // def eliminarPelicula(userAdm : Usuario, peliTarget : String) : List[Pelicula] =
    // {
    //     if( userAdm._nivel == 1 ){
    //         for( i <- _listaPeliculas){
    //             if( i._nombre == peliTarget ){
    //                 listaAuxi1 = List()
    //                 listaAuxi1 = _listaPeliculas.filter(x => x._nombre != peliTarget)
    //             }
    //         }
    //     }
    //     return listaAuxi1
    // }

        /* INICIO SESION se reciben 2 strings que corresponden a usuario y clave, el sistema
    verifica la identidad y permite el acceso al usuario o lo rechaza si hay datos inconcistentes*/
    def inicioSesion(newUser : String, newPass : String) : Boolean =
    {
        for( i <- _listaUsuarios ){
            if( newUser == i._username && newPass == i._password ){
                return true
            }
        }
        false
    }
    /*Dar derechos de administrador a un usuario recibido*/
    def darAdmin(user : Usuario) : Usuario =
    {
        user._nivel = 1
        return user
    }

    /* REGISTRO Crea un objeto con los datos de un usuario y lo agrega a listaUsuaios*/
    def crearUsuario(newEmail : String, newUser : String, newPassword : String) : List[Usuario] =
    {   var user = new UsuarioNorm(newEmail,newUser,newPassword)
        var add = user :: _listaUsuarios
        return _listaUsuarios
    }

}