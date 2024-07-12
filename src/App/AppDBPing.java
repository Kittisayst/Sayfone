package App;

import Database.JoProperties;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.*;
import java.util.concurrent.TimeUnit;

public class AppDBPing {

    private final JoProperties joProperties;
    // 5 minutes
    private String url = "";
    private String user = "";
    private String pass = "";
    private String server = "";

    public AppDBPing() {
        joProperties = new JoProperties("/JoConfig/config.properties");
        String http = joProperties.getValueAt("db.JDBCHTTP");
        String utf8 = joProperties.getValueAt("db.UTF8");
        user = joProperties.getValueAt("db.user");
        pass = joProperties.getValueAt("db.password");
        String database = joProperties.getValueAt("db.database");
        server = joProperties.getValueAt("db.Server");
        url = http + server + "/" + database + utf8;
    }

    public long measureConnectionTime() {
        long startTime = System.nanoTime();
        try (Connection connection = DriverManager.getConnection(url, user, pass)) {
            long endTime = System.nanoTime();
            return TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to database: " + e.getMessage());
        }
    }

    public long pingDatabase() throws UnknownHostException, IOException {
        InetAddress inet = InetAddress.getByName(server);
        long startTime = System.nanoTime();
        boolean reachable = inet.isReachable(5000);
        long endTime = System.nanoTime();
        if (reachable) {
            return TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        } else {
            throw new RuntimeException("Database is not reachable");
        }
    }

}
