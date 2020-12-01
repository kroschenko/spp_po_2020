package com.company;
import java.util.ArrayList;

public class IntegerSet {
    private ArrayList<Integer> setOfIntegers;
    public IntegerSet() {
        this.setOfIntegers = new ArrayList<>();
    }
    public IntegerSet(ArrayList<Integer> setOfIntegers) {
        this.setOfIntegers = setOfIntegers;
    }
    public ArrayList<Integer> intersections(IntegerSet set) {
        ArrayList<Integer> list = set.getSetOfIntegers();
        list.retainAll(setOfIntegers);
        return list;
    }
    public boolean contains(int item) {
        return setOfIntegers.contains(item);
    }
    public int getItemById(int id) {
        return setOfIntegers.get(--id);
    }
    public void addItem(int item) {
        setOfIntegers.add(item);
    }
    public void deleteItemById(int id) {
        setOfIntegers.remove(id);
    }
    public ArrayList<Integer> getSetOfIntegers() {
        return setOfIntegers;
    }
    public void setSetOfIntegers(ArrayList<Integer> setOfIntegers) {
        this.setOfIntegers = setOfIntegers;
    }
    @Override
    public String toString() {
        return "IntegerSet = " + setOfIntegers;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerSet that = (IntegerSet) o;
        return setOfIntegers.equals(that.setOfIntegers);
    }
}