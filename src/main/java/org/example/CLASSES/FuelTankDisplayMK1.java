package org.example.CLASSES;

import org.example.INTERFACES.IFuelTank;
import org.example.INTERFACES.IFuelTankDisplay;

public class FuelTankDisplayMK1 implements IFuelTankDisplay {
    private IFuelTank iFuelTank;
    public FuelTankDisplayMK1(IFuelTank iFuelTank1){
        this.iFuelTank = iFuelTank1;
    }

    @Override
    public double getFillLevel() {
        return iFuelTank.getFillLevel();
    }

    @Override
    public boolean isOnReserve() {
       return iFuelTank.isOnReserve();
    }

    @Override
    public boolean isComplete() {
        return  iFuelTank.isComplete();
    }
}
