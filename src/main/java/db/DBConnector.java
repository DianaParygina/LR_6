package db;

import org.example.Federation;
import org.example.Republic;
import org.example.Monarchy;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnector {
    public static final String PATH_TO_DB_FILE = "databasestates.db";
    public static final String URL = "jdbc:sqlite:" + PATH_TO_DB_FILE;
    public static Connection conn;

    public static Connection connection() {
        try {
            conn = DriverManager.getConnection(URL);
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("Драйвер: " + meta.getDriverName());
            }
        } catch (SQLException ex) {
            System.out.println("Ошибка подключения к БД: " + ex);
        }
        return conn;
    }


    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Closing connection error: " + e.getMessage());
            }
        }
    }

    public static void createDB() throws SQLException {
        Statement statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists 'republic' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'satisfaction_of_citizens' text, 'parliament' text );");
        System.out.println("Таблица создана или уже существует.");
        statmt.execute("CREATE TABLE if not exists 'monarchy' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text,'name_of_ruler' text, 'age_of_government' integer);"); // FOREIGN KEY (group_id) REFERENCES groups (id));
        System.out.println("Таблица создана или уже существует.");
        statmt.execute("CREATE TABLE if not exists 'federation' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text,'name_of_capital' text, 'number_of_states' integer);"); // FOREIGN KEY (group_id) REFERENCES groups (id));
        System.out.println("Таблица создана или уже существует.");
//        statmt.execute("CREATE TABLE if not exists 'government_counts' ('table_name' TEXT PRIMARY KEY, 'count' INTEGER);");
//
//        statmt.execute("INSERT INTO 'government_counts' ('table_name', 'count') SELECT 'republic', COUNT(*) FROM republic ON CONFLICT(table_name) or UPDATE SET count = excluded.count;");
//
//        statmt.execute("INSERT INTO 'government_counts' ('table_name', 'count') SELECT 'monarchy', COUNT(*) FROM monarchy ON CONFLICT(table_name) or UPDATE SET count = excluded.count;");
//
//        statmt.execute("INSERT INTO 'government_counts' ('table_name', 'count') SELECT 'federation', COUNT(*) FROM federation ON CONFLICT(table_name)or UPDATE SET count = excluded.count;");

    }

    public static List<Republic> getAllRepublics() throws SQLException {
        Statement statement = conn.createStatement();
        List<Republic> list = new ArrayList<Republic>();
        ResultSet resultSet = statement.executeQuery("SELECT id, name, satisfaction_of_citizens, parliament FROM republic");
        while (resultSet.next()) {
            list.add(new Republic(resultSet.getInt("id"),resultSet.getString("name"), resultSet.getString("satisfaction_of_citizens"), resultSet.getString("parliament")));
        }
        resultSet.close();
        statement.close();
        return list;
    }

    public static List<Monarchy> getAllMonarchy() throws SQLException {
        Statement statement = conn.createStatement();
        List<Monarchy> list = new ArrayList<Monarchy>();
        ResultSet resultSet = statement.executeQuery("SELECT id, name, name_of_ruler, age_of_government FROM monarchy");
        while (resultSet.next()) {
            list.add(new Monarchy(resultSet.getInt("id"),resultSet.getString("name"), resultSet.getString("name_of_ruler"), resultSet.getString("age_of_government")));
        }
        resultSet.close();
        statement.close();
        return list;
    }

    public static List<Federation> getAllFederation() throws SQLException {
        Statement statement = conn.createStatement();
        List<Federation> list = new ArrayList<Federation>();
        ResultSet resultSet = statement.executeQuery("SELECT id, name, name_of_capital, number_of_states FROM federation");
        while (resultSet.next()) {
            list.add(new Federation(resultSet.getInt("id"),resultSet.getString("name"), resultSet.getString("name_of_capital"), resultSet.getString("number_of_states")));
        }
        resultSet.close();
        statement.close();
        return list;
    }

    public static String searchStateByIdRepublic(int id, String type) {
        String sqlrepublic = "SELECT name, satisfaction_of_citizens, parliament FROM republic WHERE id = ?";
        try (PreparedStatement pstmt = connection().prepareStatement(sqlrepublic)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("name");
                    String satisfactionOfCitizens = rs.getString("satisfaction_of_citizens");
                    String parliament = rs.getString("parliament");
                    return String.format("Имя: %s.\nУдовлетворение граждан: %s.\nПарламент: %s.\n",
                            name, satisfactionOfCitizens, parliament);
                } else {
                    return "Государство с таким ID не найдено.";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Ошибка при выполнении запроса к базе данных.";
        }
    }

        public static String searchStateByIdMonarchy(int id, String type){
            String sqlmonarchy = "SELECT name, name_of_ruler, age_of_government FROM monarchy WHERE id = ?";
            try (PreparedStatement pstmt = connection().prepareStatement(sqlmonarchy)) {
                pstmt.setInt(1, id);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        String name = rs.getString("name");
                        String name_of_ruler = rs.getString("name_of_ruler");
                        String age_of_government = rs.getString("age_of_government");
                        return String.format("Имя: %s.\nИмя правителя: %s.\nВек правления: %s.\n",
                                name, name_of_ruler, age_of_government);
                    } else {
                        return "Государство с таким ID не найдено.";
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return "Ошибка при выполнении запроса к базе данных.";
            }
        }

    public static String searchStateByIdFederation(int id, String type){
        String sqlfederation = "SELECT name, name_of_capital, number_of_states FROM federation WHERE id = ?";
        try (PreparedStatement pstmt = connection().prepareStatement(sqlfederation)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("name");
                    String name_of_capital = rs.getString("name_of_capital");
                    String number_of_states = rs.getString("number_of_states");
                    return String.format("Имя: %s.\nНазвание столицы: %s.\nКол-во штатов: %s.\n",
                            name, name_of_capital, number_of_states);
                } else {
                    return "Государство с таким ID не найдено.";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Ошибка при выполнении запроса к базе данных.";
        }
    }


    public static String deleteRepublic(int id, String type) throws SQLException {
        String result = null;
        String sqlRepublic = "DELETE FROM republic WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sqlRepublic)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                return "Удалено!";
            } else {
                return "Государство с таким ID не найдено.";
            }
        }  catch (SQLException e) {
            result = "Error deleting republic: " + e.getMessage();
            e.printStackTrace();
        }
        return result;
    }

    public static String deleteMonarchy(int id, String type) throws SQLException {
        String result = null;
        String sqlMonarchy = "DELETE FROM monarchy WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sqlMonarchy)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                return "Удалено!";
            } else {
                return "Государство с таким ID не найдено.";
            }
        }  catch (SQLException e) {
            result = "Error deleting republic: " + e.getMessage();
            e.printStackTrace();
        }
        return result;
    }

    public static String deleteFederation(int id, String type) throws SQLException {
        String result = null;
        String sqlFederation = "DELETE FROM federation WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sqlFederation)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                return "Удалено!";
            } else {
                return "No records to delete.";
            }
        }  catch (SQLException e) {
            result = "Error deleting republic: " + e.getMessage();
            e.printStackTrace();
        }
        return result;
    }

}