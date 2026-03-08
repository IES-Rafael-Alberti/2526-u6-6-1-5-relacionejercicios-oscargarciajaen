package es.ies.ejercicios.u6.ej63

/**
 * Ejercicio 6.3 — Incidencia de constructores en la herencia (RA7.c).
 *
 * Punto de partida: revisa `Figuras.kt` y completa lo indicado en `docs/ejercicios/6.3.md`.
 */
object Ej63

fun main() {
    val figura = Figura("Rojo", "...")
    val figura2 = Figura("Rojo")
    val rectangulo = Rectangulo(22,21)
    val rectangulo2 = Rectangulo(22, "Rojo", "...", 22, 22)
    val circulo = Circulo(22.2,"Rojo","...", 40)
    val triangulo = Triangulo("Rojo", "...", 12, 15)
    val triangulo2 = Triangulo(12,"Rojo", "...", 12, 15)
}
