package controllers

import com.google.inject.Inject
import models.SignUpData
import models.Name

import play.api.mvc.Controller

import services.{AppCacheProvider, MD5}

/**
  * Created by neha on 11/3/17.
  */
class SignIncontroller @Inject()(cache:AppCacheProvider) extends Controller {


}
