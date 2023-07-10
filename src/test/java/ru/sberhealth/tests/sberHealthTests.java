package ru.sberhealth.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class sberHealthTests extends TestBase{


    @Test
    @Tag("Main_Page")
    @Tag("Check_presence")
    @DisplayName("Check header links presence")
    void checkLogo() {
        healthPage.openMainPage()
                        .checkHeaderLinks();

    }

    @Test
    @Tag("Doctors")
    @Tag("Check_presence")
    @DisplayName("Successful doctor choice")
    void successfulDoctorSearch() {
        step ("Open SberHealth Main Page", () -> {
            healthPage.openMainPage();
        });
        step ("Click Приём врача в клинике", () -> {
            healthPage.clickDoctorAppointment();
        });
        step ("City choice", () -> {
            healthPage.clickWrongCity();
            healthPage.chooseCity("Санкт-Петербург");
        });
        step ("Doctor search", () -> {
            healthPage.typeDoctorProfile("стоматолог");
////            healthPage.typeCityArea("ленинский");
////            healthPage.clickSearchButton();
        });
    }
}
