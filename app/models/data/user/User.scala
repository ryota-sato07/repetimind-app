package models.data.user

import java.time.LocalDateTime
import shapeless.tag
import shapeless.tag.@@
import slick.jdbc.MySQLProfile.api._

/**
 * ユーザー情報
 */
import User._
case class User(
  id:        Option[ID],      // 管理ID
  lineId:    Option[String],  // LINE 識別ID
  name:      Option[String],  // ユーザー名
  email:     String,          // メールアドレス
  password:  Password,        // パスワード  // TODO: ハッシュ化
  createdAt: LocalDateTime,   // 作成日時
  updatedAt: LocalDateTime    // 更新日時
)

object User {

  // --[ New types ]------------------------------------------------------------
  // ID
  trait IdTag
  type ID = Long @@ IdTag
  def tagID(id: Long): ID = tag[IdTag][Long](id)

  // LINE ID
  trait LineIdTag
  type LineID = String @@ LineIdTag
  def tagLineID(lineId: String): LineID = tag[LineIdTag][String](lineId)

  // パスワード
  trait PasswordTag
  type Password = String @@ PasswordTag
  def tagPassword(pass: String): Password = tag[PasswordTag][String](pass)

  // --[ Typed Type ]-----------------------------------------------------------
  // IDの型に対して暗黙的なTypedTypeインスタンス
  implicit val userIdColumnType: BaseColumnType[User.ID] =
  MappedColumnType.base[User.ID, Long](
    taggedId => taggedId,
    longId   => shapeless.tag[User.IdTag][Long](longId)
  )
}
