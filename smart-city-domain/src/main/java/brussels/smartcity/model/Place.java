package brussels.smartcity.model;


public class Place {
    private StreetNumber streetNumber;
    private Route route;
    private Locality locality;
    private AdministrativeAreaLevel administrativeAreaLevel;
    private Country country;
    private PostalCode postalCode;



    private String formattedAddress() {
        return this.route.getLong_name() + " " + this.streetNumber.getLong_name() + ", "
                + this.postalCode.getLong_name() + " " + this.locality.getLong_name() + ", "
                + this.country.getLong_name();
    }
    @Override
    public String toString() {
        return this.formattedAddress();
    }

    /*

    * https://maps.googleapis.com/maps/api/geocode/json?address=302+avenue+van+Volxem,+Forest&key=AIzaSyAp06X8SVLRt56KrW8JHY7_wQBlIo5UYxA
     */
}
