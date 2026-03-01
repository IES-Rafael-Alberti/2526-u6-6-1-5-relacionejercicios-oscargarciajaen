package es.ies.ejercicios.u6.ej61.Especializacion

fun main(){

    println("\nENTRENADOR POKÉMON\n")

    val entrenador: EntrenadorPokemon = EntrenadorPokemon("Josemi")

    entrenador.capturarPokemon()
    entrenador.desafiarGimnasio()

    println("\n==================================================\n ")

    println("ENFERMERA POKÉMON\n")


    val enfermera: EnfermeraPokemon = EnfermeraPokemon("Maria")

    enfermera.capturarPokemon()
    enfermera.desafiarGimnasio()
    enfermera.curarPokemon()

    println("\n==================================================\n ")

    println("MAESTRO POKÉMON\n")

    val maestro: MaestroPokemon = MaestroPokemon("Ash Ketchum")

    maestro.capturarPokemon()
    maestro.desafiarGimnasio()
    maestro.realizarInvestigacion()


}