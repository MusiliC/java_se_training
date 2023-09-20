package com.systechafrica.part2.interfaces;

public class CookerCharger implements ThreePinPlug {
        @Override
    public boolean plugIn() {
      System.out.println("Cooker charger plugged in");
      return true;
    }

    @Override
    public boolean plugOut() {
        System.out.println("Cooker charger plugged out");
        return false;
    }
}
