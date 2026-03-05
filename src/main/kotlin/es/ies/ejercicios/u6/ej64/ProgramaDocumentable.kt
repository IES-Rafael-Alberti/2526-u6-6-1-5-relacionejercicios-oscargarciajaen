package es.ies.ejercicios.u6.ej64

// Este fichero contiene ejemplos de:
// - herencia (6.1)
// - clase abstracta e interfaces (6.2)
// - constructores e init en herencia (6.3)
//
// Tu tarea (6.4) es:
// - Entender el código y su relación entre clases e interfaces.
// - Mejorar la documentación KDoc donde sea necesario.
// - Añadir comentarios solo cuando aporten valor.
// - Eliminar comentarios innecesarios o redundantes.

/**
 * Representa un elemento del que se puede hacer un resumen.
 */
interface Resumible {
    fun resumen(): String
}

/**
 * Representa una plantilla para generar informes.
 *
 * Esta clase se encarga de generar informes mediante sus métodos, extiende de Resumible.
 */
abstract class PlantillaInforme : Resumible {

    /**
     * Genera los informes.
     *
     * @param titulo El título del informe
     * @param items El conjunto de datos para generar el informe
     * @return Un string con el informe
     */
    fun generar(titulo: String, items: List<Resumible>): String {

        val sb = StringBuilder()

        sb.appendLine(cabecera(titulo))

        for (item in items) {
            sb.appendLine(formatearItem(item))
        }

        sb.appendLine(pie())
        return sb.toString()
    }

    /**
     * Genera la representación visual de la cabecera del informe.
     *
     * @param titulo El título del informe.
     * @return El título del informe.
     */
    protected open fun cabecera(titulo: String): String = titulo

    /**
     * Define cómo se ve el objeto.
     *
     * @param item El objeto que implementa la interfaz [Resumible] a procesar.
     * @return El texto formateado como indica el item.
     */
    protected abstract fun formatearItem(item: Resumible): String

    /**
     * Genera el pie del informe.
     * * @return Una cadena de texto fija por defecto ("-- fin --").
     */
    protected open fun pie(): String = "-- fin --"

    /**
     * Genera un resumen.
     *
     * * @return El nombre estático "PlantillaInforme".
     */
    override fun resumen(): String = "PlantillaInforme"
}


/**
 * Clase para generar informes en markdown
 *
 * @see PlantillaInforme
 */
class InformeMarkdown : PlantillaInforme() {

    /**
     * @inheritDoc
     * En esta implementación se genera el título pero en markdown.
     * @return Devuelve el título con # delante
     */
    override fun cabecera(titulo: String): String = "# $titulo"

    /**
     * @inheritDoc
     *
     * Esta función formatea la información añadiendo un guion al principio
     *
     * @param item
     *
     * @return Devuelve el resumen del item con un guion delante
     */
    override fun formatearItem(item: Resumible): String = "- ${item.resumen()}"
}

/**
 * Clase para generar informes en Csv
 *
 * @see PlantillaInforme
 */
class InformeCsv : PlantillaInforme() {

    /**
     * @inheritDoc
     * En esta implementación se genera el título pero en Csv.
     * @return Devuelve el título en formato Csv
     */
    override fun cabecera(titulo: String): String = "titulo,$titulo\nitem"

    /**
     * @inheritDoc
     *
     * Esta función formatea la información para el formato Csv
     *
     * @param item
     *
     * @return Devuelve el resumen del item formateado en Csv
     */
    override fun formatearItem(item: Resumible): String = item.resumen().replace(",", ";")
}

/**
 * Representa una persona.
 *
 * @property nombre Es el nombre de la persona
 *
 * @property edad Es la edad de la persona
 *
 * @see Resumible
 */
open class Persona(
    val nombre: String,
    val edad: Int,
) : Resumible {
    init {
        println("[Persona:init] nombre=$nombre edad=$edad")
    }

    /**
     * @param constructor Es el constructor secundario de la clase persona
     *
     * @property nombre Es el nombre de la persona
     */
    constructor(nombre: String) : this(nombre, edad = 0) {
        println("[Persona:secondary] constructor(nombre)")
    }

    /**
     * Genera un resumen.
     *
     * * @return nombre + edad
     */
    override fun resumen(): String = "$nombre ($edad)"
}


/**
 * Representa un alumno
 */
class Alumno : Persona {
    val curso: String

    /**
     * Es el constructor secundario de la clase alumno
     *
     * @property nombre Es el nombre del alumno
     *
     * @property edad Es la edad del alumno
     *
     * @property curso Es el curos al que asiste el alumno
     */
    constructor(nombre: String, edad: Int, curso: String) : super(nombre, edad) {
        this.curso = curso
        println("[Alumno:secondary] nombre=$nombre edad=$edad curso=$curso")
    }

    /**
     * Es el segundo constructor secundario de la clase alumno
     *
     * @property nombre Es el nombre del alumno
     *
     * @property curso Es el curso al que asiste el alumno
     */
    constructor(nombre: String, curso: String) : this(nombre, edad = 0, curso = curso) {
        println("[Alumno:secondary] constructor(nombre, curso)")
    }

    /**
     * Crea un resumen con la información del alumno
     *
     * @return El resumen de la clase padre + el curso del alumno
     */
    override fun resumen(): String = "Alumno: ${super.resumen()} curso=$curso"
}

/**
 * Representa un registro de personas
 */
class RegistroPersonas {
    private val personasPorNombre = mutableMapOf<String, Persona>()

    /**
     * Registra a la persona al registro "personasPorNombre"
     *
     * @param persona Es un objeto de la clase persona
     */
    fun registrar(persona: Persona) {
        val clave = normalizarNombre(persona.nombre)
        personasPorNombre[clave] = persona
    }

    /**
     * Se encarga de buscar los datos de una persona por su nombre
     *
     * @param nombre Es el la clave del diccionario
     * @return Retorna la persona si existe dentro del diccionario, si no, retorna null
     */
    fun buscar(nombre: String): Persona? = personasPorNombre[normalizarNombre(nombre)]

    /**
     * Se encarga de eliminar los espacios y poner los nombres en minúsculas
     *
     * @param nombre Es el nombre de la persona
     * @return Retorna el nombre sin espacios y en minúsculas
     */
    private fun normalizarNombre(nombre: String): String {
        return nombre.trim().lowercase()
    }
}
