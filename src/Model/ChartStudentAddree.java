package Model;

public class ChartStudentAddree {

    private String name;
    private int Count;

    public ChartStudentAddree(String name, int Count) {
        this.name = name;
        this.Count = Count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    @Override
    public String toString() {
        return "ChartStudentAddree{" + "name=" + name + ", Count=" + Count + '}';
    }

}
