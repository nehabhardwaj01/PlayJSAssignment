package controllers

import com.google.inject.{Singleton, Inject}
import models.SignUpData
import play.api._
import play.api.mvc._

@Singleton
class Application @Inject()(cache: services.AppCacheProvider) extends Controller {

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
    Ok(views.html.signUp(cache.getDefaultData)(""))
  }

  def profilePage = Action{ implicit request =>
    Ok(views.html.profile(cache.getDefaultData))
  }

}