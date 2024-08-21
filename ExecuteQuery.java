package Assignment_Day18;

//Problem Statement 2: Execute a Simple Query
//Description:
//Create a Java program that connects to a MySQL database named test_db and executes
//a simple SELECT query to retrieve all records from a table named employees. Print the details
//of each record retrieved.
//Requirements:
//        ● Use PreparedStatement to execute the query.
//        ● Handle potential SQLException.
//● Print the results in a readable format.

import java.sql.*;

public class ExecuteQuery {
    public static void main(String[] args) throws SQLException {
        String url="jdbc:postgresql://localhost:5432/test_db";
        String userName="postgres";
        String password="1234";

        Connection conn= DriverManager.getConnection(url,userName,password);
        String query="Select * from customer ";
        PreparedStatement statement=conn.prepareStatement(query);

        ResultSet rs= statement.executeQuery();
        boolean con=false;
        while(rs.next()){
            if(!con){
                System.out.println("Established Connection");
                con=true;
            }
            System.out.println(rs.getString("name"));
            System.out.println(rs.getInt("customer_id"));
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        }
        rs.close();
        conn.close();
        statement.close();
        if(con==false)
            System.out.println("Connection Not established :");
    }
}
