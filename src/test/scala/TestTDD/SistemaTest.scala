import org.scalatest.FunSuite
import Sistema._
import Pelicula._
import Usuario._

class SistemaTest extends FunSuite
{
    var newSistem : Sistema = new Sistema
    var newUser : UsuarioNorm = new UsuarioNorm("alguien@algo", "pakito", "clave123")
    //newSistem.crearUsuario("alguien@algo", "pakito", "clave123")
    var peli : Pelicula = new Pelicula("X-men","Superheroes",120)
    newSistem.agregarPelicula(peli)

    test("Al registrar un usuario, será agregado a listaUsuarios")
    {
        newSistem.agregarUsuario(newUser)
        //var newUser : UsuarioNorm =  new UsuarioNorm("alguien@algo", "pakito", "clave123")
        assert(newSistem._listaUsuarios.nonEmpty != false)
    }

    test("Al registrar el usuario su contraseña debe ser igual a la que el introduce")
    {
        assert(newUser._password == "clave123")
    }

    test("La recarga del usuario es efectiva")
    {
        newUser.recargarSaldo(40000)
        assert(newUser._saldo == 40000)
    }

    test("Al usuario se le da el admin exitosamente")
    {
        newSistem.darAdmin(newUser)
        assert(newUser._nivel == 1)
        
    }



    test("Cuando el usuario compra una pelicula, esta se agrega a su lista de peliculas compradas")
    {
        newUser.comprarPelicula("X-men",newSistem.listaPeliculas)
        assert(newUser._peliculasCompradas.head._nombre == "X-men")    
    }

    test("Cuando se compra una pelicula se le descuenta el costo de la pelicula al saldo del usuario")
    {
        assert(newUser._saldo == 4000)
    }
}