package es.ies.ejercicios.u6.ej61.Especificacion

fun main(){

    println("\nMOTOR ELÉCTRICO\n")

    val motorElectrico: MotorElectrico = MotorElectrico(12345)

    motorElectrico.arrancar()
    motorElectrico.estaArrancado()
    motorElectrico.acelerar()
    motorElectrico.obtenerRevoluciones()
    motorElectrico.frenar()
    motorElectrico.frenar()
    motorElectrico.obtenerEnergia()
    motorElectrico.aumentarEnergia()
    motorElectrico.detener()

    println("\n==================================================\n ")

    println("MOTOR COMBUSTIÓN\n")

    val motorCobustion: MotorCobustion = MotorCobustion(12346)

    motorCobustion.arrancar()
    motorCobustion.estaArrancado()
    motorCobustion.acelerar()
    motorCobustion.obtenerRevoluciones()
    motorCobustion.frenar()
    motorCobustion.frenar()
    motorCobustion.obtenerEnergia()
    motorCobustion.aumentarEnergia()
    motorCobustion.detener()
}