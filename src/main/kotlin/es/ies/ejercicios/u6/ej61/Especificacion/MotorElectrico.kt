package es.ies.ejercicios.u6.ej61.Especificacion

class MotorElectrico(numeroBastidores: Int): Motor(numeroBastidores) {
    var encendido = false
    var revoluciones = 0
    var porcentajeBateria = 20

    override fun arrancar() {
        println("Pulsa el botón de encender y el motor se enciende")
        encendido = true
    }

    override fun detener() {
        println("Pulsa el botón de apagar y el motor se apaga")
        encendido = false
    }

    override fun estaArrancado(): Boolean {
        return encendido
    }

    override fun acelerar() {
        revoluciones += 20
        println("El motor acelera")
    }

    override fun frenar() {
        if (revoluciones == 0) {
            println("El motor ya esta frenado al máximo")
        } else {
            revoluciones -= 20
            println("El motor frena")
        }
    }

    override fun obtenerRevoluciones(): Int {
        println("Revoluciones ${revoluciones}")
        return revoluciones
    }

    override fun obtenerEnergia(): Int{
        println("Bateria al ${porcentajeBateria}% ")
        return porcentajeBateria

    }

    override fun aumentarEnergia() {
        if (porcentajeBateria == 100){
            println("La batería está al máximo")
        } else {
            porcentajeBateria += 20
            println("El motor está cargando")
        }
    }
}