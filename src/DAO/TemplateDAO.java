package DAO;

import Database.JoConnect;
import Database.JoSQL;
import java.util.List;
import Tools.JoAlert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TemplateDAO {

    private final Connection c = new JoConnect().getConnectionDefault();
    private final String TableName = "tb_register";
    private JoSQL sql = new JoSQL(c, TableName);

}
