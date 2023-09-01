package models.data.output.tables

import java.time.LocalDateTime
import slick.jdbc.JdbcProfile

import models.data.output.Output
import models.data.user.User

/**
 * テーブル定義: アウトプット情報
 */
class OutputTable(val profile: JdbcProfile) {
  import profile.api._

  class InternalOutputTable(tag: Tag) extends Table[Output](tag, "output") {
    def id        = column[Option[Output.ID]] ("id", O.PrimaryKey, O.AutoInc)
    def userId    = column[User.ID]           ("user_id")
    def title     = column[String]            ("title")
    def content   = column[String]            ("content")
    def isRemind  = column[Boolean]           ("is_remind")
    def createdAt = column[LocalDateTime]     ("created_at")
    def updatedAt = column[LocalDateTime]     ("updated_at")

    def * = (
      id, userId, title, content, isRemind, createdAt, updatedAt
    ) .<> (
      (Output.apply _).tupled,
      (Output.unapply _)
    )
  }

  val query = TableQuery[InternalOutputTable]
}
