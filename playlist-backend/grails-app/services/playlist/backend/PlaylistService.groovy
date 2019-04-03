package playlist.backend

import grails.converters.JSON
import grails.transaction.Transactional
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
@Transactional
class PlaylistService {

    def save(req) {
        def user = User.findById(req.user)
        def playlistexists = Playlist.findByNameAndUser(req.name, user)
        def result = [:]
        if(playlistexists){
            result.msg = "Playlist with this name already exists"
            result.status = HttpStatus.METHOD_NOT_ALLOWED

        }
        else{
            def playlist = new Playlist(name: req.name, description: req.description, user: req.user)
            result.body = playlist.save()
            result.msg = "Playlist added successfully"
            result.status = HttpStatus.CREATED

        }
        return result
    }

    def addSong(req){
        def playlist = Playlist.findById(req.playlistId)
        def song = Song.findById(req.songId)
        playlist.addToSongs(song).save()
        def result = [:]
        result.body = "Song added to playlist successfully"
        result.status = HttpStatus.CREATED
        return result
    }

    def getSongs(def id){
         def songs = Playlist.findById(id).songs
         return songs
    }

    def update(req){
        def user = User.findById(req.userId)
        def playlist = Playlist.findByIdAndUser(req.playlistId, user)
        def result = [:]
        if(!playlist){
            result.msg = "Playlist doesn't exists"
            result.status = HttpStatus.METHOD_NOT_ALLOWED

        }
        else{
            playlist.name = req.name
            playlist.description = req.description
            result.body = playlist.save(flush: true)
            result.msg = "Playlist added successfully"
            result.status = HttpStatus.OK

        }
        return result
    }

    def delete(id){
        def playlist = Playlist.findById(id)
        def result = [:]
        if(!playlist){
            result.msg = "Playlist doesn't exists"
            result.status = HttpStatus.METHOD_NOT_ALLOWED

        }
        else{
            playlist.delete(flush: true)
            result.msg = "Playlist deleted successfully"
            result.status = HttpStatus.CREATED

        }
        return result
    }

    def deleteSong(req){
        def playlist = Playlist.findById(req.playlist)
        def result = [:]
        if(!playlist){
            result.msg = "Playlist doesn't exists"
            result.status = HttpStatus.METHOD_NOT_ALLOWED

        }
        else{
            def song = Song.findById(req.song)
            playlist.removeFromSongs(song)
            result.msg = "Song deleted from Playlist successfully"
            result.status = HttpStatus.CREATED

        }
        return result
    }

}
