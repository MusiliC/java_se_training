package com.systechafrica.part2.interfaces;

public class MobileCharger implements ThreePinPlug {

    @Override
    public boolean plugIn() {
      System.out.println("Phone charged plugged in");
      return true;
    }

    @Override
    public boolean plugOut() {
        System.out.println("Phone charger plugged out");
        return false;
    }
    
}
