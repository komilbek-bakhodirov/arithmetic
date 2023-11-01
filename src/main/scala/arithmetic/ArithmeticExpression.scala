package arithmetic

sealed trait ArithmeticExpression

case class Num(value: Int) extends ArithmeticExpression

case class Minus(expr: ArithmeticExpression) extends ArithmeticExpression

case class Plus(left: ArithmeticExpression, right: ArithmeticExpression) extends ArithmeticExpression

case class Mult(left: ArithmeticExpression, right: ArithmeticExpression) extends ArithmeticExpression

case class Div(left: ArithmeticExpression, right: ArithmeticExpression) extends ArithmeticExpression



