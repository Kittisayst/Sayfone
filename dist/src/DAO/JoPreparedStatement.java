package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JoPreparedStatement {

    private PreparedStatement getPrepareStatement(PreparedStatement pre, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            pre.setObject(i + 1, params[i]);
        }
        return pre;
    }
}
