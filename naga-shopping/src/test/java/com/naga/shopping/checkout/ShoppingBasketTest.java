package com.naga.shopping.checkout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.naga.shopping.catalogue.ShoppingItem;
import com.naga.shopping.catalogue.ShoppingItemImpl;
import com.naga.shopping.util.IllegialShoppingException;

/**
 * Created by Naga.
 */
public class ShoppingBasketTest {

	private ShoppingBasket basket;

	@Before
	public void setUp() throws Exception {
		basket = new ShoppingBasket();
	}

	@Test(expected = IllegialShoppingException.class)
	public void addNullItem() {
		basket.addItem(null);
	}

	@Test(expected = IllegialShoppingException.class)
	public void addItemWithEmptyName() {
		ShoppingItem item = new ShoppingItemImpl("", 0.60);
		basket.addItem(item);

	}

	@Test
	public void clearsAllItemsFromTheBasket() {
		ShoppingItem item = new ShoppingItemImpl("Apple", 0.60);
		basket.addItem(item);
		assertTrue(basket.getItems().size() > 0);
		basket.clear();
		assertEquals("Basket must be empty", 0, basket.getItems().size());
	}

	@Test(expected = IllegialShoppingException.class)
	public void addItemWithNameAsBlankSpace() {
		ShoppingItem item = new ShoppingItemImpl(" ", 0.60);
		basket.addItem(item);
	}

	@Test
	public void addOneItem() {
		ShoppingItem item = new ShoppingItemImpl("Apple", 0.60);
		basket.addItem(item);

		assertEquals("Should have 1 item", 1, basket.getItems().size());
	}

	@Test
	public void add2DifferentItems() {
		ShoppingItem item1 = new ShoppingItemImpl("Apple", 0.60);
		ShoppingItem item2 = new ShoppingItemImpl("banana", 0.40);
		basket.addItem(item1);
		basket.addItem(item2);

		assertEquals("Should have 1 item", 2, basket.getItems().size());
	}

	@Test
	public void add2ItemsOfSameType() {
		ShoppingItem item1 = new ShoppingItemImpl("Apple", 0.60);
		ShoppingItem item2 = new ShoppingItemImpl("Apple", 0.60);
		basket.addItem(item1);
		basket.addItem(item2);

		assertEquals("Should have 1 item with qty as 2", 1, basket.getItems()
				.size());
		assertEquals("Should have 1 item with qty as 2", new Integer(2), basket
				.getItems().get(item1));
	}
}