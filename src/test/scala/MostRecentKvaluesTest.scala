import java.util.Date

import it.unibo.ing.utils.MostRecentKvalues
import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by tmnd91 on 18/04/15.
 */
class MostRecentKvaluesTest extends FlatSpec with Matchers{
  "it " should " work like a map " in{
    val kk = new MostRecentKvalues[String](3)
    val firstDate = new Date()
    kk(firstDate) = "A"
    Thread.sleep(1000)
    val secondDate = new Date()
    kk(secondDate) = "B"
    Thread.sleep(1000)
    kk(new Date()) = "C"
    Thread.sleep(1000)
    kk(new Date()) = "D"
    kk(secondDate) should be ("B")
    //println(kk(firstDate))
  }
}
