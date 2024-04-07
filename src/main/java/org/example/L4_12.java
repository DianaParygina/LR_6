package org.example;

import javax.swing.*;
import java.sql.*;

import static db.DBConnector.conn;

public class L4_12 {


    public void addState(String name, String satisfaction_of_citizens, String parliament) {
        String SQL = "INSERT INTO republic(name, satisfaction_of_citizens, parliament) VALUES(?,?,?)";

        try (PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, name);
            pstmt.setString(2, satisfaction_of_citizens);
            pstmt.setString(3, parliament);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1);
                        // Пример использования сгенерированного id
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Государство успешно добавлено.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addMonarchy(String name, String name_of_ruler, String age_of_government) {
        String SQL = "INSERT INTO monarchy(name, name_of_ruler, age_of_government) VALUES(?,?,?)";

        try (PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS))  {
            pstmt.setString(1, name);
            pstmt.setString(2, name_of_ruler);
            pstmt.setString(3, age_of_government);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1);
                        // Пример использования сгенерированного id
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Государство успешно добавлено.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addFederation(String name, String name_of_capital, String number_of_states) {
        String SQL = "INSERT INTO federation(name, name_of_capital, number_of_states) VALUES(?,?,?)";

        try (PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS))  {

            pstmt.setString(1, name);
            pstmt.setString(2, name_of_capital);
            pstmt.setString(3, number_of_states);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1);
                        // Пример использования сгенерированного id
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Государство успешно добавлено.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


}

