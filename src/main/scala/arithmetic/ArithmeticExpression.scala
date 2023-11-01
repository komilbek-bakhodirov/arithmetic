package arithmetic

enum ArithmeticExpression:
  case Num(value: Int)
  case Minus(operation: ArithmeticExpression)
  case Plus(left: ArithmeticExpression, right: ArithmeticExpression)
  case Mult(left: ArithmeticExpression, right: ArithmeticExpression)
  case Div(left: ArithmeticExpression, right: ArithmeticExpression)
  case Pow(x: ArithmeticExpression, y: ArithmeticExpression)

object ArithmeticExpression:
  def evaluate(expression:ArithmeticExpression): Double = expression match
    case Num(value) => value.toDouble
    case Minus(expr) => -evaluate(expr)
    case Plus(left, right) => evaluate(left) + evaluate(right)
    case Mult(left, right) => evaluate(left) * evaluate(right)
    case Div(left, right) => evaluate(left) / evaluate(right)
    case Pow(x, y) if evaluate(y) > 0 => evaluate(x) * evaluate(Pow(x,Plus(y,Minus(Num(1))))) //evaluate(num) * evaluate(Pow(num,Plus(pow,Minus(Num(1)))))
                                              // evaluate(x) * evaluate(Pow(x,Plus(y,Minus(Num(1)))))
    case Pow(x, y) if evaluate(y) < 0 => 1 / evaluate(x) * evaluate(Pow(x,Plus(x, Num(1))))
    case Pow(x, y) if evaluate(y) == 0 => 1

  def evaluate(expressions: List[ArithmeticExpression]): List[Double] = {
    expressions.map(evaluate)
  }


  def pretty(expression:ArithmeticExpression) : String = expression match
    case Num(value) => value.toString
    case Minus(operation) => s"-${pretty(operation)}"
    case Plus(left, right) => s"(${pretty(left)} + ${pretty(right)})"
    case Mult(left, right) => s"(${pretty(left)} * ${pretty(right)})"
    case Div(left, right) => s"(${pretty(left)} / ${pretty(right)})"
    case Pow(num, pow) => s"(${pretty(num)}^${pretty(pow)})"

  def showResults(expressions: List[ArithmeticExpression]): String = {
    expressions.map { expr => s"${pretty(expr)} = ${evaluate(expr)}"
    }.mkString("\n") + "\n"
  }
