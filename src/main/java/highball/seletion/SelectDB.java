package highball.seletion;

import highball.domain.ResultSelection;
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
public class SelectDB {

    private static String QUERY="select " +
            "(select db_high.Employees.LastName from db_high.Employees where db_high.Employees.Id=Orders.EmployeeID) as Employee, " +
            "Orders.RegionID, " +
            "sum(Orders.Cost) as Amount " +
            "from db_high.Orders " +
            "inner join db_high.Regions " +
            "on Orders.RegionID=Regions.Id " +
            "where Regions.CountryId=? " +
            "group by EmployeeID, RegionID";

    private ProviderDAO provider;
    private PreparedStatement statement;

    public List getOrdersByCountryId(int idCountry){
        List<ResultSelection> listResult= new ArrayList<>();
        Connection connection = getConnection();
        try {
            statement=connection.prepareStatement(QUERY);
            statement.setInt(1, idCountry);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                ResultSelection resultSelection = new ResultSelection();
                resultSelection.setLastName(rs.getString(1));
                resultSelection.setRegionId(rs.getInt(2));
                resultSelection.setAmount(rs.getInt(3));
                listResult.add(resultSelection);
            }
        }catch (SQLException e){
            System.out.println("Error in query.");
            System.out.println(e.getMessage());
        }finally {
            provider.closeConnectionAndStatement(connection, statement);
        }
        return listResult;
    }

    private Connection getConnection(){
        provider=new ProviderDAO();
        return provider.getConnection();
    }
}
