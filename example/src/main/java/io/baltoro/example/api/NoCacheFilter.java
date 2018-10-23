package io.baltoro.example.api;
import io.baltoro.client.UserSession;
import io.baltoro.features.AbstractFilter;
import io.baltoro.features.Filter;
import io.baltoro.to.WSTO;

@Filter
public class NoCacheFilter extends AbstractFilter
{
	
	
	@Override
	public void before(WSTO to, UserSession userSession)
	{
	
	
		
	
		
	}
	
	
	@Override
	public void after(Object returnObj, WSTO to, UserSession userSession)
	{
		String path = to.requestContext.getApiPath();
		if(path.endsWith(".html") || path.endsWith(".ttf") || path.endsWith(".js") || path.endsWith(".woff") || path.endsWith(".woff2"))
		{
			return;
		}
		
		to.responseContext.getHeaders().put("Pragma", "no-cache");
		to.responseContext.getHeaders().put("Cache-Control", "no-cache, no-store, must-revalidate");
	}

}