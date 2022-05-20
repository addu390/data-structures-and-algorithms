package systemDesign.sql;

// https://www.w3schools.com/sql/default.asp
public class Queries {
    /**
     // INSERT
     INSERT INTO table_name (column1, column2, column3, ...)
     VALUES (value1, value2, value3, ...);

     // UPDATE
     UPDATE table_name
     SET column1 = value1, column2 = value2, ...
     WHERE condition;
     */

    /** WHERE CONDITIONS (AND, OR, NOT)
     // OPERATORS
     WHERE condition1 OR condition2 OR condition3 ...;
     WHERE condition1 AND condition2 AND condition3 ...;
     WHERE NOT condition;

     // LIKE
     1. %: Represents zero or more characters (similar to *)
     2. _: Represents a single character (?)
     3. []: Represents any single character within the brackets: h[oa]t can be hot or hat.
     4. ^: 	Represents any character not in the brackets: h[^oa]t).
     5. -: Represents any single character within the specified range: c[a-f]t

     * WHERE CustomerName LIKE <pattern>, below are the example PATTERNS
           1. Start with "a": 'a%'
           2. End with "a": '%a'
           3. "ab" in any position: %ab%
           4. "a" is second position: '_a%'
           5. start with "a" and are at least 2 characters: 'a_%' ('a__%' - atleast 3 chars)
           6. start with "a", end with "b": 'a%b'

     * WHERE column_name IN (value1, value2, ...) or WHERE column_name IN (SELECT STATEMENT);
     * WHERE column_name BETWEEN value1 AND value2;

     // HAVING: WHERE for conditions on aggregate such as COUNT.
     SELECT COUNT(CustomerID), Country
     FROM Customers
     GROUP BY Country
     HAVING COUNT(CustomerID) > 5;

     // ORDER BY and CASE
     SELECT CustomerName, City, Country
     FROM Customers
     ORDER BY
     (CASE
        WHEN City IS NULL THEN Country
        ELSE City
     END);

     // GROUP BY
     SELECT COUNT(CustomerID), Country
     FROM Customers
     GROUP BY Country;

     // CASE
     SELECT OrderID, Quantity,
     CASE
     WHEN Quantity > 30 THEN 'The quantity is greater than 30'
     WHEN Quantity = 30 THEN 'The quantity is 30'
     ELSE 'The quantity is under 30'
     END AS QuantityText
     FROM OrderDetails;
     */

    // ====================================================================================================== //

    /** TOP, COUNT, AVG, SUM, MIN, MAX
     // LIMIT
     SELECT column_name(s)
     FROM table_name
     WHERE condition
     LIMIT number;

     // COUNT
     SELECT COUNT(column_name)
     FROM table_name
     WHERE condition;

     // AVERAGE
     SELECT AVG(column_name)
     FROM table_name
     WHERE condition;

     // SUM
     SELECT SUM(column_name)
     FROM table_name
     WHERE condition;

     // MIN/MAX
     SELECT MIN(column_name)
     FROM table_name
     WHERE condition;
     */

    // ====================================================================================================== //

    /** JOINING TABLES
     * INNER JOIN: selects records that have matching values in both tables.
     * LEFT JOIN: All records from the left table (table1), and the matching records from the right table (table2).
     * UNION operator is used to combine the result-set of two or more SELECT statements.

     // Union: Combine two different tables with similar column.
     SELECT column_name(s) FROM table1
     UNION (UNION ALL //to allow duplicates)
     SELECT column_name(s) FROM table2;

     // INNER JOIN:
     SELECT column_name(s)
     FROM table1
     INNER JOIN table2
     ON table1.column_name = table2.column_name;

     // LEFT JOIN
     SELECT column_name(s)
     FROM table1
     LEFT JOIN table2
     ON table1.column_name = table2.column_name;

     // RIGHT JOIN
     SELECT column_name(s)
     FROM table1
     RIGHT JOIN table2
     ON table1.column_name = table2.column_name;

     // FULL OUTER JOIN
     SELECT column_name(s)
     FROM table1
     FULL OUTER JOIN table2
     ON table1.column_name = table2.column_name
     WHERE condition;
     */
}
