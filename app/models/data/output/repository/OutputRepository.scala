package models.data.output.repository

import javax.inject.Inject
import models.data.output.{ Output, tables }
import play.db.NamedDatabase
import play.api.db.slick.{ DatabaseConfigProvider, HasDatabaseConfigProvider }
import slick.jdbc.JdbcProfile

import scala.concurrent.{ ExecutionContext, Future }

/**
 * アウトプット情報
 */
class OutputRepository @Inject() (
  @NamedDatabase("test") protected val dbConfigProvider: DatabaseConfigProvider
)(implicit ec: ExecutionContext) extends HasDatabaseConfigProvider[JdbcProfile] {

  val outputTable = new tables.OutputTable(profile)

  import outputTable._
  import profile.api._

  // --[ Methods ]--------------------------------------------------------------
  /**
   * アウトプット情報の新規追加
   */
  def add(output: Output): Future[Output.ID] = {
    db.run(
      (query
        returning query.map(_.id)
        into ((_, idOption) =>
          idOption.getOrElse(throw new RuntimeException("Failed to get the ID"))
        )
      ) += output.copy(id = None)
    )
  }

  /**
   * アウトプット情報の一覧取得
   */
  def list(): Future[Seq[Output]] = {
    db.run(query.result)
  }
}
