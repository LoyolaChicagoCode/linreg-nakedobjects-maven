package points.services;

import org.nakedobjects.applib.AbstractService;

import points.domain.Line;
import points.domain.Point;

/**
 * A default regression service implementation. This implementation is stateless
 * and, consequently, thread-safe.
 */
public class DefaultRegressionService extends AbstractService implements
		RegressionService {

	@Override
	public Line performRegression() {
		int n = 0;
		double sumxx = 0;
		double sumyy = 0;
		double sumxy = 0;
		double sumx = 0;
		double sumy = 0;

		for (final Point p : getContainer().allInstances(Point.class)) {
			n++;
			double x = p.getX();
			double y = p.getY();
			sumx += x;
			sumy += y;
			sumxx += x * x;
			sumyy += y * y;
			sumxy += x * y;
		}

		final double sxx = sumxx - sumx * sumx / n;
		final double sxy = sumxy - sumx * sumy / n;
		final double slope = sxy / sxx;
		final double yIntercept = (sumy - slope * sumx) / n;

		final Line result = newTransientInstance(Line.class);
		result.setSlope(slope);
		result.setYIntercept(yIntercept);
		return result;
	}

	@Override
	public void removeAllPoints() {
		for (final Point p : getContainer().allInstances(Point.class))
			getContainer().remove(p);
	}
}
