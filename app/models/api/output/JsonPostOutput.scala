package models.api.output

import java.time.LocalDateTime
import play.api.libs.json._
import play.api.libs.functional.syntax._

import models.data.output.Output
import models.data.user.User

/**
 * アウトプット登録情報
 */
case class JsonPostOutput(
  uid:     User.ID, // ユーザーID
  title:   String,  // タイトル
  content: String,  // 本文
) {

  // --[ Methods ]--------------------------------------------------------------
  /**
   * JSONから新規作成
   */
  def create: Output = {
    Output(
      id       = None,
      userId   = uid,
      title    = title,
      content  = content,
      isRemind = true
    )
  }
}

/**
 * コンパニオンオブジェクト
 */
object JsonPostOutput {

  // --[ JSON : Combinator ]----------------------------------------------------
  implicit val jsonPostOutputReads: Reads[JsonPostOutput] = (
    (JsPath \ "uid").read[User.ID] and
    (JsPath \ "title").read[String] and
    (JsPath \ "content").read[String]
  )(JsonPostOutput.apply _)
}
