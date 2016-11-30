package org.rvndps.fliptile.items;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInputPoint extends Point {

	public UserInputPoint(int maxX, int maxY) {
		super(maxX, maxY);
	}

	public Point getPoint() {
		InputStreamReader stream = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(stream);
		try {
			System.out.print("Enter x y: ");
			String[] value = br.readLine().split(" ");
			UserInputPoint obj = new UserInputPoint(
					Integer.valueOf(value[0]),
					Integer.valueOf(value[1])
					);
			return obj;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
