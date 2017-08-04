package com.naga.shopping.catalogue;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import com.naga.shopping.util.IllegialShoppingException;

/**
 * Concrete impl of the Shopping item interface
 */
public class ShoppingItemImpl implements ShoppingItem {
	private String name;
	private BigDecimal price;

	public ShoppingItemImpl(String name, Double price) {
		if (name == null || "".equalsIgnoreCase(name.trim())) {
			throw new IllegialShoppingException(
					"Item name can not be null or empty");
		}
		if (price == null || price < 0.0) {
			throw new IllegialShoppingException(
					"Item price can not be null or less than 0.0");
		}

		this.name = name.toUpperCase();
		this.price = new BigDecimal(price, new MathContext(2,
				RoundingMode.HALF_EVEN));

	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public BigDecimal getPrice() {
		return this.price;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass())
			return false;
		ShoppingItemImpl that = (ShoppingItemImpl) o;
		return name.equals(that.name);
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
