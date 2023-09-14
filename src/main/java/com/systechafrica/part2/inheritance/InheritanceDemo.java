package com.systechafrica.part2.inheritance;

import java.util.logging.Logger;

import com.systechafrica.part2.inheritance.companysetup.QualityAssurance;
import com.systechafrica.part2.inheritance.companysetup.SoftwareEngineer;

public class InheritanceDemo {

    private static final Logger LOGGER = Logger.getLogger(InheritanceDemo.class.getName());

    public static void main(String[] args) {
        InheritanceDemo app = new InheritanceDemo();
        LOGGER.info("Get hash code " + app.hashCode());
        app.companySetup();
    }

    public void companySetup() {
        SoftwareEngineer e1 = new SoftwareEngineer("001","Cee", "Kasarani", "Software Engineer");
      
        LOGGER.info("Software Engineer -> " + e1.toString());

        QualityAssurance q1 = new QualityAssurance("002", "Musili", "Lucky", "Quality Assurance Engineer");
        LOGGER.info("Quality Assurance Engineer -> " + q1.toString());
    }
}
