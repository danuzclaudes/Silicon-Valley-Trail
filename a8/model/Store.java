package a8.model;

import a8.supplies.Supplies;

public interface Store {
	double getPrice(String item_name) throws ItemNotForSaleException;
	String[] getItemNames();
	Supplies getItem(String supply_name, int count) throws ItemNotForSaleException;
}