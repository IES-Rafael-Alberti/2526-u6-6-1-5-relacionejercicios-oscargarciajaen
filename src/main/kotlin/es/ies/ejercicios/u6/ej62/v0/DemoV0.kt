package es.ies.ejercicios.u6.ej62.v0

fun main() {
    val generator = ReportGeneratorV0()
    val lines = listOf("Primera línea", "Segunda línea", "Tercera línea")

    println("[v0] Generando CSV...")
    val csv = (generator.selector(ReportFormatV0.CSV, title = "Informe", lines = lines))
    println(csv.generate())

    println("[v0] Generando Markdown...")
    val markdown = (generator.selector(ReportFormatV0.MARKDOWN, title = "Informe", lines = lines))
    println(markdown.generate())
}

