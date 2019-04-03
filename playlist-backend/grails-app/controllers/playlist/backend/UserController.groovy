package playlist.backend

import grails.converters.JSON

import grails.plugin.springsecurity.annotation.Secured

class UserController {
    UserService userService;

    def index() { }

    @Secured('ROLE_ADMIN')
    def list(){
        def users = User.getAll()
        render users as JSON
//        withFormat{
//            json {
//                render users as JSON
//            }
//        }
    }

    @Secured('IS_AUTHENTICATED_ANONYMOUSLY')
    def login(){
        def req = request.JSON
        def res = userService.login(req)
        render res as JSON
    }
    @Secured('IS_AUTHENTICATED_ANONYMOUSLY')
    def save(){
        def req = request.JSON
        def res = userService.add(req)
        render res as JSON
    }
}
