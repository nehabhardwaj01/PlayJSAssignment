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
//    Ok(views.html.index("Welcome to our Website")(request))
    Ok(views.html.welcome())
  }

  /**
    * This action is used to handle Ajax request
    *
    * @return
    */
  def ajaxCall = Action { implicit request =>
    Ok(views.html.signIn())
  }

  def signIn = Action { implicit request =>
    Ok(views.html.signIn())
  }

  def signUp = Action { implicit request =>
    Ok(views.html.signUp())
  }

}