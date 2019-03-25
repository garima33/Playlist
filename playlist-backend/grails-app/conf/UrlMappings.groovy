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
        }

        group "/user",{
            "/signup"(controller: "User", action: "save")
            "/login"(controller: "User", action: "login")
            "/allUsers"(controller: "User", action: "list")
        }


        group "/song",{
            "/save"(controller: "Song", action: "save")
            "/list"(controller: "Song", action: "list")
        }

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
