package es.ies.ejercicios.u6.ej61.Especificacion

fun main(){

    println("\nMOTOR ELÉCTRICO\n")

    val motorElectrico: MotorElectrico = MotorElectrico(12345)

    motorElectrico.arrancar()
    println("Pulsa el botón de encender y el motor se enciende")
    motorElectrico.estaArrancado()
    println("Motor arrancado")
    motorElectrico.acelerar()
    println("Motor acelera")
    val revolucioneElectrico = motorElectrico.obtenerRevoluciones()
    println(revolucioneElectrico)
    motorElectrico.frenar()
    println("Frena")
    motorElectrico.frenar()
    println("Frenado al máximo")
    val bateria = motorElectrico.obtenerEnergia()
    println(bateria)
    motorElectrico.aumentarEnergia()
    println("Cargando")
    motorElectrico.detener()
    println("Pulsa el boton de apagar y el motor se detiene")

    println("\n==================================================\n ")

    println("MOTOR COMBUSTIÓN\n")

    val motorCobustion: MotorCobustion = MotorCobustion(12346)

    motorCobustion.arrancar()
    println("Gira la llave y arranca")
    motorCobustion.estaArrancado()
    println("Esta arrancado")
    motorCobustion.acelerar()
    println("Acelera")
    val revolucionesCombustion = motorCobustion.obtenerRevoluciones()
    println(revolucionesCombustion)
    motorCobustion.frenar()
    println("Frena")
    motorCobustion.frenar()
    println("Frenado al maximo")
    val combustible = motorCobustion.obtenerEnergia()
    println(combustible)
    motorCobustion.aumentarEnergia()
    println("Echa gasolina")
    motorCobustion.detener()
    println("Detiene el motor")
}