package Usuario
import Pelicula._

class UsuarioAdmin extends Usuario 
{
    override var _email : String = _
    override var _username : String = _
    override var _password : String = _
    override var _nivel = 1
    var listaAuxi : List[Usuario] = _
    var listaAuxi1 : List[Pelicula] = _


    //getters
    override def email = _email
    override def username = _username
    override def password = _password
    override def nivel = _nivel 

    //setters 
   
   
   
    //MÉTODOS

    

    /*Crea una nueva pelicula y la agrega a listaPelicula*/
    def crearPelícula(newNombre : String, newCreador : String, duracion : Int , _listaPeliculas : List[Pelicula]) : List[Pelicula] =
    { 
        var obj = new Pelicula(newNombre,newCreador,duracion)
        var add = obj :: _listaPeliculas
        return _listaPeliculas
    }
    
    
    
    /*Recibe 1 nombre valido de una pelicula y un usuario administrador, verifica
    que la pelicula exista y la elimina de listaPeliculas*/
    def eliminarPelicula(userAdm : Usuario, peliTarget : String, _listaPeliculas : List[Pelicula]) : List[Pelicula] =
    {
        if( userAdm._nivel == 1 ){
            for( i <- _listaPeliculas){
                if( i._nombre == peliTarget ){
                    listaAuxi1 = _listaPeliculas.filter(x => x._nombre != peliTarget)
                }
            }
        }
        return listaAuxi1
    }

    /*INHABILITAR USUARIO: recibe 1 userAdm y userNorm, verifica que userNorm deba 
    2 o 3 meses y de ser así, el estado de userNorm pasa a Inhabilitado*/

    def desactivarUsuario(userAdm : Usuario, userTarget : UsuarioNorm, _listaUsuarios : List[Usuario]) : List[Usuario] =
    {
        if( userAdm._nivel == 1 ){
            for( i <- _listaUsuarios ){
                if( i._username == userTarget && userTarget._mesNoPago >= 2){
                    userTarget._estadoCuenta = 0
                }
            }
        }
        return _listaUsuarios
    }

     /*Recibe 1 usuario administrador y 1 usuario normal, verifica que
    el usuario normal debe mas de 4 meses y borra su cuenta de listaUsuarios*/
    def eliminarCuenta(userAdm : Usuario, userTarget : UsuarioNorm, _listaUsuarios : List[Usuario]) : List[Usuario] =
    {
        if( userAdm._nivel == 1 && userTarget._mesNoPago >= 4 )
        {
            for ( i <- _listaUsuarios ){
                if( i._username == userTarget ){
                    listaAuxi = _listaUsuarios.filter(x => x._username != userTarget)
                }
            }
        }
        return listaAuxi
    }



}