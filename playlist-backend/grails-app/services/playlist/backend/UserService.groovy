package playlist.backend

import grails.transaction.Transactional

@Transactional
class UserService {

    def login(req){
        def user = this.findUser(req.name)
        def result = [:]
        if(user){
            if(user.password == req.password){
                result.msg = "User logged in successfully"
            }else{
                result.msg = "Password is incorrect"
            }
        }else{
            result.msg = "User doesn't exists"
        }
        return result
    }

    def add(req) {
        def user = this.findUser(req.name)
        def result = [:]
        if(user){
            result.msg = "User already exists"
        }else{
            def newUser = new User(username: req.name, password: req.password)
            newUser.save()
            def userRole = Role.findByAuthority('ROLE_USER')
            UserRole.create(newUser,userRole, true)
            result.msg = "User Successfully added"
        }
       return result
    }

    def findUser(name){
        def user = User.findByUsername(name)
        return user
    }

}
