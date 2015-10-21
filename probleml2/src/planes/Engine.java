package planes;

import planes.enums.EngineType;

/**
 * Created by AlxEx on 21.10.2015.
 */
public class Engine {
    private String model;
    private double power;
    private EngineType engineType;

    public Engine(String model, double power, EngineType engineType) {
        this.model = model;
        this.power = power;
        this.engineType = engineType;
    }

    public String getModel() {
        return model;
    }

    public double getPower() {
        return power;
    }

    public EngineType getEngineType() {
        return engineType;
    }
}
