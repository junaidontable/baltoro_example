package io.baltoro.example;

import io.baltoro.features.Store;
import io.baltoro.obj.Base;

public class Book extends Base
{

	private @Store int price;

	public int getPrice()
	{
		return price;
	}

	public void setPrice(int price)
	{
		this.price = price;
	}
	
	
	
}
