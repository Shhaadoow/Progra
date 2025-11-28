// ¿Cuantos goles se han marcado en total los goleadores?
goleadores2025.map(_.goles).sum

//¿Cuales son los nombre de los equipos presentes en la lista?
goleadores2025.map(_.equipo).distinct.sorted

// ¿Cuál es el promedio de partidos que han jugado los goleadores?
goleadores2025.map(_.partidos).sum.toDouble / goleadores2025.size

// ¿Calcular la efectividad de los goleadores?
goleadores2025.map(g => g.goles.toDouble / g.partidos)

// ¿Cuales son los goleadores del equipo libertad?
goleadores2025.filter(_.equipo == "Libertad (Ecuador)").map(_.nombre)

/* ¿Cuales son los equipos que tienen goleadores con un
numero de goles mayor al promedio? */
goleadores2025.filter(_.goles > (goleadores2025.map(_.goles)
  .sum.toDouble / goleadores2025.size))
.map(_.equipo).sorted.distinct

/* ¿Cuales son los equipos que tiene(n) la mayor cantidad
de goleadores? */
val conteoPorEquipo: Map[String, Int] =
  goleadores2025.groupBy(_.equipo).view.mapValues(_.size).toMap

val maxCount = conteoPorEquipo.values.max

val equiposTop = conteoPorEquipo.filter {
  case (_, count) => count == maxCount }.keys