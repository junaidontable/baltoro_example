package io.baltoro.example.html;


import java.util.logging.Logger;

import io.baltoro.client.FileServer;
import io.baltoro.client.WebFile;
import io.baltoro.features.CTX;
import io.baltoro.features.NoAuth;
import io.baltoro.features.Path;
import io.baltoro.to.RequestContext;
import io.baltoro.to.ResponseContext;

@Path("/")
public class Index 
{

	static Logger log = Logger.getLogger(Index.class.getName());
	static String filePath = "src/main/html";



	@Path("/")
	@NoAuth
	public byte[] getIndex(@CTX RequestContext req, @CTX ResponseContext res) 
	{
		WebFile webFile = FileServer.getFile(filePath+"/index.html", req, res);
		return webFile.data;
	}

	
}
