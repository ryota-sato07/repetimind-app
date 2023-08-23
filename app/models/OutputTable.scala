package models.tables

import slick.jdbc.JdbcProfile
import models.Output

/**
 * テーブル定義: アウトプット情報
 */
class OutputTable(val profile: JdbcProfile) {
  import profile.api._

  class InternalOutputTable(tag: Tag) extends Table[Output](tag, "output") {
    def id      = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def title   = column[String]("title")
    def content = column[String]("content")

    def * = (
      id, title, content
    ) .<> (
      (Output.apply _).tupled,
      (Output.unapply _)
    )
  }

  val query = TableQuery[InternalOutputTable]
}
