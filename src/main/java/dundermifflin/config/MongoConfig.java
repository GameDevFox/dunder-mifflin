package dundermifflin.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
public class MongoConfig extends AbstractMongoConfiguration {

    private @Autowired String databaseHost;

    @Override
    protected String getDatabaseName() {
        return "dunderMifflin";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(databaseHost, 27017);
    }
}
