extension(nums: List[Int])
  def perfectos: List[Int] =
    def sumDivProp(num: Int): Int =
      (1 until num).filter(num % _ == 0).sum
    nums.filter(num => num == sumDivProp(num))

def perfecto(nums: List[Int]): List[Int] = nums.perfectos

val lista = List(1, 6, 10, 28, 496)
println(lista.perfectos)
