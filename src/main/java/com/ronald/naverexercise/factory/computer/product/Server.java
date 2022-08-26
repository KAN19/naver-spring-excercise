package com.ronald.naverexercise.factory.computer.product;

public class Server extends Computer{

    private static Server instance;
    private Server() {

    }
    public static Server getInstance() {
        if (instance == null) {
            instance = new Server();
        }
        return instance;
    }

    @Override
    public String getType() {
        return "Server";
    }
}
