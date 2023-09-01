package models.api.output

import java.time.LocalDateTime
import play.api.libs.json._
import play.api.libs.functional.syntax._

import models.data.output.Output

object OutputFormats {

  implicit val localDateTimeWrites: Writes[LocalDateTime] = Writes { datetime =>
    JsString(datetime.toString)
  }

  implicit val localDateTimeReads: Reads[LocalDateTime] = Reads { jsValue =>
    jsValue.validate[String].map(LocalDateTime.parse)
  }

  implicit val outputWrites: Writes[Output] = (
    (JsPath \ "id").writeNullable[Long] and
    (JsPath \ "userId").write[Long] and
    (JsPath \ "title").write[String] and
    (JsPath \ "content").write[String] and
    (JsPath \ "isRemind").write[Boolean] and
    (JsPath \ "createdAt").write[LocalDateTime] and
    (JsPath \ "updatedAt").write[LocalDateTime]
  )(unlift(Output.unapply))

  implicit val outputReads: Reads[Output] = (
    (JsPath \ "id").readNullable[Long].map(_.map(Output.tagID)) and
  (JsPath \ "userId").read[Long] and
  (JsPath \ "title").read[String] and
  (JsPath \ "content").read[String] and
  (JsPath \ "isRemind").read[Boolean] and
  (JsPath \ "createdAt").read[LocalDateTime] and
  (JsPath \ "updatedAt").read[LocalDateTime]
)(Output.apply _)
}
