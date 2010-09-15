package points.services;

import points.domain.Line;

/**
 * An interface for business service objects that provide linear regression.
 */
public interface RegressionService {

	void removeAllPoints();
	
	Line performRegression();

}
