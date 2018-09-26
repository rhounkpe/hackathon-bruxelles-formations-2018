package brussels.smartcity.model;

import java.util.ArrayList;
import java.util.List;

public class Addresses {
    private static List<String> addresses = new ArrayList<>();

    private static void buildAddresses() {
        addresses.add("Zeelaan 337, 8670 Koksijde, Belgie");
        addresses.add("Impasse de la Fidélité 4, 1000 Bruxelles, Belgique");
        addresses.add("Marché Saint-Remy 12, 5000 Namur, Belgique");
        addresses.add("Grand-place, 1000 Bruxelles, Belgique");
        addresses.add("Square de l'Atomium, 1020 Bruxelles, Belgique");
        addresses.add("Pelgrimstraat 15, 2000 Anvers, Belgique");
        addresses.add("Bij Sint-Jacobs 17, 9000 Gand, Belgique");
        addresses.add("Avenue Delchambre 8, 4500 Huy, Belgique");
        addresses.add("Avenue Delchambre 8, 4500 Huy, Belgique");
        addresses.add("Avenue Delchambre 8, 4500 Huy, Belgique");
        addresses.add("Chaussée d'Enghien 177, 7060 Soignies, Belgique");
        addresses.add("Markt 9, 3080 Tervuren, Belgique");
    }

    public static List<String> getAddresses() {
        return addresses;
    }
}
