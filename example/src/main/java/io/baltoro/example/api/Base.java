package io.baltoro.example.api;

import io.baltoro.features.CTX;
import io.baltoro.features.NoAuth;
import io.baltoro.features.Path;
import io.baltoro.to.RequestContext;
import io.baltoro.to.ResponseContext;


@Path("/api")
public class Base
{

	@Path("/helloworld")
	@NoAuth
    public String helloworld(@CTX RequestContext req, @CTX ResponseContext res)
    {
    	return "hello World "+System.currentTimeMillis();
    }
	
	
}
