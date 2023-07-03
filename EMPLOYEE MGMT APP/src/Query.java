public class Query {
    static String insert = "INSERT INTO EMPLOYEE (id,name,emailid,salary) VALUES(?,?,?,?)";
    static String update = "UPDATE EMPLOYEE SET NAME = ? WHERE ID = ?";
    static String delete = "DELETE FROM EMPLOYEE WHERE ID = ?";
    static String select = "SELECT * FROM EMPLOYEE";
}
