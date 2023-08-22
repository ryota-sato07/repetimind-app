package models

import play.api.libs.json._

case class Output(
  id:      Long,
  title:   String,
  content: String
)

object Output {
  implicit val personFormat = Json.format[Output]
}
