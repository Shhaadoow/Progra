object Ejercicios {

  // ---------------------------------------------------------------
  // EJERCICIO 1: Versión funcional del método Java (desviación típica)
  // ---------------------------------------------------------------

  def prom(datos: List[Double]): Double = {
    val promedio = datos.sum / datos.size
    val varianza = datos.map(x => math.pow(x - promedio, 2)).sum / datos.size
    math.sqrt(varianza)
  }


  // ---------------------------------------------------------------
  // EJERCICIO 2: Transformación de calificaciones con función política
  // ---------------------------------------------------------------

  def transformar(calificaciones: List[Double])(politica: Double => Double): List[Double] =
    calificaciones.map(politica)

  val redondear: Double => Double =
    nota => Math.round(nota).toDouble

  val bonificar: Double => Double =
    nota => math.min(nota + 0.5, 10.0)

  val disminuirAltas: Double => Double =
    nota => if (nota > 9) nota - 0.2 else nota


  // ---------------------------------------------------------------
  // EJERCICIO 3: Convertir función anónima en función con nombre
  // ---------------------------------------------------------------

  def generadorSaludo(fraseBase: String): String => String =
    nombre => s"$fraseBase, $nombre!"


  // ---------------------------------------------------------------
  // MAIN (para probar todo junto si quieres ejecutar)
  // ---------------------------------------------------------------

  def main(args: Array[String]): Unit = {

    // Prueba del ejercicio 1
    val datos = List(1.0, 2.0, 3.0, 4.0)
    println(s"Desviación calculada: ${prom(datos)}")

    // Prueba del ejercicio 2
    val originales = List(7.3, 8.9, 9.7, 10.0, 6.4)
    println(s"Redondeadas:       ${transformar(originales)(redondear)}")
    println(s"Bonificadas:        ${transformar(originales)(bonificar)}")
    println(s"Altas disminuidas:  ${transformar(originales)(disminuirAltas)}")

    // Prueba del ejercicio 3
    val saludo = generadorSaludo("Buenas tardes")
    println(saludo("Pablo"))
  }
}