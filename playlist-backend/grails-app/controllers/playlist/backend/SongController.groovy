package playlist.backend

import grails.converters.JSON

class SongController implements CustomExceptionHandler{
    SongService songService
    static allowedMethods = [list: 'GET', save: "POST", update: "PUT", delete: "DELETE"]
    def index() { }

    def list(){
        try{
            def songs = Song.list()
            withFormat{
                json {
                    render songs as JSON
                }
            }
        }
        catch(Exception e){
            response.status = 500
            def res = handleException(e)
            render res as JSON
        }
    }

    def update(){
        try{
            def id = params.id
            def req = request.JSON
            def res = songService.update(id, req)
            withFormat{
                json {
                    render res as JSON
                }
            }
        }catch(Exception e){
            response.status = 500
            def res = handleException(e)
            render res as JSON
        }
    }

    def save(){
        try{
            def req = request.JSON
            def res = songService.save(req)
            withFormat{
                json {
                    render res as JSON
                }
            }
        }catch(Exception e){
            response.status = 500
            def res = handleException(e)
            render res as JSON
        }

    }

    def delete(){
        try{
            def id = params.id
            def res = songService.delete(id)
            withFormat{
                json {
                    render res as JSON
                }
            }
        }catch(Exception e){
            response.status = 500
            def res = handleException(e)
            render res as JSON
        }
    }
}