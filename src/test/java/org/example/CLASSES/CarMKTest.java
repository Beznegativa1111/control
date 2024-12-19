package org.example.CLASSES;

import org.example.INTERFACES.IFuelTank;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class CarMKTest {

    @Test
    void engineStart() {
        CarMK carMK = new CarMK();
        boolean isRunning = true;
        carMK.engineStart();
        assertEquals(isRunning, carMK.isEngineRunning());

    }

    @Test
    void engineStart_Exception() {
        CarMK carMK = new CarMK();
        boolean result = false;
        try {
            carMK.engineStart();
            carMK.engineStart();
        } catch (Exception e) {
            result = true;

        }
        assertTrue(result);


    }

    @Test
    void engineStop() {
        CarMK carMK = new CarMK();
        boolean isRunning = false;
        carMK.engineStart();
        carMK.engineStop();
        assertEquals(isRunning, carMK.isEngineRunning());
    }

    @Test
    void refuel() {
    }

    @Test
    void runningIdle() throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        var car = new CarMK();
        var iFuelTankField = car.getClass().getDeclaredField("iFuelTank");
        iFuelTankField.setAccessible(true);
        var iFuelTank = (IFuelTank) iFuelTankField.get(car);

        var before = iFuelTank.getFillLevel();
        car.runningIdle();
        var after = iFuelTank.getFillLevel();

        iFuelTankField.setAccessible(false);
        assertEquals(0, before - after);
    }

    @Test
    void isEngineRunning() {
    }
}