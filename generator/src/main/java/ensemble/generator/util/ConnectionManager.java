package ensemble.generator.util;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author chenzejin
 * @date 2019/11/26
 */
public class ConnectionManager {

    private static final String DB_URL = "jdbc:sqlite:./config/sqlite3.db";

    public static Connection getConnection() throws Exception {
        Class.forName("org.sqlite.JDBC");
        File file = new File(DB_URL.substring("jdbc:sqlite:".length())).getAbsoluteFile();
        Connection conn = DriverManager.getConnection(DB_URL);
        return conn;
    }

}
