package org.example.CLASSES;

import org.example.INTERFACES.IEngine;
import org.example.INTERFACES.IFuelTank;
import org.example.Main;

public class EngineMK1 implements IEngine {
    private boolean isRunning;
    private IFuelTank iFuelTank;


    public EngineMK1(IFuelTank iFuelTank1){
        this.iFuelTank = iFuelTank1;
        isRunning = false;
    }


    @Override
    public boolean isRunning() {
        if(!isRunning){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void start() {
        isRunning = true;

    }

    @Override
    public void stop() {
        isRunning = false;

    }

    @Override
    public void consume(double liters) {
                System.out.println("Трата топлива:.....");
                if(iFuelTank.getFillLevel() > 0){
                    if(iFuelTank.isOnReserve()){
                        System.out.println("Начинается трата резервного топлива");
                        iFuelTank.consume(liters);
                    }else{
                        iFuelTank.consume(liters);
                    }
                }


        }
    }
