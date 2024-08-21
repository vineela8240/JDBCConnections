package Assignment_Day18;

//Write a Java program to establish a connection to a PostgreSQL database named test_db
//using JDBC. Ensure the program prints a success message if the connection is successful and
//an error message if it fails.
//Requirements:
//        ● Use DriverManager to establish the connection.
//        ● Handle SQLException appropriately.
//● Print appropriate messages based on connection status.

import java.sql.*;

public class JDBCSimpleConnectivity {
    public static void main(String[] args) throws SQLException {
        String url="jdbc:postgresql://localhost:5432/test_db";
        String userName="postgres";
        String password="1234";

        Connection conn= DriverManager.getConnection(url,userName,password);
        String query="Select * from customer ";
        Statement st= conn.createStatement();
        ResultSet rs= st.executeQuery(query);
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
            if(con==false)
            System.out.println("Connection Not established :");

    }
}
