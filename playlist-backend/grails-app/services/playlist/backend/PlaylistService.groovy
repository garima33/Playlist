package playlist.backend

import grails.transaction.Transactional

@Transactional
class PlaylistService {

    def save(req) {
        def user = User.findById(req.user)
        def playlistexists = Playlist.findByNameAndUser(req.name, user)
        def result = [:]
        if(playlistexists){
            result.text = "Playlist with this name already exists"

        }
        else{
            def playlist = new Playlist(name: req.name, description: req.description, user: req.user, created_date: new Date(), updated_date: new Date())
            playlist.save()
            result.text = "Playlist added successfully"

        }
        return result

    }

}
