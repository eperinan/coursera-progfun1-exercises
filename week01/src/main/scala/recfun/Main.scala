package recfun

object Main {
  def main(args: Array[String]) {

    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if(r == 0 && (r == c)){
      1
    }else if(r==0) {
      0
    }else{
      pascal(c - 1, r - 1) + pascal(c , r - 1)
    }
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {

    def counter(chars: List[Char], count: Int) : Boolean = {
      if(chars.isEmpty) count == 0
      else {
        val char: Char = chars.head
        var auxCount: Int = count

        if(char == '(') {
          auxCount +=1
        }else if(char == ')') {
          auxCount -= 1
        }

        if(auxCount<0) false else counter(chars.tail, auxCount)

      }
    }

    counter(chars, 0)

  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {

    def getChange(moneyLeft: Int, coinsLeft: List[Int]) : Int = {

      if (moneyLeft < 0 || coinsLeft.isEmpty ) 0
      else if(moneyLeft == 0) 1
      else getChange(moneyLeft, coinsLeft.tail) + getChange(moneyLeft - coinsLeft.head, coinsLeft)

    }

    getChange(money, coins)

  }
}
