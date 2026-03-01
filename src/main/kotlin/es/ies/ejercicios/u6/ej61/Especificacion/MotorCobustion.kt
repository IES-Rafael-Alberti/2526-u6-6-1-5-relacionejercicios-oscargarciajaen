package es.ies.ejercicios.u6.ej61.Especificacion

class MotorCobustion(numeroBastidores: Int): Motor(numeroBastidores) {
    var arrancado = false
    var revoluciones = 0
    var combustible = 20

    override fun arrancar() {
        println("Introduce la llave, la gira y el motor arranca")
        arrancado = true
    }

    override fun detener() {
        println("Gira la llave de nuevo y el motor se detiene")
        arrancado = false
    }

    override fun estaArrancado(): Boolean {
        return arrancado
    }

    override fun acelerar() {
        println("El motor acelera")
        revoluciones += 20
    }

    override fun frenar() {
        if (revoluciones == 0){
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

    override fun obtenerEnergia(): Int {
        println("Tiene ${combustible} litros")
        return combustible
    }

    override fun aumentarEnergia() {
        if (combustible == 100){
            println("Energía al máximo")
        } else {
            combustible += 20
            println("Echando combustible")
        }
    }
}