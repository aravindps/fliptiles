package org.rvndps.fliptile.items;

public class Item {
	private final String _type;
	public Item(String itemType) { this._type = itemType; }
	public String whoAreYou() { return _type; }
	@Override public String toString() { return this._type; }
}
