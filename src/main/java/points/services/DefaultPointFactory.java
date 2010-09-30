package points.services;

import org.nakedobjects.applib.AbstractService;
import org.nakedobjects.applib.value.Color;

import points.domain.Point;

/**
 * An example of a Factory. It illustrates what factories
 * can do but does not provide any functionality not already
 * available through the system repository for the Point class.
 */
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
