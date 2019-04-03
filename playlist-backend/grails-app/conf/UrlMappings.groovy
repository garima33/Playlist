
class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        group "/playlist",{
            "/save"(controller: "Playlist", action: "save")
            "/list"(controller: "Playlist", action: "list")
            "/addSong"(controller: "Playlist", action: "addSongToPlaylist")
            "/getSongs"(controller: "Playlist",action: "getSongsForPlaylist")
        }

        group "/user",{
            "/signup"(controller: "User", action: "save")

            "/allUsers"(controller: "User", action: "list")
        }


        group "/song",{
            "/save"(controller: "Song", action: "save")
            "/list"(controller: "Song", action: "list")
            "/update"(controller: "Song", action: "update")
            "/delete"(controller: "Song", action: "delete")
        }
        "/login"(controller: "User", action: "login")

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
