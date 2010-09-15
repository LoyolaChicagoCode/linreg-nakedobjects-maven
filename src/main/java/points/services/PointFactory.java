package points.services;

import org.nakedobjects.applib.value.Color;

import points.domain.Point;

public interface PointFactory {

	Point createNewPoint(final double x, final double y, final Color color);
}
