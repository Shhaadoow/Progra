def prom(datos: List[Double]): Double = {
  val promedio = datos.sum / datos.size
  val sumaCuadrados = datos.map(x => math.pow(x - promedio, 2)).sum
  math.sqrt(sumaCuadrados / datos.size)
}
