package Utility;

public class JoIndex {

    private int next;

    public JoIndex(int next) {
        this.next = next;
    }

    public int next() {
        return next++;
    }

    public void setNext(int next) {
        this.next = next;
    }

}
