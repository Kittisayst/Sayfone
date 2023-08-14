package Model;

public class SayfoneModel {

    private int id;
    private String school;
    private String english;
    private String contact;
    private String detail;

    public SayfoneModel() {
    }

    public SayfoneModel(int id, String school, String english, String contact, String detail) {
        this.id = id;
        this.school = school;
        this.english = english;
        this.contact = contact;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "SayfoneModel{" + "id=" + id + ", school=" + school + ", english=" + english + ", contact=" + contact + ", detail=" + detail + '}';
    }

}
