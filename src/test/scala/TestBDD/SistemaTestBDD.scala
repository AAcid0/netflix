import org.scalatest.GivenWhenThen
import org.scalatest.FeatureSpec
import Sistema._
import Pelicula._
import Usuario._

class SistemaTestB extends FeatureSpec with GivenWhenThen
{
    var sys : Sistema = new Sistema

    feature("Crear un usuario nuevo")
    {
        scenario("realizar el registro de un usuario nuevo")
        {
            Given("Dado un usuario nuevo con datos validos")
                var newUser : UsuarioNorm = new UsuarioNorm("alguien@algo", "pakito", "clave123")
    
            When("Se agrega el usuario nuevo al conjunto de usuarios registrados")
                sys.agregarUsuario(newUser)
            Then("La lista de usuarios registrados no se encuentra vacía")
                assert(sys._listaUsuarios.length > 0)
        }
    }

    feature("Crear una pelicula nueva")
    {
        scenario("Un usuario administrador crea una pelicula nueva")
        {
            Given("Dada una pelicula y un usuario Adm")
                var newUser : UsuarioAdmin = new UsuarioAdmin("alguien@algo", "pakito", "clave123")
                var peli : Pelicula = new Pelicula("X-men","Superheroes",120)
            When("El admin agrega la pelicula nueva al catalogo de peliculas disponibles")
                sys.agregarPelicula(peli)
            Then("La pelicula mas reciente debe corresponder con los datos de la ultima agregada")
                assert(sys._listaPeliculas.head._nombre == "X-men")
        }
    }

    feature("Aumentar las visualizaciones de una pelicula")
    {
        scenario("Un usuario reproduce una pelicula")
        {
            Given("Dado un usuario y una pelicula que ya pertencen al sistema")
                var newUser : UsuarioNorm = new UsuarioNorm("alguien@algo", "pakito", "clave123")
                var peli : Pelicula = new Pelicula("X-men","Superheroes",120)
                sys.agregarPelicula(peli)
            When("El usuario reproduzca la pelicula")
                newUser.verPelicula("X-men", sys._listaPeliculas)
            Then("El numero de visualizaciones de la pelicula debe aumentar")
                assert(sys._listaPeliculas.head._numVistas > 0)
        }
    }
}