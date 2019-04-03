package playlist.backend

class Song {
    String name
    String album_name
    String singer
    String composer
    Date dateCreated
    Date lastUpdated
    static belongsTo = Playlist
    static hasMany = [playlists: Playlist]

    static constraints = {
        name unique: ['album_name'], nullable: false, blank: false
        singer nullable: false, blank: false
        composer nullable: false, blank: false
        album_name nullable: false, blank: false
    }
}
