package org.example;

import db.DBConnector;
import java.sql.SQLException;

/**
 *
 * @author Диана
 */
public class Main {

    public static void main(String[] args) {
        new MainWindow();
        if (DBConnector.connection() == null) {
            System.out.println("Не удалось установить соединение с БД.");
            return;
        }
        try {
            DBConnector.createDB();
            DBConnector.getAllRepublics();
            DBConnector.getAllMonarchy();
            DBConnector.getAllFederation();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}