package systemDesign.rest;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Json {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException, URISyntaxException {
        String eString = "{\"id\" : 1, \"firstName\": \"Mike\", \"lastName\": \"Botoskwi\", \"departmentId\": 2, \"salary\": 150000}";
        Employee employee1 = objectMapper.readValue(eString, Employee.class);

        Employee employee2 = new Employee(2, "Barret", "Jones", 3, 250000);
        //System.out.print(objectMapper.writeValueAsString(employee2));

        // For List of JSON.
        JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, Employee.class);
        List<Employee> employeeList = objectMapper.readValue("[{\"id\" : 1, \"firstName\": \"Mike\", \"lastName\": \"Botoskwi\", \"departmentId\": 2, \"salary\": 150000}]",
                                                          type);
        List<Employee> employeeList2 = new ArrayList<>();
        employeeList2.add(employee1);
        employeeList2.add(employee2);

        //System.out.print(objectMapper.writeValueAsString(employeeList2));

        // File
        URL url = Json.class.getResource("input.json");
        List<Employee> list = objectMapper.readValue(new File(url.toURI()), type);

        Map<String, Employee> map = new HashMap<>();

        for (Employee employee: list) {
            String hash = String.format("%s_%s", employee.firstName, employee.lastName);
            map.put(hash, employee);
        }

        for(Map.Entry<String, Employee> entry: map.entrySet()) {
            //System.out.print("\n");
            //System.out.print(entry.getKey());
            //System.out.print(entry.getValue());
        }
        for(String key: map.keySet()) {
        }
        for(Employee key: map.values()) {
        }

        // Ordered Map
        Map<Integer, Employee> sortedMap = new TreeMap<>((e1, e2) -> e1 - e2);
        sortedMap.put(3, employee1);
        sortedMap.put(1, employee2);

        // Unknown class
        // Prefix
        // "firstName==^[M-S][i-m]"; - Range Prefix
        // "firstName==^Mi"; - Prefix
        // "firstName==ke$" - Suffix
        String validation = "firstName==ke$";
        HashMap<String, String> map2 = objectMapper.readValue(eString, HashMap.class);
        String[] vals = validation.split("==");

        for(Map.Entry entry : map2.entrySet()) {
            if  (vals[0].equals(entry.getKey())) {
                Pattern pattern = Pattern.compile(vals[1]);
                Matcher matcher = pattern.matcher(entry.getValue().toString());
                if (matcher.find()) {
                    System.out.print(matcher.group());
                    System.out.println(entry.getKey() + ":" + entry.getValue());
                }
            }
        }
    }



    static class Employee {
        private Integer id;
        private String firstName;
        private String lastName;
        private Integer departmentId;
        private Integer salary;

        public Employee() {

        }

        public Employee(String firstName, String lastName, Integer departmentId) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.departmentId = departmentId;
        }

        public Employee(Integer id, String firstName, String lastName, Integer departmentId, Integer salary) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.departmentId = departmentId;
            this.salary = salary;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
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

        public Integer getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(Integer departmentId) {
            this.departmentId = departmentId;
        }

        public Integer getSalary() {
            return salary;
        }

        public void setSalary(Integer salary) {
            this.salary = salary;
        }
    }
}
