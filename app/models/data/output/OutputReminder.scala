package models.data.output

import java.time.LocalDateTime
import enumeratum.values.{ IntEnum, IntEnumEntry }

/**
 * リマインダー情報
 */
import OutputReminder._
case class OutputReminder(
  id:        Option[Long],     // 管理ID
  outputId:  Long,             // アウトプットID
  status:    Status,           // 通知フラグ
  noticeAt:  LocalDateTime,    // 通知日時
  createdAt: LocalDateTime,    // 作成日時
  updatedAt: LocalDateTime     // 更新日時
)

object OutputReminder {

  // --[ IntEnum: Status ]------------------------------------------------------
  sealed abstract class Status(val value: Int) extends IntEnumEntry
  object Status extends IntEnum[Status] {
    case object IS_UNNOTICED extends Status(value = 0) // 未通知
    case object IS_NOTIFIED  extends Status(value = 1) // 通知済み

    lazy val values: IndexedSeq[Status] = findValues
  }
}
