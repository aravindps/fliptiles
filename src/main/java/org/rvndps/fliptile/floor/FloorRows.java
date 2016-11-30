package org.rvndps.fliptile.floor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class FloorRows extends ArrayList<Floor>{

	private static final long serialVersionUID = -3823562576378033290L;
	public FloorRows(Collection<Floor> floor) { super(floor); }
	public FloorRows(Floor...floor) { this(Arrays.asList(floor)); }
	
	public void toggle(int floorNumber) throws Exception {
		if(isFloorAvailable(floorNumber))
			get(floorNumber).toggle();
	}

	public void toggleWave(int floorNumber) throws Exception {
		toggle(floorNumber - 1);
		toggle(floorNumber);
		toggle(floorNumber + 1);
	}
	
	public boolean isAnyUnDug() { return stream().anyMatch(floor -> !floor.isDug()); }
	public boolean isOnlyBombLeft() { return !stream().anyMatch(floor -> !floor.isDug() && !floor.peek().equalsIgnoreCase("Bomb")); }
	public boolean isAllDug() { return !stream().anyMatch(floor -> !floor.isDug()); }
	private boolean isFloorAvailable(int floorNumber) { return floorNumber >= 0 && size() > floorNumber; }
}
