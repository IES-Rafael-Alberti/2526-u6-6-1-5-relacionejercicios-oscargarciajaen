package es.ies.ejercicios.u6.ej65.srp

import es.ies.ejercicios.u6.ej64.Alumno
import es.ies.ejercicios.u6.ej64.InformeMarkdown
import es.ies.ejercicios.u6.ej64.Persona
import es.ies.ejercicios.u6.ej64.RegistroPersonas
import es.ies.ejercicios.u6.ej64.Resumible

/**
 * v0 (mejorable): demasiadas responsabilidades mezcladas:
 * - prepara datos
 * - normaliza y registra personas
 * - genera informe
 * - hace logs
 */
class InformeAppServiceV0 {
    fun creadorLista(): List<Resumible> {
        println("[SRP:v0] Preparando datos...")
        val items: List<Resumible> = listOf(
            Persona(" Ana ", 20),
            Alumno("Luis", 19, "1DAM"),
            Persona("Marta", 18),
        )
        return items
    }

    fun registrar(items: List<Resumible>) {

        println("[SRP:v0] Registrando personas...")
        val registro = RegistroPersonas()
        for (item in items) {
            if (item is Persona) registro.registrar(item)
        }
    }

    fun generarInforme(items: List<Resumible>): String{
        println("[SRP:v0] Generando informe Markdown...")
        val informe = InformeMarkdown()
        val salida = informe.generar("Listado", items)
        return salida
    }

    fun mostrarSalida(salida: String) {
        println("[SRP:v0] Resultado:")
        println(salida)
    }

    fun buscar(registro: RegistroPersonas) {
        println("[SRP:v0] Buscar 'ana' -> ${registro.buscar("ana")?.resumen()}")

    }
}

fun main() {
    val items = InformeAppServiceV0().creadorLista()
    InformeAppServiceV0().registrar(items)
    val salida = InformeAppServiceV0().generarInforme(items)
    InformeAppServiceV0().mostrarSalida(salida)
    InformeAppServiceV0().buscar(registro = RegistroPersonas())
}



