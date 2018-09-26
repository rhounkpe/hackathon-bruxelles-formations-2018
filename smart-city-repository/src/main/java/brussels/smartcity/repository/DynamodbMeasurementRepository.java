package brussels.smartcity.repository;

import brussels.smartcity.model.Measurement;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class DynamodbMeasurementRepository extends DynamodbRepository {

    DynamoDB dynamoDB = new DynamoDB(getDynamoDBClient());

    Table table = dynamoDB.getTable("Sound2Team5");


    public List<Measurement> getAll() {
        List<Measurement> measurements = new ArrayList<>();

        ScanSpec scanSpec = new ScanSpec().withProjectionExpression("date, deviceId, Laeq15, Laeq60")
                .withFilterExpression("");

        try {
            ItemCollection<ScanOutcome> items = table.scan();

            Iterator<Item> iter = items.iterator();

            while (iter.hasNext()) {
                Item item = iter.next();

                Measurement measurement = new Measurement();
                measurement.setDeviceId(item.getString("deviceId"));
                measurement.setLaeq15(Double.parseDouble(item.getString("Laeq15")));
                measurement.setLaeq60(Double.parseDouble(item.getString("Laeq60")));

                measurements.add(measurement);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return measurements;

    }


}
