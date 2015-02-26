package it.unibo.ing


/**
 * Created by tmnd91 on 09/01/15.
 */
package object utils {
  implicit def StringToRichString(s : String) = new RichString(s)
  class RichString(s : String) {
    def mySubstring(beginIndex : Int, endIndex : Int) : String = {
      val rightEndIndex = if (endIndex < 0) s.length+endIndex
      else endIndex
      s.substring(beginIndex, rightEndIndex)
    }
    def `/` (x : String) = combine(s.toString, x)
  }


  implicit class RichCollection[A, Repr](xs: scala.collection.IterableLike[A, Repr]){
    def distinctBy[B, That](f: A => B)(implicit cbf: scala.collection.generic.CanBuildFrom[Repr, A, That]) = {
      val builder = cbf(xs.repr)
      val i = xs.iterator
      var set = Set[B]()
      while (i.hasNext) {
        val o = i.next
        val b = f(o)
        if (!set(b)) {
          set += b
          builder += o
        }
      }
      builder.result
    }
  }

  implicit class RichURI(u : java.net.URI){
    import java.net.URI
    def / (s : String) = new URI(combine(u.toString, s))
    def / (s : URI) = new URI(combine(u.toString, s.toString))
  }

  implicit class RichURL(u : java.net.URL){
    import java.net.URL
    def / (s : String) = new URL(combine(u.toString, s))
    def / (u2 : URL) = new URL(combine(u.toString, u2.toString))
  }

  def combine (s1 :String, s2 :String) = {
    require(s1.nonEmpty)
    if (s2 isEmpty){
      if (s1.takeRight(1) == '/') s1
      else s1 + '/'
    }
    else{
      val ss = s1.takeRight(1) + s2(0)
      ss.count(_ == '/') match{
        case 0 => s1 + "/" + s2
        case 1 => s1 + s2
        case 2 => s1 + s2.substring(1)
      }
    }
  }

  implicit class RichDate(d : java.util.Date){
    def - (d2 : java.util.Date) = d.getTime - d2.getTime
  }
}
