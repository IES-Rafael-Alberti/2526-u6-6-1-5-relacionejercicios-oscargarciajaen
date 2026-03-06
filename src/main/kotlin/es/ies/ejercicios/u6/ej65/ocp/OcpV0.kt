package es.ies.ejercicios.u6.ej65.ocp

import es.ies.ejercicios.u6.ej64.Resumible

enum class FormatoInformeV0 {
    CSV,
    MARKDOWN,
    HTML,
}

/**
 * v0 (viola OCP): para añadir un nuevo formato hay que modificar este `when`.
 */

abstract class Generador(){
    abstract fun generar() : String
}

class GenerarCSV (val titulo : String, val items: List<Resumible>): Generador() {

    override fun generar(): String =
        buildString {
            appendLine("titulo,$titulo")
            appendLine("item")
            for (item in items) appendLine(item.resumen().replace(",", ";"))
        }
}

class GenerarMarkdown (val titulo : String, val items: List<Resumible>): Generador() {
    override fun generar(): String =
        buildString {
            appendLine("# $titulo")
            for (item in items) appendLine("- ${item.resumen()}")
        }
}

class GenerarHTML (val titulo : String, val items: List<Resumible>): Generador() {
    override fun generar(): String =
        buildString {
            appendLine("<h1> $titulo </h1>")
            for (item in items) appendLine("<li> ${item.resumen()} </li>")
        }

}

class GeneradorInformeV0 {
    fun seleccionar(formato: FormatoInformeV0, titulo: String, items: List<Resumible>): Generador =
        when (formato) {
            FormatoInformeV0.CSV -> GenerarCSV(titulo, items)
            FormatoInformeV0.MARKDOWN -> GenerarMarkdown(titulo, items)
            FormatoInformeV0.HTML -> GenerarHTML(titulo, items)
        }

}

fun main() {
    val items = listOf<Resumible>(
        object : Resumible {
            override fun resumen(): String = "Elemento A"
        },
        object : Resumible {
            override fun resumen(): String = "Elemento B"
        },
    )

    val fabrica = GeneradorInformeV0()
    val generador = (fabrica.seleccionar(FormatoInformeV0.HTML, "Demo OCP", items))
    println(generador.generar())
}

