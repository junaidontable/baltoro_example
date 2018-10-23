package io.baltoro.example.api;

import java.util.List;

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


@Path("/book")
public class BookAPI
{

	
	LocalDB db = Baltoro.getDB();
	
	@Path("/helloworld")
	@NoAuth
    public String helloworld(@CTX RequestContext req, @CTX ResponseContext res)
    {
    	return "hello World "+System.currentTimeMillis();
    }
	
	
	@Path("/all")
	@NoAuth
    public List<Book> getBook(@CTX ResponseContext res)
    {
		
		List<Book> l = db.find(Book.class);
		
		return l;
    }
		
	
	@Path("/create")
	@NoAuth
    public Book createBook(@Param("bookName") String bookName,
				    		@Param("authorName") String authorName, 
				    		@CTX RequestContext req, 
				    		@CTX ResponseContext res)
    {
		
		
		Book b = db.getByName(bookName, Book.class);
		if(b == null)
		{
			b = new Book();
	    	b.setName(bookName);
	    	
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
    	
		res.sendRedirect("/");
		
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
