package com.ronald.naverexercise.factory;

import com.ronald.naverexercise.factory.computer.product.Computer;

public interface ComputerFactory {

    Computer getComputer(String type);

}
