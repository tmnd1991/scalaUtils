package it.unibo.ing.utils

import java.net.URL

/**
 * Created by tmnd on 10/10/14.
 */
object URLUtils {
  def apply(s : String) = try{
    Some(new URL(s))
  }
  catch{
    case e : Throwable => None
  }

  def removePort(u : URL) : URL = {
    val p = u.getPort
    if (p == -1){
      u
    }
    else{
      URLUtils(u.toString.split(":"+p).mkString("")).getOrElse(u)
    }
  }
}
