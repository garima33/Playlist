import playlist.backend.*
class BootStrap {

    def init = { servletContext ->
        def adminRole = new Role('ROLE_ADMIN').save()
        def userRole = new Role('ROLE_USER').save()

        def testUser = new User('me', 'password').save()
        def testUser1 = new User('garima', 'password').save()
        UserRole.create testUser, adminRole, true
        UserRole.create testUser1, userRole, true
        assert User.count() == 2
        assert Role.count() == 2
        assert UserRole.count() == 2
    }
    def destroy = {
    }
}
