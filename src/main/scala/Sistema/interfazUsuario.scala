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

    }
}