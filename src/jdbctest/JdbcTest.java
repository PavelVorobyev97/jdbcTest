package jdbctest;

import java.sql.*;

public class JdbcTest {

    public static void main(String[] args) throws SQLException {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        String user = "admin";
        String pass = "admin";

        try {
            // 1. Get a connection to database
            
            myConn = DriverManager.getConnection("jdbc:mysql://localhost/my ? "
                    + "useUnicode=true & "
                    + "useJDBCCompliantTimezoneShift=true & "
                    + "useLegacyDatetimeCode=false & "
                    + "serverTimezone=UTC", user, pass);

            // 2. Create a statement
            myStmt = myConn.createStatement();

            // 3. Execute SQL query
            myStmt.executeUpdate("UPDATE my.users SET mail = 'pavlikvorobyev@gmail.com' WHERE id = 1");
            myRs = myStmt.executeQuery("select * from my.users");

            // 4. Process the result set
            while (myRs.next()) {
                System.out.println(myRs.getString("name") + ", " + myRs.getString("phone")+ ", " + myRs.getString("mail"));
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
        System.out.println("Lol");
    }
}
