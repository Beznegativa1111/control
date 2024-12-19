package org.example.CLASSES;

import org.example.INTERFACES.IFuelTank;
import org.w3c.dom.ls.LSOutput;

public class FuelTankMK1 implements IFuelTank {
    private double filllevel;
    private boolean isOnReserve;
    private  boolean isComplete;
    public FuelTankMK1(){
        this.filllevel = 20;
        isOnReserve = false;
        isComplete = false;
    }
    public FuelTankMK1(double liters){
        this.filllevel = liters;
        isOnReserve = false;
        isComplete = false;
    }

    @Override
    public double getFillLevel() {
        return filllevel;
    }

    @Override
    public boolean isOnReserve() {
        if(filllevel <= 5){
            return !isOnReserve;
        }else{
            return isOnReserve;
        }
    }

    @Override
    public boolean isComplete() {
        if(isComplete){
            return !isComplete;
        }else{
            return isComplete;
        }
    }

    @Override
    public void consume(double liters) {
            filllevel -= 0.1;
            System.out.format(" Значение топлива после траты %.2f",getFillLevel());
            System.out.println("\n");

        }


    @Override
    public void refuel(double liters) {
        if(filllevel + liters > 60){
            System.out.println("Бак не вмещает больше 60 литров");
        }else{
            filllevel += liters;
            if(isComplete){
                System.out.format(" Вы заправили машину на %.2f:",liters);
                System.out.print("Машина заправлена - текущий показатель топлива: ");
                System.out.format("%.2f",getFillLevel());
            }else{
                System.out.println("заправка не закончена");
            }


        }

    }
}
