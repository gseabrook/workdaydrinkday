package seabrook;

public class Employee {

    private final String emailAddress;

    public Employee(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
