package playlist.backend

class User {
    String password
    String username
    String type
    Date created_date
    Date updated_date
    static hasMany = [playlists: Playlist]
    static mapping = {
        table 'users'
    }
    static constraints = {
        password blank: false, nullable: false
        username blank: false, nullable: false, unique: true
        type (inList:["user", "admin"])
    }


}
