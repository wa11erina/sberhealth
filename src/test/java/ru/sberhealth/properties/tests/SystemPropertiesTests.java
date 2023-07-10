package ru.sberhealth.properties.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    @Tag("Main_Page")
    @Tag("Check_presence")
    void getProperty(){
        System.out.println(System.getProperty("baseUrl"));
        System.out.println(System.getProperty("remoteUrl"));
        System.out.println(System.getProperty("browser"));
        System.out.println(System.getProperty("screenResolution"));
    }
}
