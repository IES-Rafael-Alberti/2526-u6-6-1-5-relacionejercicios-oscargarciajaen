package es.ies.ejercicios.u6.ej61.Especificacion

class MotorElectrico(numeroBastidores: Int): Motor(numeroBastidores) {
    var encendido = false
    var revoluciones = 0
    var porcentajeBateria = 20

    override fun arrancar() {
        encendido = true
        println("Pulsa el botón y arranca")
    }

    override fun detener() {
        encendido = false
        println("Pulsa el botón y se detiene")
    }

    override fun estaArrancado(): Boolean {
        if (encendido == true){
            println("Motor encendido")
        } else println("Motor apagado")
        return encendido
    }

    override fun acelerar() {
        revoluciones += 20
        println("El motor acelera")
    }

    override fun frenar() {
        if (revoluciones == 0) {
            println("Motor frenado al máximo")
        } else {
            revoluciones -= 20
            println("Motor frenando")
        }
    }

    override fun obtenerRevoluciones(): Int {
        println("$revoluciones revoluciones")
        return revoluciones
    }

    override fun obtenerEnergia(): Int{
        println("${porcentajeBateria}%")
        return porcentajeBateria

    }

    override fun aumentarEnergia() {
        if (porcentajeBateria == 100){
            println("Batería al máximo")
        } else {
            porcentajeBateria += 20
            println("Cargando batería")
        }
    }
}