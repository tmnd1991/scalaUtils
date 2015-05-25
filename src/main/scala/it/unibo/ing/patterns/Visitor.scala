package it.unibo.ing.patterns

/**
 * Created by tmnd91 on 08/05/15.
 */
trait Visitor[T<:Visitable] {
  def visit(el: T) : Unit = throw new IllegalArgumentException()
}
