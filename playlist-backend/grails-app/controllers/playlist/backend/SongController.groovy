package playlist.backend

import grails.converters.JSON

class SongController {
    SongService songService
    def index() { }

    def list(){
        def req = request.JSON
        def songs = Song.all.findAll{
            it.playlist.id == req.playlist
        }
        render songs as JSON
    }

    def save(){
        def req = request.JSON
        def res = songService.save(req)
        render res as JSON
    }
}