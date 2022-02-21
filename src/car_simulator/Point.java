/**
 * 
 */
package car_simulator;

/**
 * A simple class of a point, which here is the location in which the car could
 * be positioned. It has (x, y)-coordinates and some functions for updating
 * those, or toString()-ing them.
 * 
 * @author Johan Bengtsson
 *
 */
public class Point {
	private int x;
	private int y;

	/**
	 * Constructor for the Point-class. Creates the Point.
	 * 
	 * @param x - the x-coordinate of the Point.
	 * @param y - the y-coordinate of the Point.
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Function for updating the coordinates of a Point.
	 * 
	 * @param dx - the addition to the x-coordinate that should be made.
	 * @param dy - the addition to the y-coordinate that should be made.
	 */
	public void updateLocation(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}

	/**
	 * Method for getting the X-coordinate.
	 * 
	 * @return the x-coordinate of the Point.
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Method for getting the Y-coordinate.
	 * 
	 * @return the y-coordinate of the Point.
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Override of the toString()-method to make the Point printable.
	 */
	@Override
	public String toString() {
		return this.x + ", " + this.y;
	}

	/**
	 * Method for comparing two Points, which comes down to comparing their
	 * coordinates.
	 * 
	 * @param point - the point to compare with.
	 * @return true if they had the same coordinates, false otherwise.
	 */
	public boolean equals(Point point) {
		boolean success = true;
		if (this.x != point.getX()) {
			success = false;
		}
		if (this.y != point.getY()) {
			success = false;
		}
		return success;
	}
}
