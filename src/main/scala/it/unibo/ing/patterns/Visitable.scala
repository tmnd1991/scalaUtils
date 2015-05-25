package it.unibo.ing.patterns

/**
 * Created by tmnd91 on 08/05/15.
 */
trait Visitable {
  def accept(v: Visitor[this.type])
}
