package playlist.backend

class Playlist {
    String name
    String description
    Date created_date
    Date updated_date
    static belongsTo = [user: User]
    static hasMany = [song: Song]
    static constraints = {
        name blank: false, nullable: false, unique: ['user']
        description blank: false, nullable: false

    }
}
