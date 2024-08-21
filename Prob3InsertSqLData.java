package Assignment_Day18;

//Write a Java program that connects to an Oracle database named inventory_db and inserts
//a new record into a table named products. The record should include product ID, name, price,
//and quantity. Use PreparedStatement to insert the data.
//Requirements:
//        ● Use placeholders in the PreparedStatement.
//● Insert sample data into the products table.
//● Print a confirmation message after a successful insertion.

import java.awt.dnd.DragGestureEvent;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Prob3InsertSqLData {
    public static void main(String[] args) throws SQLException {
        String url="jdbc:postgresql://localhost:5432/inventory_db";
        String userName="postgres";
        String password="1234";

        Connection conn= DriverManager.getConnection(url,userName,password);
        String query="insert into product values (?,?,?,?)";
        PreparedStatement preparedStatement= conn.prepareStatement(query);
        preparedStatement.setInt(1,2);
        preparedStatement.setString(2,"Guava");
        preparedStatement.setInt(3,300);
        preparedStatement.setInt(4,5);
        int val= preparedStatement.executeUpdate();

        if(val>0){
            System.out.println("Inserted Successfully :");
        }else{
            System.err.println("Error");
        }


    }
}
