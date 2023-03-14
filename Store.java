package posPD;

import posPD.*;
import java.util.*;
import posPD.Cashier;
import posPD.Session;
import posPD.Register;
import posPD.UPC;
import posPD.Item;

/**
 * a place to store and sell goods. It has items, employees, sessions, UPC's,
 * registers, and tax categories.
 */
public class Store 
{
//implements Comparable<Price>
	/**
	 * A tax Category that is used to set the tax rate for a collection of items
	 */
	private TreeMap<String, TaxCategory> taxCategories;
	/**
	 * A worker in the Store
	 */
	private TreeMap<String, Cashier> cashiers;
	/**
	 * A session that a Cashier and register are working within
	 */
	private ArrayList<Session> sessions;
	/**
	 * A working register in the store
	 */
	private TreeMap<String, Register> registers;
	/**
	 * UPC's for different Items
	 */
	private TreeMap<String, UPC> upcs;
	/**
	 * A product the store sells
	 */
	private TreeMap<String, Item> items;
	/**
	 * The store number
	 */
	private String number;
	/**
	 * The name of the store
	 */
	private String name;

	public TreeMap<String, Cashier> getCashiers() 
	{
		return this.cashiers;
	}

	public ArrayList<Session> getSessions() 
	{
		return this.sessions;
	}

	public TreeMap<String, Register> getRegisters() 
	{
		return this.registers;
	}

	public TreeMap<String, UPC> getUpcs() 
	{
		return this.upcs;
	}

	public TreeMap<String, Item> getItems() 
	{
		return this.items;
	}

	public String getNumber() 
	{
		return this.number;
	}

	public void setNumber(String number) 
	{
		this.number = number;
	}

	public String getName() 
	{
		return this.name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public TreeMap<String, TaxCategory> getTaxCategory() 
	{
		return this.taxCategories;
	}

	public Store() 
	{
		this.number = new String("0");
		this.name = new String("No Name");
		taxCategories = new TreeMap<String, TaxCategory>();
		cashiers = new TreeMap<String, Cashier>();
		sessions = new ArrayList<Session>();
		registers = new TreeMap<String, Register>();
		upcs = new TreeMap<String, UPC>();
		items = new TreeMap<String, Item>();
	}

	/**
	 * Instantiates a Store with its name and number
	 * 
	 * @param number
	 * @param name
	 */
	public Store(String number, String name) 
	{
		this.number = number;
		this.name = name;
		taxCategories = new TreeMap<String, TaxCategory>();
		cashiers = new TreeMap<String, Cashier>();
		sessions = new ArrayList<Session>();
		registers = new TreeMap<String, Register>();
		upcs = new TreeMap<String, UPC>();
		items = new TreeMap<String, Item>();
	}

	/**
	 * adds an item to the store
	 * 
	 * @param item
	 */
	public void addItem(Item item) 
	{ 
		items.put(item.getNumber(), item);
	}

	/**
	 * removes an item from the store
	 * 
	 * @param item
	 */
	public void removeItem(Item item) 
	{
		items.remove(item.getNumber());
	}

	/**
	 * adds a UPC to the store
	 * 
	 * @param upc
	 */
	public void addUPC(UPC upc) 
	{
		upcs.put(upc.getUPC(), upc);
	}

	/**
	 * removes a UPC from the store
	 * 
	 * @param upc
	 */
	public void removeUPC(UPC upc) 
	{
		upcs.remove(upc.getUPC());
	}

	/**
	 * adds a register
	 * 
	 * @param register
	 */
	public void addRegister(Register register) 
	{
		registers.put(register.getNumber(), register);
	}

	/**
	 * removes a register
	 * 
	 * @param register
	 */
	public void removeRegister(Register register) 
	{
		registers.remove(register.getNumber());
	}

	/**
	 * adds a cashier
	 * 
	 * @param cashier
	 */
	public void addCashier(Cashier cashier) 
	{
		cashiers.put(cashier.getNumber(), cashier);
	}

	/**
	 * removes a cashier
	 * 
	 * @param cashier
	 */
	public void removeCashier(Cashier cashier) 
	{
		cashiers.remove(cashier.getNumber());
	}

	/**
	 * creates a session
	 * 
	 * @param session
	 */
	public void addSession(Session session) 
	{
		sessions.add(session);
	}

	/**
	 * removes or ends a session
	 * 
	 * @param session
	 */
	public void removeSession(Session session) 
	{
		sessions.remove(session);
	}

	/**
	 * finds an item based on the UPC
	 * 
	 * @param upc
	 */
	public Item findItemForUPC(String upc) 
	{
		for (Map.Entry<String, UPC> entry : upcs.entrySet()) 
		{
			System.out.println(entry.getValue().getUPC());
			if (upc.equals(entry.getValue().getUPC())) 
			{
				System.out.println("Item found");
				return entry.getValue().getItem();
			}

		}
		System.out.println("item is null");
		return null;
	}

	/**
	 * finds an item based on its number
	 * 
	 * @param number
	 */
	public Item findItemForNumber(String number) 
	{
		return items.get(number);
	}

	/**
	 * finds a cashier based on their number
	 * 
	 * @param number
	 */
	public Cashier findCashierForNumber(String number) 
	{
		return cashiers.get(number);
	}
	
	public Register findRegisterbyNumber(String number)
	{
		return registers.get(number);
	}

	public String toString() 
	{
		String storeInfo = new String("");
		storeInfo += name;
		storeInfo += " number ";
		storeInfo += number;
		return storeInfo;
		//throw new UnsupportedOperationException();
	}
 
	/**
	 * adds a TaxCategory
	 * 
	 * @param taxCategory
	 */
	public void addTaxCategory(TaxCategory taxCategory) 
	{
		taxCategories.put(taxCategory.getCategory(), taxCategory);
	}

	/**
	 * removes a TaxCategory
	 * 
	 * @param taxCategory
	 */
	public void removeTaxCategory(TaxCategory taxCategory) 
	{
		taxCategories.remove(taxCategory.getCategory());
	}

	public TaxCategory findTaxCategoryForName(String name) 
	{
		// what happens when the item is not found?
		return taxCategories.get(name);
	}
}