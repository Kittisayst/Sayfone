/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class ClassCountModel {

    private String name;
    private int Count;

    public ClassCountModel(String name, int Count) {
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
        return "ClassCountModel{" + "name=" + name + ", Count=" + Count + '}';
    }

}
