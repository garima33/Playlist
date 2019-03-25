package playlist.backend

import grails.converters.JSON

class PlaylistController {
    PlaylistService playlistService
    def index() { }

    def list(){
        def req = request.JSON
        def playlists = Playlist.all.findAll{
            it.user.id == req.user
        }
        render playlists as JSON
    }

    def save(){
        def req = request.JSON
        def res = playlistService.save(req)
        render res as JSON
    }
}
