package com.naga.shopping.catalogue;

import java.math.BigDecimal;

/**
 * ShoppingItem contains items and their Price.
 */
public interface ShoppingItem {

	/**
	 * Name of the Fruit
	 * 
	 * @return the name of the item.
	 */
	String getName();

	/**
	 * Item Price.
	 * 
	 * @return the selling price of the item
	 */
	BigDecimal getPrice();

}
