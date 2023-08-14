package Utility;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JoPrepared {

    public PreparedStatement setAutoPrepared(PreparedStatement pre, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            pre.setObject(i + 1, params[i]);
        }
        return pre;
    }
}
