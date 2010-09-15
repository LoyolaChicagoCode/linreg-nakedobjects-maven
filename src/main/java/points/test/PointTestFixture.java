package points.test;

import org.apache.log4j.Logger;
import org.nakedobjects.applib.DomainObjectContainer;
import org.nakedobjects.applib.fixtures.FixtureType;
import org.nakedobjects.applib.fixtures.InstallableFixture;
import org.nakedobjects.applib.value.Color;

import junit.framework.TestCase;
import junit.textui.TestRunner;
import points.domain.Point;
import points.services.PointFactory;

/**
 * A test case for Point. The main purpose of this class is
 * to demonstrate a possible integration of NOF with JUnit.
 * This test case runs as a NOF fixture; that is, the entry point is the
 * install method. The injected services on which this test case depends
 * are stored in static variables. The use of static variables is a kludge
 * for invoking the JUnit test runner programmatically, which happens on
 * a separate instance of the fixture.
 */
public class PointTestFixture extends TestCase implements InstallableFixture {

	private final static Logger LOGGER = Logger.getLogger(PointTestFixture.class);

	// NOF needs this constructor
	public PointTestFixture() { super("TestPointFixture"); }

	// JUnit needs this one
	public PointTestFixture(String name) { super(name); }

	private static DomainObjectContainer container;

	protected DomainObjectContainer getContainer() {
        return PointTestFixture.container;
    }

	public void setContainer(final DomainObjectContainer container) {
		LOGGER.debug("setting container to " + container);
        PointTestFixture.container = container;
    }

	private static PointFactory factory;

	protected PointFactory getPointFactory() {
		return PointTestFixture.factory;
	}

	public void setPointFactory(final PointFactory factory) {
		LOGGER.debug("setting factory to " + factory);
		PointTestFixture.factory = factory;
	}

	@Override
	public void install() {
		LOGGER.info("installing the fixture");
		TestRunner.run(PointTestFixture.class);
		System.exit(0);
	}

	@Override
	public FixtureType getType() {
		return FixtureType.OTHER;
	}

	public void setUp() throws Exception {
		for (final Point p : getContainer().allInstances(Point.class)) {
			getContainer().remove(p);
		}
	}

	public void tearDown() throws Exception {
	}

	public void testCreateNewPoint() {
		final Point p = getPointFactory().createNewPoint(2, 3, Color.WHITE);
		assertEquals(2.0, p.getX());
		assertEquals(3.0, p.getY());
		assertEquals(Color.WHITE, p.getColor());
	}
}
