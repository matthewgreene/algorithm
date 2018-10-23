package com.example.demo;

public class Node {
    int value;
    boolean changed;

    public Node(int value, boolean changed) {
        this.value = value;
        this.changed = changed;
    }

    public Node(int value) {
        this(value, false);
    }

    public Node(Node node) {
        this(node.value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", changed=" + changed +
                '}';
    }
}
