package Sistema
import Pelicula._
import Usuario._

class Sistema
{
    //Atributos
    var _listaPeliculas : List[Pelicula] = List()
    var _listaUsuarios : List[Usuario] = List()
    // var listaAuxi : List[Usuario] =_
    // var listaAuxi1 : List[Pelicula] =_

    //Getters
    def listaPeliculas = _listaPeliculas
    def listaUsuarios = _listaUsuarios 

    // //MÉTODOS

        /* INICIO SESION se reciben 2 strings que corresponden a usuario y clave, el sistema
    verifica la identidad y permite el acceso al usuario o lo rechaza si hay datos inconcistentes*/
    def inicioSesion(newUser : String, newPass : String) : Boolean =
    {
        for( i <- _listaUsuarios ){
            if( newUser == i._username && newPass == i._password ){
                return true
            }
        }
        return false
    }

    def estaUsuario(user : String) : Boolean =
    {
        for( i <- this._listaUsuarios ){
            if(user == i._username)
            {
                return true
            }
        }

        return false
    }


    def encontrarUsuario(user : String) : Usuario =
    {
        for( i <- this._listaUsuarios )
        {
            if(user == i._username)
            {
                return i
            }
        }
        var usuVacio = new UsuarioNorm
        return usuVacio
    }


    /*Dar derechos de administrador a un usuario recibido*/
    def darAdmin(user : Usuario) : Unit =
    {
        user._nivel = 1
    }


    def agregarUsuario(user : Usuario) : Unit =
    {
        _listaUsuarios = user :: _listaUsuarios
    }

    def agregarPelicula(pel : Pelicula) : Unit =
    {
        _listaPeliculas = pel :: _listaPeliculas
    }

    /* REGISTRO Crea un objeto con los datos de un usuario y lo agrega a listaUsuaios*/
    def crearUsuario(newEmail : String, newUser : String, newPassword : String) : List[Usuario] =
    {   var user = new UsuarioNorm(newEmail,newUser,newPassword)
        var add = user :: _listaUsuarios
        return _listaUsuarios
    }

    def pasarMes() : Unit =
    {
        if(_listaUsuarios.nonEmpty != false)
        {
            for( i <- _listaUsuarios ){
                var usnor = i.asInstanceOf[UsuarioNorm]
                if(usnor.pagarMes())
                {
                    usnor.pagarMes()
                }
               else
               {
                   usnor._mesNoPago += 1
               }
            }
        }
    }

}