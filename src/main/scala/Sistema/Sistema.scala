package Sistema
import Pelicula.Pelicula
import Usuario.UsuarioNorm
import Usuario.Usuario

abstract class Sistema extends Pelicula with Usuario
{
    //Atributos
    var user : UsuarioNorm
    var obj : Pelicula
    var listaAuxi : List[Usuario]
    var listaAuxi1 : List[Pelicula]

    //MÉTODOS
    /*Recibe 1 nombre valido de una pelicula y un usuario administrador, verifica
    que la pelicula exista y la elimina de listaPeliculas*/
    def eliminarPelicula(userAdm : Usuario, peliTarget : String) : List[Pelicula] =
    {
        if( userAdm._nivel == 1 ){
            for( i <- listaPeliculas ){
                if( i._nombre == peliTarget ){
                    listaAuxi1 = List()
                    listaAuxi1 = listaPeliculas.filter(x => x._nombre != peliTarget)
                }
            }
        }
        return listaAuxi1
    }
    /*INHABILITAR USUARIO: recibe 1 userAdm y userNorm, verifica que userNorm deba 
    2 o 3 meses y de ser así, el estado de userNorm pasa a Inhabilitado*/
    def desactivarUsuario(userAdm : Usuario, userTarget : UsuarioNorm) : List[Usuario] =
    {
        if( userAdm._nivel == 1 ){
            for( i <- listaUsuarios ){
                if( i._username == userTarget ){
                    var toInact : String = "inactivo"
                    userTarget._estadoCuenta = toInact
                }
            }
        }
        return listaUsuarios
    }

    /*Recibe 1 usuario administrador y 1 usuario normal, verifica que
    el usuario normal debe mas de 4 meses y borra su cuenta de listaUsuarios*/
    def eliminarCuenta(userAdm : Usuario, userTarget : UsuarioNorm) : List[Usuario] =
    {
        if( userAdm._nivel == 1 && userTarget._mesNoPago >= 4 )
        {
            for ( i <- listaUsuarios ){
                if( i._username == userTarget ){
                    listaAuxi = List()
                    listaAuxi = listaUsuarios.filter(x => x._username != userTarget)
                }
            }
        }
        return listaAuxi
    }
        /* INICIO SESION se reciben 2 strings que corresponden a usuario y clave, el sistema
    verifica la identidad y permite el acceso al usuario o lo rechaza si hay datos inconcistentes*/
    def inicioSesion(newUser : String, newPass : String) : Boolean =
    {
        for( i <- listaUsuarios ){
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

    /*Al un usuario comprar un plan, se debe modificar en la info del usario
    recibe un objeto tipo usuario y el nuevo plan adquirido*/
    def comprarPlan(user : UsuarioNorm, newPlan : String) : UsuarioNorm =
    {
        user._tipoPlan = newPlan
        return user
    }



    /* REGISTRO Crea un objeto con los datos de un usuario y lo agrega a listaUsuaios*/
    def crearUsuario(newEmail : String, newUser : String, newPassword : String) : List[Usuario] =
    { 
        var add = user :: listaUsuarios
        return listaUsuarios
    }
    /*Crea una nueva pelicula y la agrega a listaPelicula*/
    def crearPelícula(newNombre : String, newCreador : String) : List[Pelicula] =
    { 
        var add = obj :: listaPeliculas
        return listaPeliculas
    }
}