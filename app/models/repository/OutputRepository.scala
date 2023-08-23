package models.repository

import javax.inject.Inject
import models.{ Output, tables }
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
  def create(title: String, content: String): Future[Output] = {
    db.run(
      query
        .returning(query.map(_.id))
        .into((output, id) => output.copy(id = id))
        += Output(0, title, content)
    )
  }

  /**
   * アウトプット情報の一覧取得
   */
  def list(): Future[Seq[Output]] = {
    db.run(query.result)
  }
}
