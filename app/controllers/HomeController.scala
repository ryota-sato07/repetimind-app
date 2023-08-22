package controllers

import javax.inject._

import play.api.libs.json.Json
import play.api.mvc._

@Singleton
class TestController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def title = Action {
    Ok(Json.obj("content" -> "World"))
  }

  def postTest = Action {
    Ok(Json.obj("content" -> "Post Request Test => Data Sending Success"))
  }
}
