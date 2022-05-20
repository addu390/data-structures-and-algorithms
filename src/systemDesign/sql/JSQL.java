package systemDesign.sql;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JSQL {
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coderpad","root","");

            // Insert
            System.out.println("Current records:");
            Statement statement = connection.createStatement();
            java.util.Date previousDate = dateFormat.parse("2019-02-13 12:12:12");
            java.util.Date currentDate = new Date();

            String insertSql = String.format("INSERT INTO coderpad.projects (title, start_date, end_date, budget) " +
                                                     "VALUES ('%s', '%s', '%s', %d);",
                                             "Project", dateFormat.format(previousDate.getTime()),
                                             dateFormat.format(currentDate.getTime()), 10000);
            // statement.executeUpdate(insertSql);


            // Select Queries

            // WHERE d.name = "BACKEND";
            // WHERE p.start_date BETWEEN "2018-01-01 00:00:00" AND "2020-01-01 00:00:00";
            // WHERE p.start_date > "2020-01-01 00:00:00";
            // WHERE YEAR(p.start_date) > "2019";
            // ORDER BY p.budget;

            // Get employee and department
            String selectQuery = "SELECT e.id, e.first_name, e.last_name, d.name" +
                                " FROM coderpad.employees as e" +
                                " LEFT JOIN coderpad.departments as d" +
                                " ON e.department_id = d.id;";

            // Complete join
            String completeQuery = "SELECT e.id, e.first_name, e.last_name, p.title, d.name" +
                                    " FROM coderpad.employees_projects as ep" +
                                    " LEFT JOIN coderpad.employees as e ON ep.employee_id = e.id" +
                                    " LEFT JOIN coderpad.projects as p ON ep.project_id = p.id" +
                                    " JOIN coderpad.departments as d on e.department_id = d.id;";

            // Project Budget + Total Salary for a all Department.
            String budgetQuery = "SELECT d.name, SUM(e.salary), SUM(p.budget)/COUNT(DISTINCT e.id)" +
                                " FROM coderpad.employees_projects as ep" +
                                " LEFT JOIN coderpad.employees as e ON ep.employee_id = e.id" +
                                " LEFT JOIN coderpad.projects as p ON ep.project_id = p.id" +
                                " JOIN coderpad.departments as d on e.department_id = d.id" +
                                " GROUP BY d.name" +
                                " ORDER BY d.name;";

            ResultSet resultSet = statement.executeQuery(completeQuery);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int count = 0;
            while (resultSet.next()) {
                System.out.print(resultSet.getString("first_name"));
                count = count + 1;
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    if (i > 1) {
                        System.out.print(", ");
                    }
                    String columnValue = resultSet.getString(i);
                    // System.out.print(resultSetMetaData.getColumnName(i) + ": " + columnValue);
                }
                System.out.println("");
            }
            System.out.println("There are " + count + " records.");


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
