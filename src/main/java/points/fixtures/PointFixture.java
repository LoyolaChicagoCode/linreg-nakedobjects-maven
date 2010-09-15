package points.fixtures;

import org.apache.log4j.Logger;
import org.nakedobjects.applib.fixtures.AbstractFixture;
import org.nakedobjects.applib.value.Color;

import points.services.PointFactory;

public class PointFixture extends AbstractFixture {

	private final static Logger LOGGER = Logger.getLogger(PointFixture.class);

	private PointFactory factory;

	protected PointFactory getPointFactory() {
		return this.factory;
	}

	public void setPointFactory(final PointFactory factory) {
		LOGGER.debug("setting factory to " + factory);
		this.factory = factory;
	}

	@Override
	public void install() {
		LOGGER.info("installing the fixture");
		getPointFactory().createNewPoint(-2.5, 3.5, Color.BLACK);
		getPointFactory().createNewPoint(1.5, -3.5, Color.WHITE);
	}
}
