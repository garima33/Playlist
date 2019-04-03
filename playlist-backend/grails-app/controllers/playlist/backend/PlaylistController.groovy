package playlist.backend


import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

//@Secured(['ROLE_USER', 'ROLE_ADMIN'])
class PlaylistController implements CustomExceptionHandler {
    PlaylistService playlistService

    static allowedMethods = [list: "GET", save: "POST", addSongToPlaylist: "POST", getSongsForPlaylist: "GET", delete: "DELETE", deleteSong: "DELETE"]

    def index() { }

    def list(){
        try{
            def id= Integer.parseInt(params.id)
            def playlists = Playlist.all.findAll{
                it.user.id == id
            }
            withFormat{
                json {
                    render playlists as JSON
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
            def res = playlistService.save(req)
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

    def addSongToPlaylist(){
        try{
            def req = request.JSON
            def res = playlistService.addSong(req)
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

    def getSongsForPlaylist(){

        try{
            def songs = playlistService.getSongs(params.id)
            withFormat{
                json {
                    render songs as JSON
                }
            }
        }catch(Exception e){
            response.status = 500
            def res = handleException(e)
            render res as JSON
        }


    }

    def update(){
        try{
            def req = request.JSON
            def res = playlistService.update(req)
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
            def id= Integer.parseInt(params.id)
            def res = playlistService.delete(id)
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

    def deleteSong(){
        try{
            def req = request.JSON
            def res = playlistService.deleteSong(req)
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
