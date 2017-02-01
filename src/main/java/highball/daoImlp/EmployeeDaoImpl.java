package highball.daoImlp;

import highball.dao.EmployeeDAO;
import highball.provider.ProviderDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by programmer on 31.01.17.
 */
public class EmployeeDaoImpl implements EmployeeDAO{
    private static final String QUERY_BY_LOGIN="SELECT Employees.Password FROM db_high.Employees WHERE Employees.Login=?";

    @Override
    public EmployeeDAO getEmployeeById(int id) {
        return null;
    }

    @Override
    public String getHashPasswordByLogin(String login) {
        String hashPassword="";
        ProviderDAO providerDAO=new ProviderDAO();
        Connection connection=providerDAO.getConnection();
        PreparedStatement statement=null;
        try {
            statement=connection.prepareStatement(QUERY_BY_LOGIN);
            statement.setString(1, login);
            ResultSet rs=statement.executeQuery();
            while (rs.next()){
                hashPassword=rs.getString(1);
            }
        }catch (SQLException e){
            System.out.println("Error in query. "+ e.getMessage());
        }finally {
            providerDAO.closeConnectionAndStatement(connection, statement);
        }
        return hashPassword;
    }
}
