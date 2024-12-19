package org.example.INTERFACES;

public interface ICar {
    void engineStart() throws Exception;
    void engineStop();
    void refuel(double  liters);
    void runningidle();
    boolean isEngineRunning();

}
