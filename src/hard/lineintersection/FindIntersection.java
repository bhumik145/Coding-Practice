package hard.lineintersection;

public class FindIntersection {

	public static Point findIntersection(Line line1, Line line2) {

		if (Double.compare(line1.getSlope(), line2.getSlope()) == 0) {
			// Lines are parallel or same
			if (Double.compare(line1.getyIntercept(), line2.getyIntercept()) == 0) {
				System.out.println("These are the same lines");
				// TODO
				// Here the problem becomes trickier, we have to see if these
				// two line segments intercept at all or not.
				
			} else {
				System.out.println("No intersection for parallel lines");
			}
			return null;
		} else {
			// Line intersection is definite, once intersection point is found,
			// check whether it falls on both the line segments or not

			/**
			 * x coordinate of intersecting point:
			 * 
			 * y = m1x + c1
			 * 
			 * y = m2x + c2
			 * 
			 * m1x + c1 = m2x + c2
			 * 
			 * x (m1 - m2) = c2 - c1 ==> x = (c2 - c1) / (m1 - m2)
			 */
			double x = (line2.getyIntercept() - line1.getyIntercept()) / (line1.getSlope() - line2.getSlope());

			// y = m1x + c1

			double y = line1.getSlope() * x + line1.getyIntercept();

			Point intersection = new Point(x, y);
			if (isPointOnThisLineSegment(intersection, line1) && isPointOnThisLineSegment(intersection, line2)) {
				return intersection;
			} else {
				System.out.println(
						"Intersection found: " + intersection + " but it doesn't fall on both the line segments");
				return null;
			}
		}
	}

	public static boolean isPointOnThisLineSegment(Point point, Line lineSegment) {
		if ((point.getX() <= lineSegment.getPoint1().getX() && point.getX() >= lineSegment.getPoint2().getX())
				|| (point.getX() <= lineSegment.getPoint2().getX() && point.getX() >= lineSegment.getPoint1().getX())) {
			if ((point.getY() <= lineSegment.getPoint1().getY() && point.getY() >= lineSegment.getPoint2().getY())
					|| (point.getY() <= lineSegment.getPoint2().getY()
							&& point.getY() >= lineSegment.getPoint1().getY())) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		Point point1 = new Point(0, 0);
		Point point2 = new Point(5, 5);

		Point point3 = new Point(0, 5);
		Point point4 = new Point(5, 0);

		Line line1 = new Line(point1, point2);
		Line line2 = new Line(point3, point4);

		System.out.println("Intersection = " + findIntersection(line1, line2));
	}

}
