package models.data.user

import java.time.LocalDateTime
import shapeless.tag
import shapeless.tag.@@

/**
 * ユーザー情報
 */
import User._
case class User(
  id:        Option[Long],    // 管理ID
  lineId:    Option[String],  // LINE 識別ID
  name:      Option[String],  // ユーザー名
  email:     String,          // メールアドレス
  password:  Password,        // パスワード  // TODO: ハッシュ化
  createdAt: LocalDateTime,   // 作成日時
  updatedAt: LocalDateTime    // 更新日時
)

object User {

  // --[ New types ]------------------------------------------------------------
  trait PasswordTag
  type Password = String @@ PasswordTag
  def tagPassword(pass: String): Password = tag[PasswordTag][String](pass)

}
