package models

case class Name(firstName: String,lastName: String)

case class SignUpData( name : Name,
                       gender : String,
                       username: String,
                       password: String,
                       rePassword : String,
                       hobbies : String
//                       isAdmin : Boolean = false,
//                       isEnabled : Boolean = true
                     )