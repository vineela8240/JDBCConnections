package Assignment_Day18;

import java.sql.*;
import java.util.Scanner;



public class Prob5Resultset_UpdateData {
    public static void printSqlData(Connection conn) throws SQLException {
        String query= "select * from Customers ";
        PreparedStatement preparedStatement= conn.prepareStatement(query);
        ResultSet res= preparedStatement.executeQuery();
        while(res.next()){
            System.out.println(res.getInt("customer_id"));
            System.out.println(res.getString("name"));
            System.out.println(res.getString("email"));
            System.out.println("==========================================================");
        }
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String URL="jdbc:postgresql://localhost:5432/WorkshopProb";
        String USERNAME= "postgres";
        String PASSWORD= "1234";
        Connection conn= DriverManager.getConnection(URL, USERNAME,PASSWORD);
        printSqlData(conn);
        String query ="Update Customers set name=? where customer_id= ?";
        Scanner sc= new Scanner(System.in);
        PreparedStatement update= conn.prepareStatement(query);
        System.out.println("Enter Unique customer Id :");
        int candidate= sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Name :");
        String name= sc.nextLine();

        update.setInt(2,candidate);
        update.setString(1,name);

        int value= update.executeUpdate();
        if(value>0){
            System.out.println("Updated Successfully ");
        }else{
            System.out.println("Error");
        }
        System.out.println();
        printSqlData(conn);
    }
}
