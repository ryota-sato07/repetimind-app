package models.data.output

import java.time.LocalDateTime
import shapeless.tag
import shapeless.tag.@@
import slick.jdbc.MySQLProfile.api._

import models.data.user.User

/**
 * アウトプット情報
 */
import Output._
case class Output(
  id:        Option[ID],       // 管理ID
  userId:    User.ID,          // ユーザーID
  title:     String,           // タイトル
  content:   String,           // 本文
  isRemind:  Boolean,          // リマインドのアクティブフラグ
  createdAt: LocalDateTime,    // 作成日時
  updatedAt: LocalDateTime     // 更新日時
)

object Output {

  // --[ New types ]------------------------------------------------------------
  // ID
  trait IdTag
  type ID = Long @@ IdTag
  def tagID(id: Long): ID = tag[IdTag][Long](id)

  // --[ Typed Type ]-----------------------------------------------------------
  // IDの型に対して暗黙的なTypedTypeインスタンス
  implicit val outputIdColumnType: BaseColumnType[Output.ID] =
  MappedColumnType.base[Output.ID, Long](
    taggedId => taggedId,
    longId => shapeless.tag[Output.IdTag][Long](longId)
  )

}
