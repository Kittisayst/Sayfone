package DAO;

import DAOInterface.StudentFn;
import DAOSevervice.FinancialService;
import Database.JoConnect;
import Database.JoSQL;
import Log.JoLoger;
import Model.GlobalDataModel;
import Model.StudentCountModel;
import Model.StudentDashboradModel;
import Model.StudentModel;
import java.util.List;
import Tools.JoAlert;
import Utility.JoBlobConvert;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO implements StudentFn {

    private final String TableName = "tb_student";
    private final String SQL_Update = "UPDATE " + TableName + " SET StudentNo=?,Gender=?,StudentName=?,StudentENG=?,NickName=?,"
            + "DateofBirth=?,DateStart=?,DateStop=?,Preschool=?,Health=?,Talent=?,VaccinState=?,Disabled=?,Sibling=?,"
            + "GoHome=?,Status=?,nationalityID=?,ethnicID=?,religionID=? WHERE StudentID=?";
    private final String SQL_GET_LASTID = "SELECT MAX(StudentID) AS ID FROM " + TableName;
    private final String SQL_UpdateImage = "UPDATE " + TableName + " SET Image=? WHERE StudentID=?";
    private final String SQL_GetNewStudent = "SELECT * FROM tb_student WHERE tb_student.StudentID NOT IN (SELECT tb_registerdetail.StudentID FROM tb_registerdetail)";
    private int totalPages = 0;

    @Override
    public int CreaterStudent(StudentModel model) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getCreate();
            int i = 1;
            pre.setString(i++, null);
            pre.setString(i++, model.getStudentNo());
            pre.setInt(i++, model.getGender());
            pre.setString(i++, model.getStudentName());
            pre.setString(i++, model.getStudentENG());
            pre.setString(i++, model.getNickName());
            pre.setDate(i++, model.getDateofBirth());
            pre.setDate(i++, model.getDateStart());
            pre.setDate(i++, model.getDateStop());
            pre.setString(i++, model.getPreschool());
            pre.setInt(i++, model.getHealth());
            pre.setString(i++, model.getTalent());
            pre.setInt(i++, model.getVaccinState());
            pre.setString(i++, model.getDisabled());
            pre.setInt(i++, model.getSibling());
            if (model.getLocationFile() == null) {
                pre.setString(i++, null);
            } else {
                InputStream in = new JoBlobConvert(model.getLocationFile()).getFileInput();
                pre.setBinaryStream(i++, in, in.available());
            }
            pre.setInt(i++, model.getGoHome());
            pre.setInt(i++, model.getStatus());
            pre.setInt(i++, model.getNationalityID());
            pre.setInt(i++, model.getEthnicID());
            pre.setInt(i++, model.getReligionID());
            pre.setInt(i++, GlobalDataModel.userModel.getUserID());
            System.out.println(pre);
            return pre.executeUpdate();
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return 0;
        } finally {
            connect.close();
        }
    }

    @Override
    public int UpdateStudent(StudentModel model) {
        JoConnect connect = new JoConnect();
        try {
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(SQL_Update);
            int i = 1;
            pre.setString(i++, model.getStudentNo());
            pre.setInt(i++, model.getGender());
            pre.setString(i++, model.getStudentName());
            pre.setString(i++, model.getStudentENG());
            pre.setString(i++, model.getNickName());
            pre.setDate(i++, model.getDateofBirth());
            pre.setDate(i++, model.getDateStart());
            pre.setDate(i++, model.getDateStop());
            pre.setString(i++, model.getPreschool());
            pre.setInt(i++, model.getHealth());
            pre.setString(i++, model.getTalent());
            pre.setInt(i++, model.getVaccinState());
            pre.setString(i++, model.getDisabled());
            pre.setInt(i++, model.getSibling());
            if (model.getLocationFile() != null) {
                UpdateImage(model);
            }
            pre.setInt(i++, model.getGoHome());
            pre.setInt(i++, model.getStatus());
            pre.setInt(i++, model.getNationalityID());
            pre.setInt(i++, model.getEthnicID());
            pre.setInt(i++, model.getReligionID());
            pre.setInt(i++, model.getStudentID());
            System.out.println(pre);
            return pre.executeUpdate();
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return 0;
        } finally {
            connect.close();
        }
    }

    public int UpdateStudentNo(int StudentID, String StudentNo) {
        JoConnect connect = new JoConnect();
        try {
            String sql = "UPDATE tb_student SET StudentNo = ? WHERE StudentID = ?";
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
            pre.setString(1, StudentNo);
            pre.setInt(2, StudentID);
            return pre.executeUpdate();
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return 0;
        } finally {
            connect.close();
        }
    }

    @Override
    public int DeleteStudent(StudentModel model) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        FinancialService service = new FinancialService();
        if (service.getStudentIsReister(model.getStudentID())) {
            JoAlert alert = new JoAlert();
            alert.messages("ລົບຂໍ້ມູນ", "ນັກສຶກສານິ້ຍັງໄດ້ນຳໃຊ້ຂໍ້ມູນການຈ່າຍຄ່າຮຽນ", JoAlert.Icons.warning);
            System.out.println("0");
            return 0;
        } else {
            try {
                PreparedStatement pre = sql.getDelete();
                pre.setInt(1, model.getStudentID());
                return pre.executeUpdate();
            } catch (SQLException e) {
                JoAlert.Error(e, this);
                JoLoger.saveLog(e, this);
                return 0;
            } finally {
                connect.close();
            }
        }

    }

    @Override
    public List<StudentModel> getAllStudent() {
        List<StudentModel> models = new ArrayList<>();
        models.clear();
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            try (ResultSet rs = sql.getSelectAll()) {
                while (rs.next()) {
                    models.add(getResult(rs));
                }
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } catch (Exception ex) {
            JoAlert.Error(ex, this);
            JoLoger.saveLog(ex, this);
        } finally {
            connect.close();
        }
        return models;
    }

    @Override
    public List<StudentModel> getAllStudent(int max) {
        List<StudentModel> models = new ArrayList<>();
        models.clear();
        JoConnect connect = new JoConnect();
        String sql = "SELECT * FROM tb_student ORDER BY StudentID DESC LIMIT ?";
        try {
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
            pre.setInt(1, max);
            try (ResultSet rs = pre.executeQuery()) {
                while (rs.next()) {
                    models.add(getResult(rs));
                }
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } catch (Exception ex) {
            JoAlert.Error(ex, this);
            JoLoger.saveLog(ex, this);
        } finally {
            connect.close();
        }
        return models;
    }

    @Override
    public StudentModel getStudentById(int StudentID) {
        StudentModel model = new StudentModel();
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            ResultSet rs = sql.getSelectById(StudentID);
            if (rs.next()) {
                model = getResult(rs);
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return model;
    }

    @Override
    public int getSudentLastID() {
        int LastID = 0;
        JoConnect connect = new JoConnect();
        try {
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(SQL_GET_LASTID);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                LastID = rs.getInt(1);
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return LastID;
    }

    private void UpdateImage(StudentModel model) {
        JoConnect connect = new JoConnect();
        try {
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(SQL_UpdateImage);
            InputStream in = new JoBlobConvert(model.getLocationFile()).getFileInput();
            pre.setBinaryStream(1, in, in.available());
            pre.setInt(2, model.getStudentID());
            pre.executeUpdate();
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
    }

    @Override
    public int getStudentCount() {
        int Count = 0;
        JoConnect connect = new JoConnect();
        String sql = "SELECT COUNT(StudentID) AS scount FROM tb_student WHERE Status=0";
        try {
            ResultSet rs = connect.getConnectionDefault().createStatement().executeQuery(sql);
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }

        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return Count;
    }

    @Override
    public int getCountClass(int ClassID) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        return sql.getCount();
    }

    @Override
    public List<StudentModel> getNewStudent() {
        List<StudentModel> models = new ArrayList<>();
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            ResultSet rs = connect.getConnectionDefault().createStatement().executeQuery(SQL_GetNewStudent);
            while (rs.next()) {
                models.add(getResult(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        } finally {
            connect.close();
        }
        return models;
    }

    @Override
    public List<StudentModel> getSutdentNotRegister(int YearID, int page, int rowsPerPage) {
        List<StudentModel> models = new ArrayList<>();
        JoConnect connect = new JoConnect();
        int offset = (page - 1) * rowsPerPage;
        try {
            String sql = "SELECT s.*\n"
                    + "FROM tb_student s\n"
                    + "LEFT JOIN tb_financial f ON s.StudentID = f.StudentID\n"
                    + "LEFT JOIN tb_register rs ON f.RegisterID = rs.registerID AND rs.yearID=?\n"
                    + "WHERE f.StudentID IS NULL ORDER BY StudentID DESC LIMIT ? OFFSET ?";
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
            pre.setInt(1, YearID);
            pre.setInt(2, rowsPerPage);
            pre.setInt(3, offset);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(getResult(rs));
            }
            calculateTotalNotRegisterPages(YearID, rowsPerPage);
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return models;
    }

    @Override
    public String getAutoStudentID() {
        try {
            StudentModel model = getStudentById(getSudentLastID());
            int num = Integer.parseInt(model.getStudentNo());
            num += 1;
            String formatted = String.format("%05d", num);
            return formatted;
        } catch (NumberFormatException e) {
            JoLoger.saveLog(e, this);
            JoAlert.Error(e, this);
            return "0000";
        }
    }

    @Override
    public boolean getChekStudentNo(String studentNo) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            ResultSet rs = sql.getSelectByIndex(2, studentNo);
            String checkNo = "";
            if (rs.next()) {
                checkNo = rs.getString(2);
            }
            return checkNo.equals(studentNo);
        } catch (SQLException e) {
            JoLoger.saveLog(e, this);
            JoAlert.Error(e, this);
            return false;
        } finally {
            connect.close();
        }
    }

    @Override
    public List<StudentModel> getStudentBrotherSister(int StudentID) {
        List<StudentModel> models = new ArrayList<>();
        JoConnect connect = new JoConnect();
        try {
            String sql = "SELECT * FROM tb_student\n"
                    + "WHERE StudentID NOT IN (SELECT tb_brotherssisters.StudentBSID FROM tb_brotherssisters WHERE tb_brotherssisters.StudentID=?)\n"
                    + "AND StudentID NOT IN (?)";
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
            pre.setInt(1, StudentID);
            pre.setInt(2, StudentID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(getResult(rs));
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return models;
    }

    @Override
    public List<StudentModel> getStudentPagination(int page, int rowsPerPage) {
        JoConnect connect = new JoConnect();
        List<StudentModel> models = new ArrayList<>();
        int offset = (page - 1) * rowsPerPage;
        try {
            String sqlc = "SELECT * FROM tb_student ORDER BY StudentID DESC LIMIT ? OFFSET ?";
            try (PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sqlc)) {
                pre.setInt(1, rowsPerPage);
                pre.setInt(2, offset);
                try (ResultSet rs = pre.executeQuery()) {
                    while (rs.next()) {
                        models.add(getResult(rs));
                    }
                    calculateTotalPages(rowsPerPage);
                }
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return models;
    }

    @Override
    public List<StudentModel> getSearchStudent(String search) {
        JoConnect connect = new JoConnect();
        List<StudentModel> models = new ArrayList<>();
        try {
            String sqlc = "SELECT * FROM tb_student as s \n"
                    + "LEFT JOIN tb_studenthistory sy ON s.StudentID = sy.StudentID\n"
                    + "  WHERE s.StudentNo LIKE ? OR s.StudentName LIKE ? OR sy.FatherTel LIKE ? OR sy.MotherTel LIKE ? ORDER BY s.StudentID DESC";
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sqlc);
            pre.setString(1, search + "%");
            pre.setString(2, "%" + search + "%");
            pre.setString(3, "%" + search + "%");
            pre.setString(4, "%" + search + "%");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(getResult(rs));
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return models;
    }

    public List<StudentDashboradModel> getSearchStudentDashboard(String text) {
        List<StudentDashboradModel> models = new ArrayList<>();
        JoConnect connect = new JoConnect();
        try {
            String sql = "SELECT \n"
                    + "s.StudentID, \n"
                    + "s.StudentNo, \n"
                    + "s.Gender, \n"
                    + "s.StudentName,\n"
                    + "s.Status,\n"
                    + "COALESCE(MAX(f.FinancialID), 0) AS maxFinancial\n"
                    + "FROM tb_student s\n"
                    + "LEFT JOIN tb_financial f ON s.StudentID = f.StudentID\n";
            if (isPhoneNumber(text)) {
                sql += " LEFT JOIN tb_studenthistory sy ON s.StudentID = sy.StudentID\n";
                sql += "WHERE sy.FatherTel LIKE ? OR sy.MotherTel LIKE ? GROUP BY s.StudentID, s.StudentNo, s.Gender, s.StudentName, s.Status";
            } else if (isNumeric(text)) {
                sql += "WHERE s.StudentNo LIKE ? GROUP BY s.StudentID, s.StudentNo, s.Gender, s.StudentName, s.Status";
            } else {
                sql += "WHERE s.StudentName LIKE ? GROUP BY s.StudentID, s.StudentNo, s.Gender, s.StudentName, s.Status";
            }
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
            pre.setString(1, "%" + text + "%");
            if (isPhoneNumber(text)) { //ຄົນຫາຕາມເບີໂທ
                 pre.setString(2, "%" + text + "%");
            }
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(new StudentDashboradModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(4),
                        rs.getInt(3),
                        rs.getInt(6),
                        rs.getInt(5)));
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return models;
    }

    private boolean isNumeric(String str) {
        return str != null && str.matches("\\d+"); // Checks if the string contains only digits
    }

    private boolean isPhoneNumber(String text) {
        return text != null && text.matches("\\d{8}"); // Checks if the string contains only digits
    }

    @Override
    public List<StudentModel> getSearchSutdentNotRegister(int YearID, String search) {
        JoConnect connect = new JoConnect();
        List<StudentModel> models = new ArrayList<>();
        try {
            String sql = "SELECT s.*\n"
                    + "FROM tb_student s\n"
                    + "LEFT JOIN tb_financial f ON s.StudentID = f.StudentID\n"
                    + "LEFT JOIN tb_register rs ON f.RegisterID = rs.registerID AND rs.yearID=?\n"
                    + "WHERE f.StudentID IS NULL AND StudentNo LIKE ? OR StudentName LIKE ?";
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
            pre.setInt(1, YearID);
            pre.setString(2, search + "%");
            pre.setString(3, "%" + search + "%");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(getResult(rs));
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return models;
    }

    private void calculateTotalPages(int rowsPerPage) throws SQLException {
        JoConnect connect = new JoConnect();
        String sql = "SELECT COUNT(*) FROM tb_student";
        try (Statement statement = connect.getConnectionDefault().createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            if (resultSet.next()) {
                int rowCount = resultSet.getInt(1);
                totalPages = (int) Math.ceil((double) rowCount / rowsPerPage);
            }
        } finally {
            connect.close();
        }
    }

    private void calculateTotalNotRegisterPages(int YearID, int rowsPerPage) throws SQLException {
        JoConnect connect = new JoConnect();
        String sql = "SELECT COUNT(*)\n"
                + "FROM tb_student s\n"
                + "LEFT JOIN tb_financial f ON s.StudentID = f.StudentID\n"
                + "LEFT JOIN tb_register rs ON f.RegisterID = rs.registerID AND rs.yearID=?\n"
                + "WHERE f.StudentID IS NULL";
        PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
        pre.setInt(1, YearID);
        ResultSet rs = pre.executeQuery();
        if (rs.next()) {
            int rowCount = rs.getInt(1);
            totalPages = (int) Math.ceil((double) rowCount / rowsPerPage);
        }
        connect.close();
    }

    public int getTotalPages() {
        return totalPages;
    }

    private StudentModel getResult(ResultSet rs) throws SQLException {
        int i = 1;
        StudentModel model = new StudentModel();
        model.setStudentID(rs.getInt(i++));
        model.setStudentNo(rs.getString(i++));
        model.setGender(rs.getInt(i++));
        model.setStudentName(rs.getString(i++));
        model.setStudentENG(rs.getString(i++));
        model.setNickName(rs.getString(i++));
        model.setDateofBirth(rs.getDate(i++));
        model.setDateStart(rs.getDate(i++));
        model.setDateStop(rs.getDate(i++));
        model.setPreschool(rs.getString(i++));
        model.setHealth(rs.getInt(i++));
        model.setTalent(rs.getString(i++));
        model.setVaccinState(rs.getInt(i++));
        model.setDisabled(rs.getString(i++));
        model.setSibling(rs.getInt(i++));
        model.setImage(rs.getBlob(i++));
        model.setGoHome(rs.getInt(i++));
        model.setStatus(rs.getInt(i++));
        model.setNationalityID(rs.getInt(i++));
        model.setEthnicID(rs.getInt(i++));
        model.setReligionID(rs.getInt(i++));
        model.setUserCreate(rs.getInt(i++));
        return model;
    }

    @Override
    public List<StudentModel> getStudentByState(int State) {
        List<StudentModel> list = new ArrayList<>();
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getSelectCustom("Status=?");
            pre.setInt(1, State);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                list.add(getResult(rs));
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return list;
    }

    public List<StudentCountModel> getStudentCounts(int YearID) {
        JoConnect connect = new JoConnect();
        List<StudentCountModel> models = new ArrayList<>();
        try {
            String sql = "SELECT \n"
                    + "    r.ClassRoomName,\n"
                    + "    y.Year,\n"
                    + "    COUNT(DISTINCT s.StudentID) AS StudentCount , r.classID\n"
                    + "FROM \n"
                    + "    tb_student s\n"
                    + "JOIN \n"
                    + "    tb_financial f ON s.StudentID = f.StudentID\n"
                    + "JOIN \n"
                    + "    tb_register r ON f.RegisterID = r.registerID\n"
                    + "JOIN \n"
                    + "    tb_year y ON r.yearID = y.yearID\n"
                    + "WHERE \n"
                    + "    y.yearID=? AND s.Status=0\n"
                    + "GROUP BY \n"
                    + "    r.ClassRoomName, y.Year ORDER BY r.classID ASC";
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
            pre.setInt(1, YearID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(new StudentCountModel(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return models;
    }

}
