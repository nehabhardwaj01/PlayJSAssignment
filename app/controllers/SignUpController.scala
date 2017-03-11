package controllers

import com.google.inject.Inject
import models.{Name, SignUpData}
import play.api.mvc.{Action, Controller}
import services.{MD5, AppCacheProvider}

/**
  * Created by neha on 11/3/17.
  */
class SignUpController @Inject()(cache:AppCacheProvider) extends Controller{

  def addUser(fname:String,lname:String,
              gender:String,username:String,
              password:String,rePassword:String,hobbies:String) = {
    Action { implicit request =>

      val userData = SignUpData(Name(fname, lname), gender, username, password, rePassword, hobbies)
      val (exist, message) = validate(userData)
      if (exist == true) {
        val newUser = updateCache(userData)
        Ok(views.html.profile(newUser))
      }
      else {
        Ok(views.html.signUp(userData)(message))
      }
    }
  }


  def validate(user : SignUpData) : (Boolean,String)={
    if(user.password.equals(user.rePassword)) {
      val userName = cache.getData(user.username)
      if(cache.getListOfKeys.contains(userName)) {
        (false, "Username already exixts !")
      }
      else{
        (true, "Sign Up successful!")
      }
    }
    else if(user.username=="" || user.hobbies==""){
      (false,"Please enter valid  Credentials !!!")
    }
    else{
      (false,"Password and Re-Password doesnt match !")
    }
  }

  def updateCache(userData : SignUpData ) : SignUpData = {
    val hashedPassword = MD5.hash(userData.password)
    val newUser = userData.copy(password = hashedPassword,rePassword = hashedPassword)
    cache.setData(userData.username,newUser)
    cache.updateListOfKeys(userData.username)
    newUser
  }
}
