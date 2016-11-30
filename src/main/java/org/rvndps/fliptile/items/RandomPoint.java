package org.rvndps.fliptile.items;

import java.util.Random;

public class RandomPoint extends Point {

	Random rand;
	public RandomPoint(int maxX, int maxY) {
		super(maxX, maxY);
		rand = new Random(Math.max(maxX, maxY));
	}

	@Override
	public Point getPoint() {
		Integer randX = (rand.nextInt(x) * rand.nextInt(x) * rand.nextInt(y)) % x;
		Integer randY = (rand.nextInt(y) * rand.nextInt(x) * rand.nextInt(x)) % y;
		return new RandomPoint(randX, randY);
	}
}
