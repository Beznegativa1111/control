package org.example.INTERFACES;

public interface IFuelTank {
    double getFillLevel();
    boolean isOnReserve();
    boolean isComplete();
    void consume(double liters);
    void refuel(double liters);

}
