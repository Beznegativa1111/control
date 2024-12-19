package org.example.CLASSES;

import org.example.INTERFACES.ICar;
import org.example.INTERFACES.IEngine;
import org.example.INTERFACES.IFuelTank;

public class CarMK implements ICar {
    private FuelTankDisplayMK1 fuelTankDisplay;
    private IEngine engine;
    private IFuelTank iFuelTank;

    public CarMK() {
        iFuelTank = new FuelTankMK1();
        engine = new EngineMK1(iFuelTank);
        fuelTankDisplay = new FuelTankDisplayMK1(iFuelTank);
    }

    public CarMK(Integer filllevel) {
        if (filllevel > 60) {
            try {
                throw new Exception("Количество топлива не может превышать 60 литров");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            this.iFuelTank = new FuelTankMK1(filllevel);
            engine = new EngineMK1(iFuelTank);
            fuelTankDisplay = new FuelTankDisplayMK1(iFuelTank);
        }
    }

    @Override
    public void engineStart() {
        if (isEngineRunning()) {
            try {
                throw new Exception("Двигатель и так запущен");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }if(!isEngineRunning()) {
            System.out.println("двигатель заведен, текущий уровень топлива : " + fuelTankDisplay.getFillLevel());
            engine.start();

        }

    }

    @Override
    public void engineStop() {
        if (!isEngineRunning()) {
            try {
                throw new Exception("двигатель не заведен");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.print("двигатель остановлен, текущий показатель топлива: ");
            System.out.format("%.2f", fuelTankDisplay.getFillLevel());
            engine.stop();
        }
    }

    @Override
    public void refuel(double liters) {
        iFuelTank.refuel(liters);
    }

    @Override
    public void runningIdle() {
        if(isEngineRunning()){
            if (fuelTankDisplay.getFillLevel() > 0) {
                System.out.format(" текущее значение топлива:  %.2f \n", fuelTankDisplay.getFillLevel());
                engine.consume(iFuelTank.getFillLevel());
            }
        }


    }

    @Override
    public boolean isEngineRunning() {
        return engine.isRunning();
    }
}

