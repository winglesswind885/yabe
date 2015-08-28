import models.*;
import play.jobs.*;
import play.test.*;

@OnApplicationStart
public class Bootstrap extends Job {

	public void doJob() {
		// Check if the database is empty
		if(User.count() == 0) {
			Fixtures.loadModels("initial-data.yml");
		}
	}
}
