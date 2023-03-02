package sbt.megallink
package script.modules.files.implementations.models

case class Hero(
                 age: Int,
                 alias: Option[String],
                 name:String
               )



case class Person(
  nameValue :String,
  detailValue:HeroDetail
                 )
case class HeroDetail(
                      age: Int,
                      alias: Option[String],
                    )