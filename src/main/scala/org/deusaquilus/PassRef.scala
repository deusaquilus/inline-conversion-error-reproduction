package org.deusaquilus

import scala.quoted._

class Ref[T]
object MakeRef:
  def makeRef[T]: Ref[T] = ???

class Wrapped[W](t: W) {
  def unwrap: W = ???
}

object PassRef {
  inline def pass[T](ref: Ref[T]): Wrapped[Ref[T]] = ${ passImpl('ref) }
  def passImpl[T: Type](ref: Expr[Ref[T]])(using Quotes): Expr[Wrapped[Ref[T]]] =
    '{ Wrapped[Ref[T]]($ref) }

  inline implicit def unwrap[T](inline w: Wrapped[T]): T = ${ unwrapImpl[T]('w) }
  def unwrapImpl[T: Type](w: Expr[Wrapped[T]])(using Quotes): Expr[T] =
    '{ $w.unwrap }

  // Not possible since `w` cannot be inlined
  // inline given unwrap[T]: Conversion[Wrapped[T], T] with
  //   inline def apply(inline w: Wrapped[T]): T = ${ unwrapImpl[T]('w) }
  // def unwrapImpl[T: Type](w: Expr[Wrapped[T]])(using Quotes): Expr[T] =
  //   '{ $w.unwrap }
}
