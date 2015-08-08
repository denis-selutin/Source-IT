package exam;

import java.math.BigDecimal;

/**
 *
 */
public interface Service {
    Long getCountryPopulation(String name);
    Country getOvercrowdedCountry();
    BigDecimal getCountrySquare(String name);
    BigDecimal getTotalDensityOfPeople(String name);
    BigDecimal getAverageDensityOfPeopleByStates(String name);
    String getOvercrowdedState(String name);
    String getBiggestState(String name);
}
