package highball.domain;

/**
 * Created by programmer on 31.01.17.
 */
public class Employee {

    private String login;
    private String password;
    private String firstName;
    private String lastName;

    public Employee(String login, String password){
        this.login=login;
        this.password=password;
    }

    public Employee(){}

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
