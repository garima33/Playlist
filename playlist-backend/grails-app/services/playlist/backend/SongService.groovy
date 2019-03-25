package playlist.backend

import grails.transaction.Transactional

@Transactional
class SongService {

    def save(req) {
        def playlist = Playlist.findById(req.playlist)
        def songExists = Song.findByNameAndPlaylist(req.name, playlist)
        def result = [:]
        if(songExists){
            result.text = "Song with this name already exists"

        }
        else{
            def newSong = new Song(name: req.name, album_name: req.album_name, singer: req.singer,composer: req.composer,playlist: req.playlist, created_date: new Date(), updated_date: new Date())
            newSong.save()
            result.text = "Song added successfully"

        }
        return result
    }
}

