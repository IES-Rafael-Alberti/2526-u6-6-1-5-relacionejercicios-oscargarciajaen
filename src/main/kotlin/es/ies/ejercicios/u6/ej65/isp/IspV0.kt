package es.ies.ejercicios.u6.ej65.isp

import es.ies.ejercicios.u6.ej64.Persona

interface RepositorioPersonasModificar {
    fun guardar(persona: Persona)
    fun exportarCsv(): String
    fun borrarTodo()
}

interface RepositorioBuscarPersona {
    fun buscar(nombre: String): Persona?
}

class RepositorioMemoriaV0 : RepositorioPersonasModificar, RepositorioBuscarPersona {
    private val map = mutableMapOf<String, Persona>()

    override fun guardar(persona: Persona) {
        map[persona.nombre] = persona
    }

    override fun buscar(nombre: String): Persona? = map[nombre]

    override fun exportarCsv(): String =
        buildString {
            appendLine("nombre,edad")
            for (p in map.values) appendLine("${p.nombre},${p.edad}")
        }

    override fun borrarTodo() {
        map.clear()
    }
}

class BuscadorPersonasV0(private val repo: RepositorioBuscarPersona) {
    fun buscar(nombre: String): Persona? = repo.buscar(nombre)
}

fun main() {
    val repo = RepositorioMemoriaV0()
    repo.guardar(Persona("Ana", 20))

    val buscador = BuscadorPersonasV0(repo)
    println("Buscar Ana -> ${buscador.buscar("Ana")?.resumen()}")
}

