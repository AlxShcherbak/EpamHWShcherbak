package com.ua.eNums;

/**
 * Created by AlxEx on 28.10.2015.
 */
public enum PlaneModel {
    AN_225("Cossack", Engine.D_18T, 6, 800, 300d, 150d, 70),
    AN_24("Cock", Engine.AI_24, 2, 460, 4.85, 6.5, 50),
    BOING_747("Jumbo Jet", Engine.PW_JT9D, 4, 900, 196, 10d, 550),
    Tu_154("Careless", Engine.NK_8_2U, 3, 900, 40, 18, 160),
    BOING_777_300ER("Triple Seven", Engine.GE90_115B, 2, 905, 171, 20, 365);

    private String codeName;

    private Engine engine;
    private int engineNumber;
    private double speed;

    private double flueCapacity;
    private double cargoCapacity;
    private int passengerCapacity;

    PlaneModel(String codeName, Engine engine, int engineNumber, double speed,
               double flueCapacity, double cargoCapacity, int passengerCapacity) {
        this.codeName = codeName;
        this.engine = engine;
        this.engineNumber = engineNumber;
        this.speed = speed;
        this.flueCapacity = flueCapacity;
        this.cargoCapacity = cargoCapacity;
        this.passengerCapacity = passengerCapacity;
    }

    public String getCodeName() {
        return codeName;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getEngineNumber() {
        return engineNumber;
    }

    public double getFlueCapacity() {
        return flueCapacity;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public double range() {
        return flueCapacity * 0.9 / fuelConsuption() * speed;
    }

    public double fuelConsuption() {
        return engine.getFuelConsuption() * engineNumber;
    }
}
