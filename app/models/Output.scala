package models

import java.time.LocalDateTime

/**
 * アウトプット情報
 */
case class Output(
  id:        Option[Long],     // 管理ID
  userId:    Long,             // ユーザーID
  title:     String,           // タイトル
  content:   String,           // 本文
  isRemind:  Boolean,          // リマインドのアクティブフラグ
  createdAt: LocalDateTime,    // 作成日時
  updatedAt: LocalDateTime     // 更新日時
)

object Output {}
