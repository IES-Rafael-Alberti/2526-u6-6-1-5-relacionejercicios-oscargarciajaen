package es.ies.ejercicios.u6.ej65.lsp

import es.ies.ejercicios.u6.ej64.Persona

/**
 * Contrato: un repositorio que permite guardar y buscar personas.
 */
interface RepositorioPersonasV0Guardar {
    fun guardar(persona: Persona)
}

interface RepositorioPersonasV0Buscar{
    fun buscar(nombre: String): Persona?
}

class RepositorioWRV0 : RepositorioPersonasV0Guardar, RepositorioPersonasV0Buscar {
    private val map = mutableMapOf<String, Persona>()

    override fun guardar(persona: Persona) {
        map[persona.nombre] = persona
    }

    override fun buscar(nombre: String) = map[nombre]

}

class RepositorioSoloLecturaV0 : RepositorioPersonasV0Buscar {
    private val map = mutableMapOf<String, Persona>()

    override fun buscar(nombre: String) = map[nombre]
}


fun cliente(repo: RepositorioWRV0) {
    repo.guardar(Persona("Ana", 20))
    println("Buscar Ana -> ${repo.buscar("Ana")?.resumen()}")
}

fun main() {
    println("[LSP:v0] Repositorio normal (ok)")
    cliente(RepositorioWRV0())
    /*
    println("\n[LSP:v0] Repositorio solo lectura (rompe sustitución)")
    try {
        cliente(RepositorioSoloLecturaV0())
    } catch (e: Exception) {
        println("ERROR: ${e::class.simpleName}: ${e.message}")
    }
     */
}

