package points.services;

import org.nakedobjects.applib.value.Color;

import points.domain.Point;

/**
 * The interface for the example Factory.
 */
public interface PointFactory {

	Point createNewPoint(final double x, final double y, final Color color);
}
