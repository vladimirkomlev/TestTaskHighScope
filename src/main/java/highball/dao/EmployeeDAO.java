package highball.dao;

/**
 * Created by programmer on 31.01.17.
 */
public interface EmployeeDAO {
    EmployeeDAO getEmployeeById(int id);
    String getHashPasswordByLogin(String login);
}
