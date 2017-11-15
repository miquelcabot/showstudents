import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Reads the students stored in the school.sqlite3 database
 */
public class ReadDB {
    public ArrayList readStudents() {
        ArrayList al = new ArrayList();
        try {

            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:C://school.sqlite3");

            Statement stmt = con.createStatement();


            ResultSet rs = stmt.executeQuery("SELECT name, surname, year FROM students");
            while (rs.next()) {
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int year = rs.getInt("year");

                Student std = new Student();
                std.setName(name);
                std.setSurname(surname);
                std.setYear(year);

                //std.setName(rs.getString("name"));
                //std.setSurname(rs.getString("surname"));
                //std.setYear(rs.getInt("year"));

                al.add(std);
            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return al;
    }
}
