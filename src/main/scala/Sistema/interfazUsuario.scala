package Sistema 

import Pelicula._
import Usuario._
import scala.io._

object interfazUsuario extends App
{
    var cerrarSistema : Boolean = false
    var Netflix : Sistema = new Sistema

    while(!cerrarSistema)
    {
        println("Bienvenido a Netflix")
        println("Por favor registrese o Inicie sesión para poder iniciar")
        println("1-> Iniciar sesión") 
        println("2-> Registrarse")
        
        var op :Int = StdIn.readInt()
        
        if (op == 1)
        {
            inicioSesion()
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

    def inicioSesion() : Unit =
    {
        println("Introduzca su usuario")
        var usu : String = StdIn.readLine()
        println("Introduzca su contraseña")
        var pass : String = StdIn.readLine()
        cerrarSistema = true
    }

    def registro() : Unit =
    {
        println("Puto")
        cerrarSistema = true
    }
}