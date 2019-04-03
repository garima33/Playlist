package playlist.backend

class Playlist {
    String name
    String description
    Date dateCreated
    Date lastUpdated
    static hasMany = [songs: Song]
    static belongsTo = [user: User]
    static constraints = {
        name blank: false, nullable: false, unique: ['user']
        description blank: false, nullable: false

    }
}
