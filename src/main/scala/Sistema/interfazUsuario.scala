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
                    inicioAdmin(user)
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

    def inicioAdmin(user : Usuario) =
    {
        println("enconstruccion")
    }
}