package it.unibo.ing.utils

import java.text.SimpleDateFormat
import java.util.{TimeZone, Date}

/**
 * Created by tmnd on 10/10/14.
 */
object DateUtils {
  def parseOption(stringDate : String, format : String = "yyyy-MM-dd'T'HH:mm:ss'Z'") : Option[Date] = {
    try{
      Some(parse(stringDate,format))
    }
    catch{
      case e : Throwable => None
    }
  }

  def parse(stringDate : String, format : String = "yyyy-MM-dd'T'HH:mm:ss'Z'") : Date = {
    val sdf = new SimpleDateFormat(format,java.util.Locale.ENGLISH)
    sdf.setTimeZone(TimeZone.getTimeZone("UTC"))
    sdf.parse(stringDate)
  }

  def format(date : Date, format : String = "yyyy-MM-dd'T'HH:mm:ss'Z'") : String = {
    val sdf = new SimpleDateFormat(format,java.util.Locale.ENGLISH)
    sdf.setTimeZone(TimeZone.getTimeZone("UTC"))
    sdf.format(date)
  }

  def formatOption(date : Date, format : String = "yyyy-MM-dd'T'HH:mm:ss'Z'") : Option[String] = {
    try{
      Some(this.format(date,format))
    }
    catch{
      case e : Throwable => None
    }
  }
}
