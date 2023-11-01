package arithmetic

import org.scalatest.funsuite.AnyFunSuite

class ArithmeticExpressionTest extends AnyFunSuite {
  test("ArithmeticExpression should give the correct result"){
    val expr1 = ArithmeticExpression.Plus(ArithmeticExpression.Num(10), ArithmeticExpression.Num(30))
    assert(ArithmeticExpression.evaluate(expr1) == 40)
    assert(ArithmeticExpression.pretty(expr1) == "(10 + 30)")

    val expr2 = ArithmeticExpression.Mult(ArithmeticExpression.Num(1), ArithmeticExpression.Num(3))
    assert(ArithmeticExpression.evaluate(expr2) == 3)
    assert(ArithmeticExpression.pretty(expr2) == "(1 * 3)")
  }
}
