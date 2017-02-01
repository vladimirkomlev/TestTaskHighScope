package highball.dao;

import highball.domain.Country;

import java.util.List;

/**
 * Created by root on 19.01.17.
 */
public interface CountryDAO {

    List<Country> getAllCountries();
    Country getCountryByName(String nameCounry);
}
