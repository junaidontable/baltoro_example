package io.baltoro.example.api;

import io.baltoro.client.Baltoro;
import io.baltoro.client.LocalDB;
import io.baltoro.example.Author;
import io.baltoro.example.Book;
import io.baltoro.features.CTX;
import io.baltoro.features.NoAuth;
import io.baltoro.features.Param;
import io.baltoro.features.Path;
import io.baltoro.to.RequestContext;
import io.baltoro.to.ResponseContext;


@Path("/api")
public class Base
{

	
	LocalDB db = Baltoro.getDB();
	
	@Path("/helloworld")
	@NoAuth
    public String helloworld(@CTX RequestContext req, @CTX ResponseContext res)
    {
    	return "hello World "+System.currentTimeMillis();
    }
	
	
	@Path("/getBook")
	@NoAuth
    public Book getBook(@Param("name") String name, 
    		@CTX RequestContext req, 
    		@CTX ResponseContext res)
    {
		
		Book b = db.getByName(name, Book.class);
		return b;
    }
		
	
	@Path("/createBook")
	@NoAuth
    public Book createBook(@Param("name") String name, @Param("price") String price, @Param("authorName") String authorName, 
    		@CTX RequestContext req, 
    		@CTX ResponseContext res)
    {
		
		
		Book b = db.getByName(name, Book.class);
		if(b == null)
		{
			b = new Book();
	    	b.setName(name);
	    	b.setPrice(Integer.parseInt(price));
	    	
	    	db.save(b);
		}
		
		Author a = db.getByName(authorName, Author.class);
		if(a == null)
		{
			a = new Author();
			a.setName(authorName);
			
			db.save(a);
		}
    	
		db.link(a, b);
    	
    	return b;
    }
	
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
