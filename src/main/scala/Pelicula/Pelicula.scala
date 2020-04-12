package Pelicula

abstract class Pelicula
{
    //Atributos

    var _nombre : String = _
    var _nombreCreador : String = _
    var _numVistas : Int = 0
    var listaPeliculas : List[Pelicula] 
    //Constructor Auxiliar

    def this(n : String, d:String)
    {
        this()
        _nombre = n
        _nombreCreador = d
    }

    //Getters

    def nombre = _nombre 
    def numVistas = _numVistas
    def nombreCreador = _nombreCreador

    //Setters
    def numVistas_= (newNumVistas : Int) = _numVistas = newNumVistas


 }
