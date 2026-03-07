package es.ies.ejercicios.u6.ej65.dip
import es.ies.ejercicios.u6.ej64.Persona
import es.ies.ejercicios.u6.ej64.Resumible


/**
 * v0 (viola DIP): un módulo de alto nivel depende de un detalle concreto: [InformeCsv].
 * El ejercicio consiste en introducir una abstracción e inyectar dependencias.
 */

interface GenerarInforme {
    fun generar (titulo: String, items: List<Resumible>): String
}

class InformeCsv : GenerarInforme {

    fun cabecera(titulo: String): String = "titulo,$titulo\nitem"

    fun formatearItem(item: Resumible): String = item.resumen().replace(",", ";")

    fun pie(): String = "-- fin --"

    override fun generar(titulo: String, items: List<Resumible>): String {
        val sb = StringBuilder()

        sb.appendLine(cabecera(titulo))

        for (item in items) {
            sb.appendLine(formatearItem(item))
        }

        sb.appendLine(pie())
        return sb.toString()
    }
}

class ControladorInformes(private var generador: GenerarInforme) {

    fun imprimirListado(items: List<Resumible>) {
        val salida = generador.generar("Listado DIP", items)
        println(salida)
    }
}

fun main() {
    val informe = InformeCsv()
    val controller = ControladorInformes(informe)
    controller.imprimirListado(
        listOf(
            Persona("Ana", 20),
            Persona("Luis", 19),
        )
    )
}

