package WorldStream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Exercise1 {

   public static void main(String[] args) {
      CountryDao countryDao = InMemoryWorldDao.getInstance();
      ;

      countryDao.findAllCountries().forEach(country -> country.getCities().stream()
            .max(
                  (city1, city2) -> Integer.compare(city1.getPopulation(), city2.getPopulation()))
            .ifPresent(System.out::println));
   }

}