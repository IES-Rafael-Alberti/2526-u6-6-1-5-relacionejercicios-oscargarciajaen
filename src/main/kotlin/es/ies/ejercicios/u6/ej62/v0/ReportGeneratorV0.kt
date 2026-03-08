package es.ies.ejercicios.u6.ej62.v0

/**
 * Versión base (v0): NO usa clase abstracta.
 *
 * Problema: al añadir un nuevo formato, tiende a crecer el `when` y se mezclan decisiones
 * (formato, cabeceras, pie, etc.) en una única clase.
 */
class ReportGeneratorV0 {
    fun selector(format: ReportFormatV0, title: String, lines: List<String>): Generator {
        return when (format) {
            ReportFormatV0.CSV -> GenerateCsv(title, lines)
            ReportFormatV0.MARKDOWN -> GenerateMarkdown(title, lines)
        }
    }
}


abstract class Generator(title: String, lines: List<String>) {
    abstract fun generate(): String
}

class GenerateCsv(private val title: String, private val lines: List<String>) : Generator(title, lines) {

    override fun generate(): String =
        buildString {
            appendLine("title,$title")
            appendLine("line")
            for (line in lines) appendLine(line)
        }

}

class GenerateMarkdown(private val title: String, private val lines: List<String>) : Generator(title, lines) {

    override fun generate(): String =
        buildString {
            appendLine("# $title")
            for (line in lines) appendLine("- $line")
        }
}

