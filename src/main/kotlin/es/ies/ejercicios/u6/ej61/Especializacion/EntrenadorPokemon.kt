package es.ies.ejercicios.u6.ej61.Especializacion

import kotlin.random.Random

open class EntrenadorPokemon(val nombre: String) {
    open var numeroMedallas = 0
    open var pokemonRegistrados = 0

    open fun desafiarGimnasio(){
        val aleatorio = kotlin.random.Random.nextInt(1, 3)
        if (aleatorio == 1){
            numeroMedallas += 1
            println("Medalla conseguida")
        } else println("Medalla no conseguida")
    }

    open fun capturarPokemon(){
        val aleatorio = kotlin.random.Random.nextInt(1, 5)
        if (aleatorio == 1){
            pokemonRegistrados += 1
            println("Pokemon capturado")
        } else println("Se ha escapado el pokemon")
    }
}