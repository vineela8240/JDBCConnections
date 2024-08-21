package Assignment_Day18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Description:
//Develop a Java program that connects to a PostgreSQL database named bank_db. Implement
//a transaction where you transfer money from one account to another within the same table
//named accounts. Ensure that if any step of the transaction fails, the entire transaction is rolled
//back.
//        Requirements:
//        ● Use Connection.setAutoCommit(false) to manage transactions.
//        ● Handle SQLException to roll back transactions if needed.
//● Ensure that the balance is updated correctly or the transaction is rolled back in case of
//an error.
public class Prob4HandleTransaction {
    public static void main(String[] args) {
        String dbUrl = "jdbc:postgresql://localhost:5432/bank_db";
        String username = "postgres";
        String password = "1234";

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(dbUrl, username, password);
            connection.setAutoCommit(false);

            int senderAccountId = 1001;
            int receiverAccountId = 1002;
            double transferAmount = 500.0;

            String debitQuery = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";
            PreparedStatement debitStatement = connection.prepareStatement(debitQuery);
            debitStatement.setDouble(1, transferAmount);
            debitStatement.setInt(2, senderAccountId);
            debitStatement.executeUpdate();

            String creditQuery = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";
            PreparedStatement creditStatement = connection.prepareStatement(creditQuery);
            creditStatement.setDouble(1, transferAmount);
            creditStatement.setInt(2, receiverAccountId);
            creditStatement.executeUpdate();

            connection.commit();
            System.out.println("Money transfer successful!");

            debitStatement.close();
            creditStatement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            System.err.println("Error: PostgreSQL JDBC driver not found.");
        } catch (SQLException e) {
            System.err.println("Error during transaction: " + e.getMessage());

        }
    }
}