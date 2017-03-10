package controllers

import play.api.mvc.Action
import play.api.mvc.Controller
import play.api.mvc.EssentialAction
import play.core.Router.JavascriptReverseRoute
import play.core.Router._
import routes.javascript.Application.index
import routes.javascript.Application.ajaxCall
import views.html.index
import play.api.mvc._
import play.api.routing._
import _root_.play.sbt.PlayImport._



class JavascriptRoute extends Controller {

  /* Application related JavascriptReverse Routes will go here */
  val appRoutes: List[JavascriptReverseRoute] = List(index, ajaxCall)

  val javascriptRouters = appRoutes

  /**
    * This is use to generate JavascriptReverseRoute for all provided actions
    *
    * @return
    */
  def javascriptRoutes = Action { implicit request =>
    Ok(
      JavaScriptReverseRouter("jsRoutes")(
        routes.javascript.Users.list,
        routes.javascript.Users.get
      )
    ).as("text/javascript")
  }
}