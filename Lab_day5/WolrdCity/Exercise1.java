package WolrdCity;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Exercise1 {

    public static void main(String[] args) {
        CountryDao countryDao = InMemoryWorldDao.getInstance();

        countryDao.findAllCountries()
                .stream()
                .forEach(country -> country.getCities()
                        .stream()
                        .filter(city -> city != null)
                        .max(
                                (city1, city2) -> Integer.compare(city1.getPopulation(),
                                        city2.getPopulation()))
                        .ifPresent(System.out::println));

        // countryDao.findAllCountries()
        // .stream()
        // .forEach(country -> country.getCities()
        // .stream()
        // .filter(city -> city != null)
        // .max(Comparator.comparingInt(city -> city.getPopulation()))
        // .ifPresent(System.out::println));
    }

}