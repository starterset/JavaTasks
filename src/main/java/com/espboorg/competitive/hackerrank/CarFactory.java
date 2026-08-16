package com.espboorg.competitive.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


abstract class Car {
    protected boolean isSedan;
    protected int seats;

    public Car(boolean isSedan, int seats) {
        this.isSedan = isSedan;
        this.seats = seats;
    }

    public boolean getIsSedan() {
        return this.isSedan;
    }

    public int getSeats() {
        return this.seats;
    }

    abstract public String getMileage();

    public void printCar(String name) {
        System.out.println(
                "A " + name + " is " + (this.getIsSedan() ? "" : "not ")
                        + "Sedan, is " + this.getSeats() + "-seater, and has a mileage of around "
                        + this.getMileage() + ".");
    }
}

/**
 * WagonR class
 **/
class WagonR extends Car {
    protected int mileage;

    public WagonR(boolean isSedan, int seats, int mileage) {
        super(isSedan, seats);
        this.mileage = mileage;
    }

    public WagonR(int mileage) {
        this(true, 4, mileage);
    }

    @Override
    public String getMileage() {
        return "" + mileage;
    }
}

/**
 * HondaCity class
 **/
class HondaCity extends Car {

    protected int mileage;

    public HondaCity(boolean isSedan, int seats, int mileage) {
        super(isSedan, seats);
        this.mileage = mileage;
    }

    public HondaCity(int mileage) {
        this(true, 4, mileage);
    }

    @Override
    public String getMileage() {
        return "" + mileage;
    }
}

/**
 * InnovaCrysta class
 **/
class InnovaCrysta extends Car {

    protected int mileage;

    public InnovaCrysta(boolean isSedan, int seats, int mileage) {
        super(isSedan, seats);
        this.mileage = mileage;
    }

    public InnovaCrysta(int mileage) {
        this(true, 4, mileage);
    }

    @Override
    public String getMileage() {
        return "" + mileage;
    }
}

public class CarFactory {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int carType = Integer.parseInt(bufferedReader.readLine().trim());
        int carMileage = Integer.parseInt(bufferedReader.readLine().trim());

        if (carType == 0) {
            Car wagonR = new WagonR(carMileage);
            wagonR.printCar("WagonR");
        }

        if (carType == 1) {
            Car hondaCity = new HondaCity(carMileage);
            hondaCity.printCar("HondaCity");
        }

        if (carType == 2) {
            Car innovaCrysta = new InnovaCrysta(carMileage);
            innovaCrysta.printCar("InnovaCrysta");
        }
    }
}