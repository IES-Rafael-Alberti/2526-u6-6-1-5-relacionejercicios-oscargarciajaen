package es.ies.ejercicios.u6.ej61.Especializacion

class MaestroPokemon(nombre: String): EntrenadorPokemon(nombre) {
    override var numeroMedallas: Int = 8
    override var pokemonRegistrados: Int = 1000
    var ligasGanadas = 1

    override fun capturarPokemon() {
        pokemonRegistrados += 1
        println("Pokemon capturado")
    }

    override fun desafiarGimnasio() {
        numeroMedallas += 1
        println("Medalla conseguida")
    }

    fun realizarInvestigacion(){
        val aleatorio = kotlin.random.Random.nextInt(1, 11)
        if (aleatorio == 1){
            println("¡Nueva especie descubierta! ")
        } else println("No hay novedades")
    }
}