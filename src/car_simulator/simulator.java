/**
 * 
 */
package car_simulator;

import java.util.Random;

/**
 * @author Johan Bengtsson
 *
 */
public class simulator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Room room = new Room(20, 20);
		int x = 0;
		int y = 0;
		int direction = 90;
		room.createCar(new Point(x, y), direction);
		for (int i = 0; i < 20; i++) {
			Random rand = new Random();
			room.moveCar(true);
			System.out.println(room.writeCarPosition().toString());
		}
		
		ResultTracker.presentResults(room.writeCarPosition());
	}

}
