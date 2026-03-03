package es.ies.ejercicios.u6.ej63

/**
 * Plantilla para el ejercicio 6.3.
 *
 * Completa los TODOs para practicar:
 * - Constructores primarios y secundarios.
 * - Delegación `this(...)` en secundarios.
 * - Llamada a `super(...)` en herencia.
 * - Orden de inicialización (logs en `init`).
 */

open class Figura(
    var color: String,
    val etiqueta: String,
) {
    init {
        println("[Figura:init] color=$color etiqueta=$etiqueta")
    }

    constructor(color: String) : this(color, etiqueta = "sin-etiqueta") {
        println("[Figura:secondary] constructor(color)")
    }
}

class Rectangulo(
    color: String,
    etiqueta: String,
    val ancho: Int,
    val alto: Int,
) : Figura(color, etiqueta) {
    init {
        println("[Rectangulo:init] ancho=$ancho alto=$alto")
    }

    constructor(ancho: Int, alto: Int) : this(
        color = "sin-color",
        etiqueta = "rectangulo",
        ancho = ancho,
        alto = alto,
    ) {
        println("[Rectangulo:secondary] constructor(ancho, alto)")
    }

    constructor(lado: Int, color: String, etiqueta: String, ancho: Int, alto: Int): this(color,etiqueta,ancho = lado,alto = lado) {
        println("[Rectangulo:secondary] constructor(ancho = $lado, alto = $lado)")
    }
}

class Circulo(
    color: String,
    etiqueta: String,
    val radio: Int,
) : Figura(color, etiqueta) {
    init {
        println("[Circulo:init] radio=$radio")
    }

    constructor(area : Double, color: String, etiqueta: String, radio: Int) : this(color, etiqueta, radio){
        println("[Constructor secundario] $area")
    }
}

/*
Ejemplo importante (a implementar por el alumnado): subclase SIN constructor primario.

Objetivo: practicar el caso en el que un constructor secundario puede delegar directamente
al constructor de la clase padre.

Instrucciones:
- Descomenta el código.
- Rellena el hueco `________` con la delegación correcta al constructor padre.
- Sustituye los `TODO(...)` por valores/argumentos adecuados.
*/

class Triangulo : Figura {
    val base: Int
    val altura: Int

    constructor(color: String, etiqueta: String, base: Int, altura: Int) : super(color, etiqueta){
        println("[Triangulo:secondary] constructor(base, altura) -> constructor padre")
        this.color = "Rojo"
        this.base = base
        this.altura = altura
    }

    constructor(lado: Int, color:String, etiqueta: String, base: Int, altura: Int) : this(color, etiqueta, base, altura) {
        println("[Triangulo:secondary] constructor(lado) -> this(base, altura)")
    }
}

