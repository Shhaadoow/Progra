case class Producto(nombre: String, categoria: String, precios: List[Double])
case class ProductoPromedio(producto: Producto, promedio: Double)

def productoMasValioso(
                        productos: List[Producto],
                        valorBase: Double,
                        minPrecios: Int
                      ): Option[ProductoPromedio] = {


  val filtrados = productos.filter { p =>
    p.precios.length >= minPrecios &&
      p.precios.max > valorBase
  }


  val promedios = filtrados.map { p =>
    var suma = 0.0
    var count = 0
    for (precio <- p.precios) {
      suma += precio
      count += 1
    }
    val promedio = if (count > 0) suma / count else 0.0
    ProductoPromedio(p, promedio)
  }

    if (promedios.isEmpty) None
  else {
    var mejor = promedios.head
    for (pp <- promedios.tail) {
      if (pp.promedio > mejor.promedio) {
        mejor = pp
      }
    }
    Some(mejor)
  }
}