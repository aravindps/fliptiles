
package org.rvndps.fliptile.floor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Flow matrix
 * 
 * @author aravindps
 */
public class Ground extends ArrayList<FloorRows> {

	private static final long serialVersionUID = -2302739350136596859L;
	public Ground(Collection<FloorRows> floor) { super(floor); }
	public Ground(FloorRows... floor) { this(Arrays.asList(floor)); }

	public void toggle(int floorX, int floorY) throws Exception {
		if(isFloorAvailable(floorY))
			get(floorY).toggle(floorX);
	}

	public void toggleWave(int floorX, int floorY) throws Exception {
		toggle(floorX, floorY - 1);
		if(isFloorAvailable(floorY))
			get(floorY).toggleWave(floorX);
		toggle(floorX, floorY + 1);
	}

	/*
	public void dig(int floorX, int floorY) throws Exception {
		if (!isFloorAvailable(floorY)) {
			throw new Exception("Floor " + floorY + " is not available");
		}
		this.get(floorY).toggle(floorX);
		if(isFloorAvailable(floorY - 1))
			get(floorY - 1).toggle(floorX);
		get(floorY).toggle(floorX);
		if(isFloorAvailable(floorY + 1))
			get(floorY + 1).toggle(floorX);
	}
	*/

	private boolean isFloorAvailable(int floorNumber) { return floorNumber >= 0 && size() > floorNumber; }
	public boolean isAnyUnDug() { return stream().anyMatch(floor -> floor.isAnyUnDug()); }
	public boolean isOnlyBombLeft() { return !stream().anyMatch(floor -> !floor.isOnlyBombLeft()); }

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		int row = 0;
		for (FloorRows floorRows : this) {
			sb.append("\n  ");
			sb.append("+");
			sb.append(floorRows.stream().map(s -> "---").reduce("", (a, b) -> a + b));
			sb.append("+");
			sb.append("\n");
			sb.append(row++ + " | ");
			for (Floor floor : floorRows) {
//				sb.append(floor.peek());
				if (!floor.isDug()) {
					sb.append("*");
				} else {
					sb.append(" ");
				}
				sb.append(" |");
//				sb.append("\t");
			}
		}
		sb.append("\n");
		return sb.toString();
	}
	
}
