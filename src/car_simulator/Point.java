/**
 * 
 */
package car_simulator;

/**
 * @author Johan Bengtsson
 *
 */
public class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void updateLocation(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}
