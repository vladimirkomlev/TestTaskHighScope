package highball.daoImlp;

import highball.dao.CountryDAO;
import highball.domain.Country;
import highball.provider.ProviderDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 20.01.17.
 */
public class CountryDaoImpl implements CountryDAO {
    private static final String QUERY_BY_NAME = "select Countries.ID, Countries.Name from db_high.Countries where Countries.Name=?";
    private static final String QUERY_ALL_COUNTRY="select Countries.ID, Countries.Name from db_high.Countries";

    @Override
    public List<Country> getAllCountries() {
        List<Country> listCountries = new ArrayList<>();
        ProviderDAO provider=new ProviderDAO();
        Connection connection=provider.getConnection();
        PreparedStatement statement=null;
        try {
            statement=connection.prepareStatement(QUERY_ALL_COUNTRY);
            ResultSet rs=statement.executeQuery();
            while (rs.next()){
                Country country=new Country();
                country.setId(rs.getInt(1));
                country.setName(rs.getString("Name"));
                listCountries.add(country);
            }
        }catch (SQLException e){
            System.out.println("Error in query.");
            System.out.println(e.getMessage());
        }finally {
            provider.closeConnectionAndStatement(connection,statement);
        }
        return listCountries;
    }

    @Override
    public Country getCountryByName(String nameCountry) {
        Country country = null;
        ProviderDAO provider = new ProviderDAO();
        Connection connection = provider.getConnection();
        PreparedStatement statement=null;
        try {
            statement = connection.prepareStatement(QUERY_BY_NAME);
            statement.setString(1, nameCountry);
            System.out.println("PreparedStatement established.");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                country = new Country();
                country.setId(rs.getInt(1));
                country.setName(rs.getString("Name"));
            }
        } catch (SQLException e) {
            System.out.println("Error in query.");
            System.out.println(e.getMessage());
        }finally {
            provider.closeConnectionAndStatement(connection,statement);
        }
        return country;
    }
}
