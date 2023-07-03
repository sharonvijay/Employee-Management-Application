public class Employee {
    private int id;
    private String name;
    private String emailid;
    private int salary;

    public Employee(int id, String name, String emailid, int salary) {
        this.id = id;
        this.name = name;
        this.emailid = emailid;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmailid() {
        return emailid;
    }

    public int getSalary() {
        return salary;
    }

    public String toString() {
        return "EMPLOYEE [ id = " + id + " name = " + name + " emailid = " + emailid + " salary = " + salary + " ]";
    }

}
