object TransformacionCalificaciones {

  def transformarCalificaciones(calificaciones: List[Double], politica: Double => Double): List[Double] =
    calificaciones.map(politica)

  val redondear: Double => Double = nota => Math.round(nota).toDouble

  val bonificar: Double => Double = nota => Math.min(nota + 0.5, 10.0)

  val disminuirAltas: Double => Double = nota => if (nota > 9.0) nota - 0.2 else nota

  def main(args: Array[String]): Unit = {
    val originales = List(7.3, 8.9, 9.7, 10.0, 6.4)

    val redondeadas = transformarCalificaciones(originales, redondear)
    println(s"Redondeadas: $redondeadas")

    val bonificadas = transformarCalificaciones(originales, bonificar)
    println(s"Bonificadas: $bonificadas")

    val altasDisminuidas = transformarCalificaciones(originales, disminuirAltas)
    println(s"Altas disminuidas: $altasDisminuidas")
  }
}
