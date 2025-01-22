package com.example.to_do_list;

public class Task {
    private int id;
    private String name;
    private boolean isChecked;

    public Task(int id, String name) {
        this.id = id;
        this.name = name;
        this.isChecked = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}