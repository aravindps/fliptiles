package org.rvndps.fliptile.player;

import org.rvndps.fliptile.items.Point;

public class Player {
	public boolean isAlive = true;
	public boolean isTurnAvailable = true;
	public boolean isWon = false;
	public final Point point;

	public Player(Point point) { this.point = point; }
	public Point givePoint() { return point.getPoint(); }
}
