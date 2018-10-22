package io.baltoro.example;

import io.baltoro.client.Baltoro;
import io.baltoro.client.Env;


public class App 
{
	
	
	
    public static void main( String[] args )
    {
    	
    	Baltoro.init("blt-example", Env.PRD);

    	Baltoro.register("api", "io.baltoro.example.api");
    	
    	Baltoro.register("", "io.baltoro.example.html");
    	

    	
    	Baltoro.start();
    	
    	
    	/* paste the link in a browser 
    	
    	http://blt-example.baltoro.io
    	
    	*/
    }
}
