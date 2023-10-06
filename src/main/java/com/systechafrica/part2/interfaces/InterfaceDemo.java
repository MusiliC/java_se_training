package com.systechafrica.part2.interfaces;

public class InterfaceDemo {
    public static void main(String[] args) {
        //?when using instances cannot be instantiated
        ThreePinPlug cookerCharger = new CookerCharger();
        cookerCharger.plugIn();


        ThreePinPlug mobileCharger = new MobileCharger();
        mobileCharger.plugIn();

        Square sq = new Square();
        System.out.println(sq.CalculateAreaMethod(2, 3)); 
        System.out.println(sq.CalculatePerimeterMethod(2, 3)); 
        System.out.println(sq.sum(10, 20));
       
    }
}
