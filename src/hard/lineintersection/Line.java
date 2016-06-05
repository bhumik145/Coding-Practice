package hard.lineintersection;

public class Line {

	private Point point1;
	private Point point2;
	private double slope;
	private double yIntercept;

	public Line(Point point1, Point point2) {
		super();
		this.point1 = point1;
		this.point2 = point2;
		slope = calculateSlope(this);
		yIntercept = getYIntercept(this);
	}

	public Point getPoint1() {
		return point1;
	}

	public void setPoint1(Point point1) {
		this.point1 = point1;
	}

	public Point getPoint2() {
		return point2;
	}

	public void setPoint2(Point point2) {
		this.point2 = point2;
	}

	public double getSlope() {
		return slope;
	}

	public void setSlope(double slope) {
		this.slope = slope;
	}

	public double getyIntercept() {
		return yIntercept;
	}

	public void setyIntercept(double yIntercept) {
		this.yIntercept = yIntercept;
	}

	public static double calculateSlope(Line line) {
		// (y2 - y1)/(x2 - x1)
		return (line.getPoint2().getY() - line.getPoint1().getY())
				/ (line.getPoint2().getX() - line.getPoint1().getX());
	}

	public static double getYIntercept(Line line) {
		// y = mx + c ==> c = y - mx
		return line.getPoint1().getY() - (line.getSlope() * line.getPoint1().getX());
	}

	@Override
	public String toString() {
		return "Line [point1=" + point1 + ", point2=" + point2 + ", slope=" + slope + "]";
	}
}
