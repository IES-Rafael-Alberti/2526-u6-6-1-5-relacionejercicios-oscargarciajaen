package es.ies.ejercicios.u6.ej61.Especializacion

import kotlin.random.Random

class EnfermeraPokemon(nombre : String): EntrenadorPokemon(nombre) {
    override var pokemonRegistrados = 0
    override var numeroMedallas = 0
    var pokemonCurados = 0

    override fun desafiarGimnasio(){
        numeroMedallas += 1
        println("Medalla conseguida")
    }

    override fun capturarPokemon() {
        val aleatorio = kotlin.random.Random.nextInt(1,4)
        if (aleatorio == 1){
            pokemonRegistrados += 1
            println("Pokemon capturado")
        } else println("Se ha escapado")
    }

    fun curarPokemon(){
        println("Cura un pokemon")
    }
}