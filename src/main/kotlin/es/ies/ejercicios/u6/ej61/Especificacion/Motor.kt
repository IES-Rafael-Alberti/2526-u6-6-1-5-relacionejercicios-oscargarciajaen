package es.ies.ejercicios.u6.ej61.Especificacion

abstract class Motor(numeroBastidores: Int) {

    abstract fun arrancar()

    abstract fun detener()

    abstract fun estaArrancado(): Boolean

    abstract fun acelerar()

    abstract fun frenar()

    abstract fun obtenerRevoluciones(): Int

    abstract fun obtenerEnergia() : Int

    abstract fun aumentarEnergia()
}