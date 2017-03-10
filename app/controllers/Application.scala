package controllers

import play.api._
import play.api.mvc._

class Application extends Controller {

  /**
    * This action is used to serve Home page of the application
    *
    * @return
    */
  def index = Action { implicit request =>
    Ok(views.html.index("Welcome to our Website")(request))
  }

  /**
    * This action is used to handle Ajax request
    *
    * @return
    */
  def ajaxCall = Action { implicit request =>
    Ok(views.html.signIn())
  }

}