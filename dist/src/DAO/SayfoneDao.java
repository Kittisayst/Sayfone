package DAO;

import DAOInterface.SayFoneFn;
import Database.JoConnect;
import Database.JoSQL;
import Model.SayfoneModel;
import java.util.List;
import Tools.JoAlert;
import Utility.JoPrepared;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SayfoneDao implements SayFoneFn {

    private final Connection c = new JoConnect().getConnectionDefault();
    private final String TableName = "tb_sayfone";
    private JoSQL sql = new JoSQL(c, TableName);

    @Override
    public int Creater(SayfoneModel model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int Update(SayfoneModel model) {
        try {
            PreparedStatement pre = new JoPrepared().setAutoPrepared(sql.getUpdate(),
                    model.getSchool(),
                    model.getEnglish(),
                    model.getContact(),
                    model.getDetail(),
                    model.getId());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public int Delete(SayfoneModel model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SayfoneModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SayfoneModel getById(int ID) {
        SayfoneModel model = new SayfoneModel();
        try {
            ResultSet rs = sql.getSelectById(ID);
            if (rs.next()) {
                model = getResult(rs);
            }
            return model;
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return model;
        }
    }

    private SayfoneModel getResult(ResultSet rs) throws Exception {
        return new SayfoneModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
    }

}
