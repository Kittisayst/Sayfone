package DAO;

import DAOInterface.ProvinceFn;
import Database.JoConnect;
import Model.ProvinceModel;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProvinceDAO implements ProvinceFn {

    private final Connection c = new JoConnect().getConnectionDefault();
    private final String SQL_Create = "INSERT INTO tb_user VALUES(?,?,?,?,?,?)";
    private final String SQL_Update = "UPDATE tb_user SET tid=?,username=?,password=?,userlog=?,userdate=? WHERE uid=?";
    private final String SQL_Delete = "DELETE FROM tb_nationality WHERE nationalityID=?";
    private final String SQL_GET_All = "SELECT * FROM tb_province";
    private final String SQL_GET_ById = "SELECT * FROM tb_province WHERE pid=?";

    @Override
    public int CreaterProvince(ProvinceModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int UpdateProvince(ProvinceModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int DeleteProvince(ProvinceModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProvinceModel> getAllProvince() {
        List<ProvinceModel> models = new ArrayList<>();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_All);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                ProvinceModel model = new ProvinceModel(rs.getInt(1), rs.getString(2));
                models.add(model);
            }
        } catch (Exception e) {
        }
        return models;
    }

    @Override
    public ProvinceModel getProvinceById(int ProvinceID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
