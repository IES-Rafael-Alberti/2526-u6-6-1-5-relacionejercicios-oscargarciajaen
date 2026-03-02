package es.ies.ejercicios.u6.ej61.Especificacion

class MotorCobustion(numeroBastidores: Int): Motor(numeroBastidores) {
    var arrancado = false
    var revoluciones = 0
    var combustible = 20

    override fun arrancar() {
        arrancado = true
    }

    override fun detener() {
        arrancado = false
    }

    override fun estaArrancado(): Boolean {
        return arrancado
    }

    override fun acelerar() {
        revoluciones += 20
    }

    override fun frenar() {
        if (revoluciones == 0){
        } else {
            revoluciones -= 20
        }
    }

    override fun obtenerRevoluciones(): Int {
        return revoluciones
    }

    override fun obtenerEnergia(): Int {
        return combustible
    }

    override fun aumentarEnergia() {
        if (combustible == 100){
        } else {
            combustible += 20
        }
    }
}