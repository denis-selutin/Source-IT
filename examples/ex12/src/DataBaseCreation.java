//шаг 1. импортируем библиотеки
import java.sql.*;
import java.util.Random;

/**
 * Created by denis.selutin on 6/23/2015.
 */
public class DataBaseCreation {
    // JDBC драйвер и адрес сервера БД
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/";

    static final String DB_NAME = "new_base";
    static final String TABLE_NAME = "MyTable1";
    static final String CREATE_DB = "create database " + DB_NAME;
    static final String CREATE_TABLE = "create table " + TABLE_NAME + "(id integer not null, name text, \"some field\" text, CONSTRAINT \"id\" PRIMARY KEY (id) )";
    static final String INSERT_TO_TABLE = "insert into " + TABLE_NAME + " values (?, ?, ?)";
    static final String SELECT_ALL = "select * from " + TABLE_NAME;

    // логин и пороль для доступа к БД
    static final String USER = "postgres";
    static final String PASS = "1";

    public static void createDb(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.execute(CREATE_DB);
        stmt.close();
    }

    public static void createTable(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.execute(CREATE_TABLE);
        stmt.close();
    }

    public static void fillTable(Connection conn) throws SQLException {
        PreparedStatement  stmt = conn.prepareStatement(INSERT_TO_TABLE);
        for(int i = 0; i < 100; i++) {
            stmt.setInt(1, i);
            stmt.setString(2, generateString());
            stmt.setString(3, generateString());
            stmt.addBatch();
        }
        stmt.executeBatch();
    }

    public static void selectAll(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(SELECT_ALL);
        while (rs.next()) {
            int id = rs.getInt("id");
            String first = rs.getString("name");
            String last = rs.getString("some field");

            System.out.print("ID: " + id);
            System.out.print(", Name: " + first);
            System.out.println(", Some field: " + last);
        }
        rs.close();
        stmt.close();
    }

    private static final String generateString() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < random.nextInt(50) + 5; i++) {
            sb.append((char) (random.nextInt('z' - 'a') + 'a'));
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            createDb(conn);

            conn.close();
            conn = DriverManager.getConnection(DB_URL + DB_NAME, USER, PASS);

            createTable(conn);
            fillTable(conn);
            selectAll(conn);

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
