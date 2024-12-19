package org.example.INTERFACES;

public interface IEngine {
    boolean isRunning();
    void start();
    void stop();
    void consume(double liters);
}
