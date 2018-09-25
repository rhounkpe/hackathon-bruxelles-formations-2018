package brussels.smartcity.repository;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

public abstract class DynamodbRepository {
    private final AmazonDynamoDB dynamoDB = AmazonDynamoDBClientBuilder.standard().build();

    protected AmazonDynamoDB getDynamoDBClient() {
        return dynamoDB;
    }
}
