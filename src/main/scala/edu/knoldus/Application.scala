package edu.knoldus

import java.io.{File, PrintWriter}

import org.apache.log4j.Logger
import org.json4s.DefaultFormats
import org.json4s.jackson.Serialization.write

import scala.io.Source

object Application extends App {

  val log = Logger.getLogger(getClass)
  val city = "Ibrahimpur"
  val state = "Delhi"
  val address = new Address(city, state)

  val name = "Ayush"
  val age = 23
  val luckyNo = 14
  val salary = 12000
  val record = new Person(name, age, luckyNo, salary, address)

  implicit val formats = DefaultFormats
  val jsonString = write(record)

  val printWriter = new PrintWriter(new File("records.txt"))
  printWriter.write(jsonString.toString)
  printWriter.close()

  val filename = "records.txt"
  for (line <- Source.fromFile(filename).getLines) {
    log.info(s"$line \n")
  }

}
