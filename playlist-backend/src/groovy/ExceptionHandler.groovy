package playlist.backend

import org.springframework.http.HttpStatus

trait CustomExceptionHandler {
    def handleException(Exception e){
        def res = [:]
        res.error = e.message
        res.status = HttpStatus.BAD_REQUEST
        return res
    }
}
