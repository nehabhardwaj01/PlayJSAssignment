package controllers

import play.api.mvc._
import play.api.routing.JavaScriptReverseRouter


class JavascriptRoute extends Controller {

  /* Application related JavascriptReverse Routes will go here */
  //val appRoutes: List[JavascriptReverseRoute] = List(index, ajaxCall)

  //val javascriptRouters = appRoutes

  /**
    * This is use to generate JavascriptReverseRoute for all provided actions
    *
    * @return
    */
  def javascriptRoutes = Action { implicit request =>
    Ok(
      JavaScriptReverseRouter("jsRoutes")(
        routes.javascript.CountController.count,
        routes.javascript.Application.index,
        routes.javascript.Application.signUp,
        routes.javascript.Application.signIn
      )
    ).as("text/javascript")
  }
}