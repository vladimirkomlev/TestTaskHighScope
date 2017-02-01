package highball.action;

import highball.daoImlp.EmployeeDaoImpl;
import highball.domain.Employee;
import highball.encryption.EncryptPassword;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class LoginAction implements SessionAware {

    private Map<String, Object> session;
    private EmployeeDaoImpl employee;
    private String login;
    private String password;
    private EncryptPassword encryptPassword;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    private boolean validationPassword() {
        boolean result = false;
        employee = new EmployeeDaoImpl();
        String hashPassword = employee.getHashPasswordByLogin(login);
        encryptPassword = new EncryptPassword();
        System.out.println("hashPassword " + hashPassword);
        if (hashPassword.equals(encryptPassword.getHashPassword(password))) {
            System.out.println("validationPassword() in If");
            result = true;
        }
        return result;
    }

    private String checkIn() {
        String result = "login";
        String employeeKey = "employee";
        Employee employee = (Employee) session.get(employeeKey);
        if (employee == null) {
            if (validationPassword()) {
                Employee employee1 = new Employee(login, password);
                session.put(employeeKey, employee1);
                System.out.println("checkIn()");
                result = "success";
            } else {
                System.out.println("else - "+result);
                return result;
            }
        }
        System.out.println("result -- " + result);
        return result;
    }

    public String execute() {
        System.out.println("execute()");
        checkIn();
        return "success";
    }
}
