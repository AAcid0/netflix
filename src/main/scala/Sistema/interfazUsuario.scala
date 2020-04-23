package Sistema 

import Pelicula._
import Usuario._
import scala.io._

object interfazUsuario extends App
{
    var cerrarSistema : Boolean = false
    var netflix : Sistema = new Sistema

    while(!cerrarSistema)
    {
        println("Bienvenido a Netflix")
        println("Por favor registrese o Inicie sesión para poder iniciar")
        println("1-> Iniciar sesión") 
        println("2-> Registrarse")
        
        var op :Int = StdIn.readInt()
        
        if (op == 1)
        {
            iniciarSesion()
        }
        
        else if (op == 2)
        {
            registro()
        }

        else
        {
            println("opción Invalida")
        }
        
    }

    def iniciarSesion() : Unit =
    {
        println("Introduzca su usuario")
        var usu : String = StdIn.readLine()
        println("Introduzca su contraseña")
        var pass : String = StdIn.readLine()
        
        if(netflix._listaUsuarios.nonEmpty != false)
        {
            if(netflix.inicioSesion(usu,pass))
            {
                var user : Usuario = netflix.encontrarUsuario(usu)
                if (user._nivel == 0)
                {
                    var usnor = user.asInstanceOf[UsuarioNorm]
                    inicioNormal(usnor)
                }
                else
                {
                    var usAd = user.asInstanceOf[UsuarioAdmin]
                    inicioAdmin(usAd)
                }
            }
            else
            {
                println("Hay problemas al iniciar tu sesión \n 1-> Volver a Inicio de sesión \n 2-> Registrarse")
                var elec : Int = StdIn.readInt()
                if(elec == 1)
                {
                    iniciarSesion()
                }
                else
                {
                    registro()
                }
            }
        }
    }

    def registro() : Unit =
    {
        println("Digite Email")
        var email : String = StdIn.readLine()
        println("Digite Username")
        var name : String = StdIn.readLine()
        println("Digite Contraseña")
        var contra : String = StdIn.readLine()

        var nuevoUsu : UsuarioNorm = new UsuarioNorm(email,name,contra)
        netflix.agregarUsuario(nuevoUsu)

        var usnor = nuevoUsu.asInstanceOf[UsuarioNorm]
        inicioNormal(usnor)
    }

    def inicioNormal(persona : UsuarioNorm) : Unit=
    {
        var sesionCerrada : Boolean = false
        while(!sesionCerrada)
        {
        println("Bienvenido a netflix, que desea hacer \n 1-> Ver pelicula \n 2-> Descargar Una pelicula \n 3-> Recargar Dinero \n 4-> Cerrar sesión")
        var opcion : Int = StdIn.readInt()

        if(opcion == 1)
        {
            println("Ingrese el nombre de la pelicula que quiere ver")
            var nombre : String = StdIn.readLine()

            persona.verPelicula(nombre, netflix.listaPeliculas)

        }

        if(opcion == 2)
        {
            println("Ingrese el nombre de la pelicula que quiere descargar")
            var nombre : String = StdIn.readLine()

            persona.comprarPelicula(nombre, netflix.listaPeliculas)
            
        }

        if(opcion == 3)
        {
            println("Digite el saldo a recargar")
            var opcion : Double = StdIn.readDouble()

            persona.recargarSaldo(opcion)
        }

        if(opcion == 4)
        {
            println("Sesión cerrada")
            iniciarSesion()
        }



        }    
    }

    def inicioAdmin(user : UsuarioAdmin) =
    {
        var sesionCerrada : Boolean = false
        while(!sesionCerrada)
        {
            println("Bienvenido usuario administrador")
            println("Por favor seleccione la opción a realizar")
            println("1-> Crear pelicula nueva")
            println("2-> Eliminar una pelicula existente")
            println("3-> Inhabilitar cuenta de un usuario")
            println("4-> Eliminar cuenta de un usuario")
            println("5-> Cerrar sesión")

            var op : Int = StdIn.readInt()

            if(op == 1)
            {
                println("Ingrese el nombre de la pelicula: ")
                var nom : String = StdIn.readLine()
                println("Ingrese la descripcion de la pelicula: ")
                var des : String = StdIn.readLine()
                println("Ingrese la duracion de la pelicula: ")
                var dur : Int = StdIn.readInt()
                user.crearPelicula(nom, des, dur, netflix._listaPeliculas)
                println("Pelicula agregada con éxito.")
            }

            if(op == 2)
            {
                println("Ingrese el nombre de la pelicula a eliminar: ")
                var nom : String = StdIn.readLine()
                user.eliminarPelicula(user, nom, netflix._listaPeliculas)
                println("Pelicula eliminada con éxito.")
            }

            if(op == 3)
            {
                println("Ingrese el usuario al que se inhabilitará: ")
                var nom : String = StdIn.readLine()
                var userNue : Usuario = netflix.encontrarUsuario(nom)
                var userAux = userNue.asInstanceOf[UsuarioNorm]
                user.desactivarUsuario(user, userAux, netflix._listaUsuarios)
                println("Usuario inhabilitado.")
            }
            if(op == 4)
            {
                println("Ingrese el usuario al que se eliminará: ")
                var nom : String = StdIn.readLine()
                var userNue : Usuario = netflix.encontrarUsuario(nom)
                var userAux = userNue.asInstanceOf[UsuarioNorm]
                user.eliminarCuenta(user, userAux, netflix._listaUsuarios)
                println("Usuario Eliminado.")
            }
            if(op == 5)
            {
                println("Sesión cerrada")
                iniciarSesion()
            }
        }
    }
}