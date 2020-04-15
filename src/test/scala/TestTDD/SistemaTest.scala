import org.scalatest.FunSuite
import Sistema.Sistema
import Pelicula.Pelicula
import Usuario.UsuarioNorm
import Usuario.Usuario

class Sistema extends FunSuite
{
    var newUser : UsuarioNorm = new UsuarioNorm("alguien@algo", "pakito", "clave123")

    test("Al registrar un usuario, será agregado a listaUsuarios")
    {
        //var newUser : UsuarioNorm =  new UsuarioNorm("alguien@algo", "pakito", "clave123")
        assert(listaUsuarios.nonEmpty != false)
    }
}