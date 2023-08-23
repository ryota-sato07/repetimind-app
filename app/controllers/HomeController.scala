package controllers

import javax.inject._
import scala.concurrent.ExecutionContext
import slick.jdbc.JdbcProfile

import play.api.libs.json.Json
import play.api.mvc._
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}

import models.repository.OutputRepository

@Singleton
class TestController @Inject()(
  cc: ControllerComponents,
  outputRepository: OutputRepository,
  protected val dbConfigProvider: DatabaseConfigProvider
)(implicit ec: ExecutionContext) extends AbstractController(cc) {

  /**
   * GET Request test
   */
  def title = Action async { implicit request =>
    for {
      outputs     <- outputRepository.list()
      Some(output) = outputs.headOption
    } yield {
      Ok(Json.obj("content" -> output.content))
    }
  }

  /**
   * POST Request test
   */
  def postTest = Action {
    Ok(Json.obj("content" -> "Post Request Test => Data Sending Success"))
  }
}
