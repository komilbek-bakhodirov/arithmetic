package arithmetic

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.shouldEqual

class ArithmeticExpressionTest extends AnyFunSuite {
  test("ArithmeticExpression should give the correct result"){
    val expr1 = ArithmeticExpression.Plus(ArithmeticExpression.Num(10), ArithmeticExpression.Num(30))
    assert(ArithmeticExpression.evaluate(expr1) == 40)
    assert(ArithmeticExpression.pretty(expr1) == "(10 + 30)")

    val expr2 = ArithmeticExpression.Mult(ArithmeticExpression.Num(1), ArithmeticExpression.Num(3))
    assert(ArithmeticExpression.evaluate(expr2) == 3)
    assert(ArithmeticExpression.pretty(expr2) == "(1 * 3)")

    val expr3 = ArithmeticExpression.Pow(ArithmeticExpression.Num(2), ArithmeticExpression.Num(3))
    assert(ArithmeticExpression.evaluate(expr3) == 8)
    assert(ArithmeticExpression.pretty(expr3) == "(2^3)")
  }

  test("Method correctly evaluates"){
    val evalExpr = ArithmeticExpression.Plus(ArithmeticExpression.Num(2), ArithmeticExpression.Num(0))
    assert(ArithmeticExpression.evaluate(evalExpr) == 2)
  }

  test("Method correctly shows results"){
    val expressionsList = List(
      ArithmeticExpression.Plus(ArithmeticExpression.Num(1), ArithmeticExpression.Num(2)),
      ArithmeticExpression.Mult(ArithmeticExpression.Num(3), ArithmeticExpression.Num(4))
    )
    val expectedOutput = "(1 + 2) = 3.0\n(3 * 4) = 12.0\n"
    ArithmeticExpression.showResults(expressionsList) shouldEqual expectedOutput
  }
}
