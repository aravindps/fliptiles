package org.rvndps.fliptile.items;

public class Point {
	public final int x;
	public final int y;
	public Point(int x, int y) { this.x = x; this.y = y; }
	public Point getPoint() { return new Point(x, y); }
}

