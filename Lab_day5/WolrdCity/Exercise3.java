package WolrdCity;

import java.util.Objects;
import java.util.Optional;

import static java.lang.System.out;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.maxBy;

public class Exercise3 {

    public static void main(String[] args) {
        CountryDao countryDao = InMemoryWorldDao.getInstance();
        CityDao cityDao = InMemoryWorldDao.getInstance();

        countryDao.findAllCountries()
                .stream()
                .map(country -> country.getCapital())
                .map((cityId) -> cityDao.findCityById(cityId))
                .filter(optionalCity -> optionalCity != null)
                .max((city1, city2) -> Integer.compare(city1.getPopulation(), city2.getPopulation()))
                .ifPresent(System.out::println);
        // write your answer here
    }

}