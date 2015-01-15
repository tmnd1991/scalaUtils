import java.net.{URL, URI}

import it.unibo.ing.utils._
import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by tmnd91 on 09/01/15.
 */
class RichUriTest extends FlatSpec with Matchers{
  "this pimp " should " work with uris with no /" in{
    val uri = new URI("http://localhost:8080")
    val combined = uri / "ciccio"
    combined.toString should be ("http://localhost:8080/ciccio")
  }

  "this pimp " should " work with url with no / " in{
    val url = new URL("http://localhost:8080")
    val combined = url / "ciccio"
    combined.toString should be ("http://localhost:8080/ciccio")
  }

  "this pimp " should " work with uris with double /" in{
    val uri = new URI("http://localhost:8080/")
    val combined = uri / "/ciccio"
    combined.toString should be ("http://localhost:8080/ciccio")
  }

  "this pimp " should " work with url with double / " in{
    val url = new URL("http://localhost:8080/")
    val combined = url / "/ciccio"
    combined.toString should be ("http://localhost:8080/ciccio")
  }
  "this pimp " should " work with uris with one / in the first" in{
    val uri = new URI("http://localhost:8080")
    val combined = uri / "/ciccio"
    combined.toString should be ("http://localhost:8080/ciccio")
  }

  "this pimp " should " work with url with one / in the first" in{
    val url = new URL("http://localhost:8080")
    val combined = url / "/ciccio"
    combined.toString should be ("http://localhost:8080/ciccio")
  }

  "this pimp " should " work with uris with one / in the second" in{
    val uri = new URI("http://localhost:8080/")
    val combined = uri / "ciccio"
    combined.toString should be ("http://localhost:8080/ciccio")
  }

  "this pimp " should " work with url with one / in the second" in{
    val url = new URL("http://localhost:8080/")
    val combined = url / "ciccio"
    combined.toString should be ("http://localhost:8080/ciccio")
  }
}