package edu.knoldus

@SerialVersionUID(14)
class Person(val name: String, val age: Int, @transient val luckyNumber: Int, val salary: Float, val address: Address) extends Serializable

class Address(val city: String, val state: String) extends Serializable
