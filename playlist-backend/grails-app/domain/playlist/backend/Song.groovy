package playlist.backend

class Song {
    String name
    String album_name
    String singer
    String composer
    Date created_date
    Date updated_date

    static belongsTo = [playlist: Playlist]

    static constraints = {
        name unique: ['playlist'], nullable: false, blank: false
        singer nullable: false, blank: false
        composer nullable: false, blank: false
        album_name nullable: false, blank: false
    }
}
