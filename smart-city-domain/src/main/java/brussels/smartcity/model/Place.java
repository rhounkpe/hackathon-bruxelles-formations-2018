package brussels.smartcity.model;


public class Place {
    private StreetNumber streetNumber;
    private Route route;
    private Locality locality;
    private AdministrativeAreaLevel administrativeAreaLevel;
    private Country country;
    private PostalCode postalCode;

    public StreetNumber getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(StreetNumber streetNumber) {
        this.streetNumber = streetNumber;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Locality getLocality() {
        return locality;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    public AdministrativeAreaLevel getAdministrativeAreaLevel() {
        return administrativeAreaLevel;
    }

    public void setAdministrativeAreaLevel(AdministrativeAreaLevel administrativeAreaLevel) {
        this.administrativeAreaLevel = administrativeAreaLevel;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public PostalCode getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(PostalCode postalCode) {
        this.postalCode = postalCode;
    }

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
