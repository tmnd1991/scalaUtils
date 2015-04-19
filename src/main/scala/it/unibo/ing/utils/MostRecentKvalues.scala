package it.unibo.ing.utils

import java.util.Date

import scala.collection.immutable.TreeMap

/**
 * Created by tmnd91 on 18/04/15.
 */
class MostRecentKvalues[T](val k: Int = 150) {
  private var _innerMap = new TreeMap[Date,T]()
  private var _count = 0
  def apply(d: Date) : T = _innerMap(d)

  def update(d: Date, x: T) : Unit = {
    _innerMap += d -> x
    inc()
    if (count > k)
      removeOldest
  }

  private def count() : Int = {
    synchronized{ _count }
  }
  private def inc() : Unit = {
    synchronized{ _count += 1 }
  }
  private def removeOldest() : Unit = {
    synchronized{
      val toRemove = _count - k
      if (toRemove > 0){
        _innerMap.keys.toList.sorted.take(toRemove).foreach(_innerMap -= _)
      }
    }
  }
  def isLatest(d: Date) : Boolean = synchronized{
    if (_innerMap isEmpty) true
    else d after _innerMap.keys.toList.sorted.last
  }

  def contains(d: Date) : Boolean = synchronized{
    _innerMap contains d
  }

  def between(s: Date, e: Date) : Iterable[T] = synchronized{
    _innerMap.keys.filter(x => (x after s) && (x before e)).map(_innerMap(_))
  }

  def keys : Seq[Date] = _innerMap.keys.toSeq
}
