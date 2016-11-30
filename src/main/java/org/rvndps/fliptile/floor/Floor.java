package org.rvndps.fliptile.floor;

import org.rvndps.fliptile.items.Item;

public class Floor {

	private Item item;
	private boolean isExposed = false;
	public Floor(Item item) { this.item = item; }
	public Floor() { this(null); }

	public String peek() { return item.whoAreYou(); }
	public void toggle() { this.isExposed = !this.isExposed; }
	public boolean isDug() { return isExposed; }
	
	@Override
	public String toString() {
		return "Floor => Item: " + item.toString() + ", Dug: " + isDug();
	}
}
