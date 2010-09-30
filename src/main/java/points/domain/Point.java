package points.domain;

import org.nakedobjects.applib.DomainObjectContainer;
import org.nakedobjects.applib.annotation.MemberOrder;
import org.nakedobjects.applib.annotation.Named;
import org.nakedobjects.applib.value.Color;

/**
 * A simple point implementation.
 */
public class Point implements Comparable<Point> {

	private DomainObjectContainer container;

	protected DomainObjectContainer getContainer() {
        return this.container;
    }

	public void setContainer(final DomainObjectContainer container) {
        this.container = container;
    }

	public void remove() {
		getContainer().remove(this);
	}

	public Point copy() {
		final Point result = getContainer().newPersistentInstance(Point.class);
		result.setX(this.getX());
		result.setY(this.getY());
		result.setColor(this.getColor());
		return result;
	}

	private double x, y;

	@MemberOrder(sequence="1")
	public double getX() {
		return x;
	}

	public void setX(final double x) {
		this.x = x;
	}

	@MemberOrder(sequence="2")
	public double getY() {
		return y;
	}

	public void setY(final double y) {
		this.y = y;
	}

	private Color color;

	@MemberOrder(sequence="3")
	public Color getColor() {
		return color;
	}

	public void setColor(final Color color) {
		this.color = color;
	}

	public Color defaultColor() {
		return Color.WHITE;
	}

	@Override
	public int compareTo(Point that) {
		int compareX = Double.compare(this.getX(), that.getX());
		if (compareX != 0) return compareX;
		int compareY = Double.compare(this.getY(), that.getY());
		if (compareY != 0) return compareY;
		return this.getColor().intValue() - that.getColor().intValue();
	}

//	@Override
//	public boolean equals(Object that) {
//		return that instanceof Point && getX() == ((Point) that).getX() && getY() == ((Point) that).getY();
//	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("{x=");
		builder.append(getX());
		builder.append(",y=");
		builder.append(getY());
		builder.append(",col=");
		builder.append(getColor() == null ? "null" : getColor().title());
		builder.append("}@");
		builder.append(Integer.toHexString(super.hashCode()));
		return builder.toString();
	}

	public void scale(@Named("") final double factor) {
		setX(factor * getX());
		setY(factor * getY());
	}

	public void move(final double dx, final double dy) {
		setX(getX() + dx);
		setY(getY() + dy);
	}

	public void moveByPoint(final Point that) {
		setX(getX() + that.getX());
		setY(getY() + that.getY());
	}

	public Point add(final Point that) {
		final Point result = copy();
		result.moveByPoint(that);
		return result;
	}
}
