package es.ies.ejercicios.u6.ej61.Especificacion

class MotorCobustion(numeroBastidores: Int): Motor(numeroBastidores) {
    var arrancado = false
    var revoluciones = 0
    var combustible = 20

    override fun arrancar() {
        println("Inserta la llave, la gira y arranca el motor")
        arrancado = true
    }

    override fun detener() {
        println("Gira la llave y se detiene el motor")
        arrancado = false
    }

    override fun estaArrancado(): Boolean {
        if (arrancado) {
            println("Motor encendido")
        } else println("Motor apagado")
        return arrancado
    }

    override fun acelerar() {
        revoluciones += 20
        println("${revoluciones} revoluciones")
    }

    override fun frenar() {
        if (revoluciones == 0){
            println("Motor frenado al máximo")
        } else {
            revoluciones -= 20
            println("Frenando")
        }
    }

    override fun obtenerRevoluciones(): Int {
        println("Revoluciones : ${revoluciones}")
        return revoluciones
    }

    override fun obtenerEnergia(): Int {
        println("${combustible} litros")
        return combustible
    }

    override fun aumentarEnergia() {
        if (combustible == 100){
            println("Combustible al máximo")
        } else {
            combustible += 20
            println("Echando combustible")
        }
    }
}