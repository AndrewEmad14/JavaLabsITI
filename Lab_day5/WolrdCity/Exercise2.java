package WolrdCity;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Exercise2 {

    public static void main(String[] args) {
        CountryDao countryDao = InMemoryWorldDao.getInstance();

        countryDao.getAllContinents()
                .stream()
                .map(contient -> countryDao.findCountriesByContinent(contient)
                        .stream()
                        .flatMap(country -> country.getCities().stream())
                        .filter(city -> city != null)
                        .max((city1, city2) -> Integer.compare(city1.getPopulation(), city2.getPopulation())))
                .forEach(OptionalCity -> OptionalCity.ifPresent(System.out::println));

    }
}
