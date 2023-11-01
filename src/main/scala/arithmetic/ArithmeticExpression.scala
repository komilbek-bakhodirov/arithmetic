package arithmetic

enum ArithmeticExpression:
  case Num(value: Int)
  case Minus(operation: ArithmeticExpression)
  case Plus(left: ArithmeticExpression, right: ArithmeticExpression)
  case Mult(left: ArithmeticExpression, right: ArithmeticExpression)
  case Div(left: ArithmeticExpression, right: ArithmeticExpression)

object ArithmeticExpression:
  def evaluate(expression:ArithmeticExpression): Double = expression match
    case Num(value) => value.toDouble
    case Minus(expr) => -evaluate(expr)
    case Plus(left, right) => evaluate(left) + evaluate(right)
    case Mult(left, right) => evaluate(left) * evaluate(right)
    case Div(left, right) => evaluate(left) / evaluate(right)

  def pretty(expression:ArithmeticExpression) : String = expression match
    case Num(value) => value.toString
    case Minus(expr) => s"-${pretty(expr)}"
    case Plus(left, right) => s"(${pretty(left)} + ${pretty(right)})"
    case Mult(left, right) => s"(${pretty(left)} * ${pretty(right)})"
    case Div(left, right) => s"(${pretty(left)} / ${pretty(right)})"

