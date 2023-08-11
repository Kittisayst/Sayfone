package Model;

import java.sql.Date;

public class VaccineModel {

    private int VaccinID;
    private String VaccinNo;
    private String VaccinName;
    private String VaccinCategory;
    private String Location;
    private Date VaccinDate;
    private String DoctorName;

    public VaccineModel() {
    }

    public VaccineModel(int VaccinID) {
        this.VaccinID = VaccinID;
    }

    public VaccineModel(int VaccinID, String VaccinNo, String VaccinName, String VaccinCategory, String Location, Date VaccinDate, String DoctorName) {
        this.VaccinID = VaccinID;
        this.VaccinNo = VaccinNo;
        this.VaccinName = VaccinName;
        this.VaccinCategory = VaccinCategory;
        this.Location = Location;
        this.VaccinDate = VaccinDate;
        this.DoctorName = DoctorName;
    }

    public int getVaccinID() {
        return VaccinID;
    }

    public void setVaccinID(int VaccinID) {
        this.VaccinID = VaccinID;
    }

    public String getVaccinNo() {
        return VaccinNo;
    }

    public void setVaccinNo(String VaccinNo) {
        this.VaccinNo = VaccinNo;
    }

    public String getVaccinName() {
        return VaccinName;
    }

    public void setVaccinName(String VaccinName) {
        this.VaccinName = VaccinName;
    }

    public String getVaccinCategory() {
        return VaccinCategory;
    }

    public void setVaccinCategory(String VaccinCategory) {
        this.VaccinCategory = VaccinCategory;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public Date getDate() {
        return VaccinDate;
    }

    public void setData(Date VaccinDate) {
        this.VaccinDate = VaccinDate;
    }

    public String getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(String DoctorName) {
        this.DoctorName = DoctorName;
    }

}
