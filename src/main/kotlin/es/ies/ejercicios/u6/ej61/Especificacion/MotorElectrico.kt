package es.ies.ejercicios.u6.ej61.Especificacion

class MotorElectrico(numeroBastidores: Int): Motor(numeroBastidores) {
    var encendido = false
    var revoluciones = 0
    var porcentajeBateria = 20

    override fun arrancar() {
        encendido = true
    }

    override fun detener() {
        encendido = false
    }

    override fun estaArrancado(): Boolean {
        return encendido
    }

    override fun acelerar() {
        revoluciones += 20
    }

    override fun frenar() {
        if (revoluciones == 0) {
        } else {
            revoluciones -= 20
        }
    }

    override fun obtenerRevoluciones(): Int {
        return revoluciones
    }

    override fun obtenerEnergia(): Int{
        return porcentajeBateria

    }

    override fun aumentarEnergia() {
        if (porcentajeBateria == 100){
        } else {
            porcentajeBateria += 20
        }
    }
}