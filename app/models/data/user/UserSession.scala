package models.data.user

import java.util.UUID
import java.time.LocalDateTime
import shapeless.tag
import shapeless.tag.@@

/**
 * セッション情報
 */
case class UserSession(
  id:        Option[Long],   // 管理ID
  userId:    Long,           // ユーザーID
  uuid:      UUID,           // ランダムトークン
  expiresAt: LocalDateTime,  // 有効期限
  createdAt: LocalDateTime,  // 作成日時
  updatedAt: LocalDateTime   // 更新日時
)

object UserSession {}
