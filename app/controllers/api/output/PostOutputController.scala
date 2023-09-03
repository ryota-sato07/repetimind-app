package controllers.api.output

import javax.inject._
import play.api.mvc._
import play.api.libs.json._
import models.data.output.{ Output, repository }
import models.api.output.JsonPostOutput
import scala.concurrent.{ ExecutionContext, Future }

/**
 * POST Output
 */
class PostOutputController @Inject()(
  cc:               ControllerComponents,
  outputRepository: repository.OutputRepository
)(implicit ec: ExecutionContext) extends AbstractController(cc) {

  /**
   * POSTリクエスト処理の実行
   */
  def add = Action.async(parse.json) { request =>
    request.body.validate[JsonPostOutput].map { output =>
      outputRepository.add(output.create).map { id =>
        Ok(Json.obj("id" -> id.toString))
      }
    }.recoverTotal { e =>
      Future.successful(BadRequest(Json.obj("error" -> JsError.toJson(e))))
    }
  }
}
