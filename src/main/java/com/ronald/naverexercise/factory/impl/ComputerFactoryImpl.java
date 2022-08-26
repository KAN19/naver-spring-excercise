package com.ronald.naverexercise.factory.impl;

import com.ronald.naverexercise.factory.ComputerFactory;
import com.ronald.naverexercise.factory.computer.product.Computer;
import com.ronald.naverexercise.factory.computer.product.PC;
import com.ronald.naverexercise.factory.computer.product.Server;
import org.springframework.stereotype.Service;

@Service
public class ComputerFactoryImpl implements ComputerFactory {
    @Override
    public Computer getComputer(String type) {
        if (type.equalsIgnoreCase("pc")) {
            return PC.getInstance();
        } else if (type.equalsIgnoreCase("server")) {
            return Server.getInstance();
        } else {
            throw new IllegalArgumentException("param khong hop le");
        }
    }
}
