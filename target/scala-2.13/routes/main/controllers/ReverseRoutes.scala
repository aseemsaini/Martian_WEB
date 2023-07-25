// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:22
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def versioned(file:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
  }

  // @LINE:13
  class Reverseauthentication(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def createUser: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "create")
    }
  
    // @LINE:18
    def createUserForm: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "createUserForm2")
    }
  
    // @LINE:19
    def logout: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "logout")
    }
  
    // @LINE:17
    def socket: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "socket")
    }
  
    // @LINE:16
    def test: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "test")
    }
  
    // @LINE:15
    def loginValidate: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "validate")
    }
  
    // @LINE:13
    def login: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "login")
    }
  
  }

  // @LINE:25
  class Reversefinance(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:25
    def home: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "home")
    }
  
    // @LINE:26
    def searchTicker: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "search")
    }
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index: Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:10
  class ReverseAsyncController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def message: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "message")
    }
  
  }


}
