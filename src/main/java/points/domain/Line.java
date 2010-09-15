package points.domain;

import org.nakedobjects.applib.annotation.Disabled;

public class Line {

	private double slope, yIntercept;

	@Disabled
	public void setSlope(final double slope) {
		this.slope = slope;
	}

	public double getSlope() {
		return slope;
	}

	@Disabled
	public void setYIntercept(final double yIntercept) {
		this.yIntercept = yIntercept;
	}

	public double getYIntercept() {
		return yIntercept;
	}
}
