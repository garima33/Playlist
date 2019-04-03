package playlist.backend

import grails.transaction.Transactional

@Transactional
class SongService {

    def save(req) {
        def songExists = checkForExistingRecords(req)
        def result = [:]
        if(songExists){
            result.text = "Song with this name already exists"

        }
        else{
            def newSong = new Song(name: req.name, album_name: req.album_name, singer: req.singer,composer: req.composer)
            newSong.save()
            result.text = "Song added successfully"

        }
        return result
    }

    def update(id, req){
        def song = Song.findById(id)
        def result = [:]
        if(!song){
            result.text = "Song  doesn't exists"
        }
        else{
            song.album_name = req.album_name
            song.name = req.name
            song.singer = req.singer
            song.composer = req.composer
            result.data = song.save(flush: true)
            result.msg = "Song updated successfully"
        }
        return result
    }

    def delete(id){
        def song = Song.findById(id)
        song.playlists.each {
            it.removeFromSongs(song)
        }
        def result = [:]
        if(!song){
            result.text =" Song doesn't exists"
        }else{
            result.body = song.delete(flush: true)
            result.text = "Song deleted successfully"
        }
        return result
    }

    def checkForExistingRecords(req){
        def song = Song.findByNameAndAlbum_name(req.name, req.album_name)
        return song
    }
}

