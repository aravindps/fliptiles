package org.rvndps.fliptile.game;

import java.util.Objects;

import org.rvndps.fliptile.floor.Floor;
import org.rvndps.fliptile.floor.FloorRows;
import org.rvndps.fliptile.floor.Ground;
import org.rvndps.fliptile.items.Item;
import org.rvndps.fliptile.items.Point;
import org.rvndps.fliptile.items.UserInputPoint;
import org.rvndps.fliptile.player.Player;

public class Game {

	private Player player;
	private Ground ground;

	public Game(Player player, Ground ground) {
		Objects.requireNonNull(player);
		Objects.requireNonNull(ground);
		this.player = player;
		this.ground = ground;
	}
	
	public boolean play() {
		System.out.println("Game Start");
		while((player.isAlive && player.isTurnAvailable) && !player.isWon) {
			this.tryDigging(player.givePoint());
		}
		return (player.isAlive && player.isWon);
	}
	

	private void tryDigging(Point point) {
		try {
			ground.toggleWave(point.x, point.y);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Please enter a valid input");
		}
		System.out.println("Digging index: " + point.x + ":" + point.y);
		System.out.println(ground);
		player.isTurnAvailable = ground.isAnyUnDug();
		player.isWon = !ground.isAnyUnDug(); 
	}
	
	public static void main(String[] args) {
		int maxX = 5;
		int maxY = 3;
		boolean won = new Game(
				new Player(new UserInputPoint(maxX, maxY)),
				new Ground(
						new FloorRows(
								new Floor(new Item("0")),
								new Floor(new Item("4")),
								new Floor(new Item("1")),
								new Floor(new Item("2")),
								new Floor(new Item("3"))
								),
						new FloorRows(
								new Floor(new Item("0")),
								new Floor(new Item("4")),
								new Floor(new Item("1")),
								new Floor(new Item("2")),
								new Floor(new Item("3"))
								),
						new FloorRows(
								new Floor(new Item("0")),
								new Floor(new Item("Bomb")),
								new Floor(new Item("1")),
								new Floor(new Item("2")),
								new Floor(new Item("3"))
								)
						)
				).play();
		String wonStatus = won ? "You Won!" : "Game Over!";
		System.out.println(wonStatus);
	}
}
