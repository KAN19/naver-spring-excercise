package com.ronald.naverexercise.factory.computer.product;

public class PC extends Computer{
    private static PC instance;
    private PC() {

    }
    public static PC getInstance() {
        if (instance == null) {
            instance = new PC();
        }
        return instance;
    }

    @Override
    public String getType() {
        return "PC";
    }
}
