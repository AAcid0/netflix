package Pelicula

class Pelicula
{
    //Atributos

    var _nombre : String = _
    var _nombreCreador : String = _
    var _descripcion : String =_
    var _numVistas : Int = 0
    var _duracion : Int = 0 //en minutos
    var _costoDescarga : Double = 0
    
    //Constructor Auxiliar

    def this(n : String, d: String, dur : Int)
    {
        this()
        _nombre = n
        _descripcion = d
        _duracion = dur
        _costoDescarga = this.calcularCostoDescarga()
    }

    //Getters

    def nombre = _nombre 
    def numVistas = _numVistas
    def nombreCreador = _nombreCreador

    //Setters
    def numVistas_= (newNumVistas : Int) = _numVistas = newNumVistas

    //metodos 
    def calcularCostoDescarga() : Int =
    {
        var costo = this._duracion * 300
        return costo
    }


 }
