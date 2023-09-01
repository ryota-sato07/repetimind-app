package controllers.api.output

import javax.inject._
import play.api.mvc._
import play.api.libs.json._
import models.data.output.{ Output, repository }
import models.api.output.OutputFormats
import scala.concurrent.{ ExecutionContext, Future }

class OutputAddController @Inject()(
    cc: ControllerComponents,
    outputRepository: repository.OutputRepository
)(implicit ec: ExecutionContext) extends AbstractController(cc) {

  import OutputFormats._ // JSON Reads/Writesのインポート

  def createOutput() = Action.async(parse.json) { request =>
    request.body.validate[Output].fold(
      errors => {
        Future.successful(BadRequest(Json.obj("status" -> "KO", "message" -> JsError.toJson(errors))))
      },
      output => {
        outputRepository.create(output).map { id =>
          Ok(Json.obj("status" -> "OK", "message" -> ("Output created with id: " + id)))
        }
      }
    )
  }

  def getOutputs() = Action.async {
    outputRepository.list().map { outputs =>
      Ok(Json.toJson(outputs))
    }
  }
}
