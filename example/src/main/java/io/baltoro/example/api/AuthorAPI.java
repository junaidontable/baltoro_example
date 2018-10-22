package io.baltoro.example.api;

import io.baltoro.client.Baltoro;
import io.baltoro.client.LocalDB;
import io.baltoro.example.Author;
import io.baltoro.features.CTX;
import io.baltoro.features.NoAuth;
import io.baltoro.features.Param;
import io.baltoro.features.Path;
import io.baltoro.to.RequestContext;
import io.baltoro.to.ResponseContext;


@Path("/author")
public class AuthorAPI
{

	
	LocalDB db = Baltoro.getDB();
	
	@Path("/createAuthor")
	@NoAuth
    public Author createAuthro(@Param("name") String name, @CTX RequestContext req, @CTX ResponseContext res)
    {
		Author a = db.getByName(name, Author.class);
		if(a == null)
		{
			a = new Author();
			a.setName(name);
			
			db.save(a);
		}
		
		return a;
    }
	
	
}
