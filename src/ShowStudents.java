import java.util.ArrayList;
import java.util.Iterator;

/**
 * Shows the students stored in the school.sqlite3 database
 */
public class ShowStudents {
    public static void main(String[] args) {
        ReadDB readDB = new ReadDB();

        ArrayList al = readDB.readStudents();
        Iterator itr = al.iterator();
        System.out.println("<table>");
        System.out.println("<tr><th>Name</th><th>Surname</th><th>Year</th></tr>");
        while (itr.hasNext()) {
            Student std = (Student) itr.next();
            System.out.println("<tr><td>"+std.getName()+"</td><td>"+
                    std.getSurname()+"</td><td>"
                    +std.getYear()+"</td></tr>");
        }
        System.out.println("</table>");
    }
}
