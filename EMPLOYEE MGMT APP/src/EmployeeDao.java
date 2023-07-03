import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeDao {
    public static void createEmployee(Employee employee) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.insert;
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, employee.getId());
        preparedStatement.setString(2, employee.getName());
        preparedStatement.setString(3, employee.getEmailid());
        preparedStatement.setInt(4, employee.getSalary());

        System.out.println("\n ps = " + preparedStatement + "\n" + employee);

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public static void updateEmployee(int id, String name) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.update;
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(2, id);

        preparedStatement.setString(1, name);

        System.out.println("\n ps = " + preparedStatement);

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public static ArrayList<Employee> readEmployees() throws SQLException {
        ArrayList<Employee> emplist = new ArrayList<Employee>();
        Connection conn = DB.connect();
        String query = Query.select;
        Statement statement = conn.prepareStatement(query);
        System.out.println("\n st = " + statement);
        ResultSet res = statement.executeQuery(query);

        while (res.next()) {
            Employee emp = new Employee(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4));
            emplist.add(emp);
        }
        res.close();
        statement.close();
        return emplist;
    }

    public static void deleteEmployee(int id) throws SQLException {
        Connection conn = DB.connect();
        String query = Query.delete;
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, id);
        System.out.println("\n ps = " + preparedStatement);

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

}
