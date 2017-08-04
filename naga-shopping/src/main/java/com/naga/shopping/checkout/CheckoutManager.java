package com.naga.shopping.checkout;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Map;

import com.naga.shopping.catalogue.ShoppingItem;
import com.naga.shopping.util.IllegialShoppingException;

/**
 * Implements check out functionality for the basket
 */
public class CheckoutManager {

	/**
	 * Calculates the total price for the basket containing shopping items
	 * 
	 * @param basket
	 *            - Shopping basket containing the items to check out
	 * @return Big decimal representation of the total cost price for the basket
	 */
	public BigDecimal getTotalPrice(ShoppingBasket basket) {
		if (basket == null) {
			throw new IllegialShoppingException(
					"Shopping basket can not be null");
		}

		final Map<ShoppingItem, Integer> items = basket.getItems();
		MathContext mc = new MathContext(2, RoundingMode.HALF_EVEN);
		// Sum of quantity * price for all items
		return basket
				.getItems()
				.keySet()
				.stream()
				.map(item -> item.getPrice().multiply(
						new BigDecimal(items.get(item), mc)))
				.reduce(BigDecimal.ZERO, BigDecimal::add);

	}

}
