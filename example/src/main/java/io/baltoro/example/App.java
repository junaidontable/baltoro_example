package io.baltoro.example;

import io.baltoro.client.Baltoro;
import io.baltoro.client.Env;


public class App 
{
	
	
	
    public static void main( String[] args )
    {
    	
    	Baltoro.init("blt-example", Env.PRD);
    	
    	//
    	Baltoro.register("app", "io.baltoro.example");
    	
    	
    	/*
    	 * register a new micro service here
    	 */
    	//Baltoro.register("auth", "com.flocap.api.auth");
    	
    	Baltoro.start();
    	
    	
    	/* paste the link in a browser 
    	
    	http://blt-example.baltoro.io/app/api/helloworld
    	
    	*/
    }
}
