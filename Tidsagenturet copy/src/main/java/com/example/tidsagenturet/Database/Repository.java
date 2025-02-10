package com.example.tidsagenturet.Database;

import com.example.tidsagenturet.Controllers.TimeTravelController;
import com.example.tidsagenturet.Extra_Classes.Customer;
import com.example.tidsagenturet.Extra_Classes.TimeMachine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {

    public static void createCustomer(Customer customer) {
        String sql = "INSERT into customers (name, email) values (?, ?)";


        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getEmail());
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Customer has been created");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement Statement = connection.createStatement();
             ResultSet resultSet = Statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Customer customer = new Customer(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email"));
                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }


    public static void updateCustomer(Customer customer) {
        String sql = "UPDATE customers SET name = ?, email = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getEmail());
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Customer has been updated");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void deleteCustomer(int id) {
        String sql = "DELETE FROM customers where id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Customer has been deleted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void TimeMachine(TimeMachine timeMachine) {
        String sql = "INSERT INTO time_machines (name, capacity, status) values (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, timeMachine.getName());
            preparedStatement.setInt(2, timeMachine.getCapacity());
            preparedStatement.setString(3, timeMachine.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<TimeMachine> readAllTimeMachines() {
        List<TimeMachine> timeMachines = new ArrayList<>();
        String sql = "SELECT * FROM time_machines";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                TimeMachine timeMachine = new TimeMachine(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("capacity"), resultSet.getString("status"));
                timeMachines.add(timeMachine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return timeMachines;
    }

    public static void updateTimeMachine(TimeMachine timeMachine) {
        String sql = "UPDATE time_machines SET name = ?, capacity = ?, status = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, timeMachine.getName());
            preparedStatement.setInt(2, timeMachine.getCapacity());
            preparedStatement.setString(3, timeMachine.getStatus());
            preparedStatement.setInt(4, timeMachine.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteTimeMachine(int id){
        String sql = "DELETE FROM time_machines WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }








































}











