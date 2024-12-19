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
        assertEquals(isRunning,carMK.isEngineRunning());

    }
    @Test
    void engineStart_Exception() {
        CarMK carMK = new CarMK();
        boolean result = false;
        try{
            carMK.engineStart();
            carMK.engineStart();
        }catch (Exception e){
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
        assertEquals(isRunning,carMK.isEngineRunning());
    }

    @Test
    void refuel() {
    }

    @Test
    void runningidle() throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        IFuelTank fuelTankMK1 = new FuelTankMK1(60);
        Class<?> o  = fuelTankMK1.getClass();
        double a = 59.90;
        Field filllevel  = o.getDeclaredField("filllevel");
        filllevel.setAccessible(true);
        Method getfilllevel;
        getfilllevel = o.getDeclaredMethod("getFillLevel");
        getfilllevel.setAccessible(true);
        assertEquals(a,getfilllevel.invoke(fuelTankMK1));

    }

    @Test
    void isEngineRunning() {
    }
}