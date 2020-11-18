package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class RealNumber {
    private ArrayList<Float> floatArray;

    public RealNumber(){
        this.floatArray = new ArrayList<>();
    }
    public RealNumber(Float... args) {
        this.floatArray = new ArrayList<>(Arrays.asList(args));
    }
    public ArrayList<Float> getFloatArray() { return floatArray;
    }
    public void setFloatArray(ArrayList<Float> floatArray) { this.floatArray = floatArray;
    }
    public void addElement(Float value) {
       if (!floatArray.contains(value)) {
            floatArray.add(value);
        }
    }
    public boolean deleteElement(Float value) { return floatArray.remove(value);
    }
    public Float getElement(int index) { if(index < floatArray.size()){
        return floatArray.get(index); } else {
        return null;
    }
    }
    public boolean containsElement(Float value) { return floatArray.contains(value); }

    public RealNumber intersection(RealNumber realNumber) {
        RealNumber newRealNumber = new RealNumber();
        for (Float number : floatArray) {
            if (realNumber.containsElement(number)) {
                newRealNumber.addElement(number);
            }
        }
        return newRealNumber;
    }

    @Override
    public String toString() {
        return "RealNumber{" +
                "floatArray=" + Arrays.toString(floatArray.toArray()) +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RealNumber that = (RealNumber) o;
        return floatArray.equals(that.floatArray);
    }
}
