package com.ua.eNums;

/**
 * Created by AlxEx on 28.10.2015.
 */
public enum Engine {
    D_18T(5.2d), AI_24(1d), PW_JT9D(4.05), NK_8_2U(4.1), GE90_115B(6.9);

    private double fuelConsuption;

    Engine(double fuelConsuption) {
        this.fuelConsuption = fuelConsuption;
    }

    public double getFuelConsuption() {
        return fuelConsuption;
    }
}
