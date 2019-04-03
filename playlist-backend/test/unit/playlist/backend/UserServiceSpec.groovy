package playlist.backend

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(UserService)
class UserServiceSpec extends Specification {

    def setup() {

    }

    def cleanup() {
    }

    void "test login"() {
        when:
        def userInstances = [
                new User(username: 'garima', password: 'garima'),
                new User(username: 'garima1', password: 'garima1'),
                new User(username: 'garima2', password: 'garima2'),
                new User(username: 'garima3', password: 'garima3')
        ]
        mockDomain(User, userInstances)
        def userService = new UserService()
        def res = userService.login([username: 'garima', password: 'garima'])
        log.info('res', res)
        then:
         User.list().size== 4
    }
}
