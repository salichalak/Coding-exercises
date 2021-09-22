package StackOfStrings;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class StackOfStrings {
    private ArrayList<String> data;
    private int lastElement;

    public StackOfStrings() {
        this.data = new ArrayList<>();
        this.lastElement = -1;
    }

    public void push(String item) {
        this.lastElement++;
        this.data.add(item);
    }

    public String pop() {
        hasElements();
        return this.data.remove(this.lastElement--);
    }

    public String peek() {
        hasElements();
        return this.data.get(lastElement);
    }

    private void hasElements() {
        if (this.lastElement < 0) {
            throw new NoSuchElementException();
        }
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}