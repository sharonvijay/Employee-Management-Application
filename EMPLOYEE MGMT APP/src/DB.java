import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    static Connection conn = null;

    public static Connection connect() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String db = "ENTER YOUR DATABASE NAME";
            String userName = "root";
            String password = "ENTER YOUR PASSWORD";

            conn = DriverManager.getConnection(url + db, userName, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;

    }

}
