package brussels.smartcity.repository;

import brussels.smartcity.model.*;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Repository
public class DynamodbMeasurementRepository extends DynamodbRepository {

    String[] addresses = new String[]{
            "Zeelaan 337, 8670 Koksijde, Belgie",
            "Impasse de la Fidélité 4, 1000 Bruxelles, Belgique",
            "Marché Saint-Remy 12, 5000 Namur, Belgique",
            "Grand-place, 1000 Bruxelles, Belgique",
            "Square de l'Atomium, 1020 Bruxelles, Belgique",
            "Pelgrimstraat 15, 2000 Anvers, Belgique",
            "Bij Sint-Jacobs 17, 9000 Gand, Belgique",
            "Avenue Delchambre 8, 4500 Huy, Belgique",
            "Chaussée d'Enghien 177, 7060 Soignies, Belgique",
            "Markt 9, 3080 Tervuren, Belgique"};




    GeocodingResult[] results;
    Random random = new Random();



    DynamoDB dynamoDB = new DynamoDB(getDynamoDBClient());

    Table table = dynamoDB.getTable("Sound2Team5");


    public List<Measurement> getAll() {






        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyAp06X8SVLRt56KrW8JHY7_wQBlIo5UYxA")
                .build();








        List<Measurement> measurements = new ArrayList<>();



        ScanSpec scanSpec = new ScanSpec().withProjectionExpression("date, deviceId, Laeq15, Laeq60")
                .withFilterExpression("");

        try {
            ItemCollection<ScanOutcome> items = table.scan();

            Iterator<Item> iter = items.iterator();


            while (iter.hasNext()) {
                Item item = iter.next();

                int ind = random.nextInt(9);
                String address = addresses[ind];

                {
                    try {
                        results = GeocodingApi.geocode(context,
                                address).await();
                    } catch (ApiException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


                Gson gson = new GsonBuilder().setPrettyPrinting().create();

                String streetNumberShort = results[0].addressComponents[0].shortName;
                String streetNumberLong = results[0].addressComponents[0].longName;

                String routeLngName = results[0].addressComponents[1].longName;
                String routeShortName = results[0].addressComponents[1].shortName;

                String localityLongName = results[0].addressComponents[2].longName;
                String localityShortName = results[0].addressComponents[2].shortName;

                String adminLongName = results[0].addressComponents[3].longName;
                String adminShortName = results[0].addressComponents[3].shortName;

                String countryLongName = results[0].addressComponents[4].longName;
                String countryShortName = results[0].addressComponents[4].shortName;

                String postalCodeLongName = results[0].addressComponents[5].longName;
                String postalCodeShortName = results[0].addressComponents[5].shortName;

                Place place = new Place();
                place.setStreetNumber(new StreetNumber(streetNumberShort, streetNumberLong));
                place.setCountry(new Country(countryLongName, countryShortName));
                place.setRoute(new Route(routeLngName, routeShortName));
                place.setLocality(new Locality(localityLongName, localityShortName));
                place.setAdministrativeAreaLevel(new AdministrativeAreaLevel(adminLongName, adminShortName));
                place.setPostalCode(new PostalCode(postalCodeLongName, postalCodeShortName));


                Measurement measurement = new Measurement();
                measurement.setDeviceId(item.getString("deviceId"));
                measurement.setLaeq15(Double.parseDouble(item.getString("Laeq15")));
                measurement.setLaeq60(Double.parseDouble(item.getString("Laeq60")));

                measurement.setDate(LocalDateTime.parse(item.getString("date")));

                measurement.setPlace(place);


                measurements.add(measurement);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return measurements;

    }


}
