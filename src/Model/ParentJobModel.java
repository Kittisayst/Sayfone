package Model;

public class ParentJobModel {

    private int index;
    private String name;

    public ParentJobModel(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ParentJobModel{" + "index=" + index + ", name=" + name + '}';
    }

}
