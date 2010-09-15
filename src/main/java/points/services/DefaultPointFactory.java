package points.services;

import org.nakedobjects.applib.AbstractService;
import org.nakedobjects.applib.value.Color;

import points.domain.Point;

public class DefaultPointFactory extends AbstractService implements PointFactory {

	@Override
	public Point createNewPoint(final double x, final double y, final Color color) {
		final Point p = newTransientInstance(Point.class);
		p.setX(x);
		p.setY(y);
		p.setColor(color);
		persist(p);
		return p;
	}
}
