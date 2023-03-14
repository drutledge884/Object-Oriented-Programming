package posPD;

import posPD.*;
import posPD.Item;

/**
 * the UPC for an item
 */
public class UPC 
{

	/**
	 * the item a UPC is associated with
	 */
	private Item item;
	/**
	 * the UPC
	 */
	private String uPC;

	public Item getItem() 
	{
		return this.item;
	}

	public void setItem(Item item) 
	{
		this.item = item;
	}

	public String getUPC() 
	{
		return this.uPC;
	}

	public void setUPC(String uPC) 
	{
		this.uPC = uPC;
	}

	public UPC() 
	{
		this.uPC = new String("");
	}

	/**
	 * Instantiates a UPC with its code
	 * 
	 * @param upc
	 */
	public UPC(String upc) 
	{
		this.uPC = upc;
	}

	public String toString() 
	{
		String upcInfo = new String(uPC);
		return upcInfo;
	}

}