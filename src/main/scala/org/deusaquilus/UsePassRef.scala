package org.deusaquilus

class MultiLevelServiceSpec {
  import PassRef._
  import MakeRef._

  case class Person(name: String)
  class Reproduce {
    inline def a = pass(makeRef[Person])
    def b = pass(a)
  }
}
