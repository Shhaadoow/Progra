def generadorSaludo(fraseBase: String): String => String =
  (nombre: String) => s"$fraseBase, $nombre!"