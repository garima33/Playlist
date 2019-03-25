package playlist.backend

import grails.converters.JSON

class UserController {
    UserService userService;

    def index() { }

    def list(){
        def users = User.getAll()
        render users as JSON
    }

    def login(){
        def req = request.JSON
        def res = userService.login(req)
        render res as JSON
    }

    def save(){
        def req = request.JSON
        def res = userService.add(req)
        render res as JSON
    }
}
