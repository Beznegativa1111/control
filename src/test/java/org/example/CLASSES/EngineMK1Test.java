package org.example.CLASSES;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EngineMK1Test {
    @Test
    public void consume() {
        var fuelTank = new FuelTankMK1();
        var engine = new EngineMK1(fuelTank);
        var beforeConsumption = fuelTank.getFillLevel();
        engine.consume(10);
        var afterConsumption = fuelTank.getFillLevel();
        Assertions.assertEquals(10, beforeConsumption - afterConsumption);
    }
}
