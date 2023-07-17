package ru.sberhealth.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class DoctorChoiceTests extends TestBase {


    @Test
    @Tag("doctors")
    @DisplayName("Successful doctor choice")
    void successfulDoctorSearch() {
        step("Open 'Приём врача в клинике' page", () -> {
            doctorChoicePage.openDoctorChoicePage();
        });
        step("City choice", () -> {
            doctorChoicePage.clickWrongCity();
            doctorChoicePage.chooseCity("Санкт-Петербург");
        });
        step("Doctor search", () -> {
            doctorChoicePage.typeDoctorProfile("Стоматолог");
            doctorChoicePage.typeCityArea1("Ленинский проспект");
            doctorChoicePage.clickSearchButton();
        });
        step("Check that the right doctors are chosen", () -> {
            doctorChoicePage.checkRightDoctors("Стоматологи", "Ленинский проспект");
        });
    }

    @Test
    @Tag("doctors")
    @DisplayName("Successful kids doctor choice")
    void successfulKidsDoctorSearch() {
        step("Open Приём врача в клинике page", () -> {
            doctorChoicePage.openDoctorChoicePage();
        });
        step("City choice", () -> {
            doctorChoicePage.clickWrongCity();
            doctorChoicePage.chooseCity("Санкт-Петербург");
        });
        step("Doctor search", () -> {
            doctorChoicePage.typeDoctorProfile("Стоматолог");
            doctorChoicePage.typeCityArea1("Ленинский проспект");
            doctorChoicePage.clickSearchButton();
        });
        step("Put a tick on 'Детский врач' checkbox", () -> {
            doctorChoicePage.clickKidsTick();
        });
        step("Check that the right kids' doctors are chosen", () -> {
            doctorChoicePage.checkRightDoctors("Детские стоматологи", "Ленинский проспект");
        });
    }

    @Test
    @Tag("doctors")
    @DisplayName("Successful DMS doctor choice")
    void successfulDmsDoctorSearch() {
        step("Open Приём врача в клинике page", () -> {
            doctorChoicePage.openDoctorChoicePage();
        });
        step("City choice", () -> {
            doctorChoicePage.clickWrongCity();
            doctorChoicePage.chooseCity("Екатеринбург");
        });
        step("Doctor search", () -> {
            doctorChoicePage.typeDoctorProfile("Терапевт");
            doctorChoicePage.typeCityArea2("Проспект Космонавтов");
            doctorChoicePage.clickSearchButton();
        });
        step("Put a tick on 'По полису ДМС' checkbox", () -> {
            doctorChoicePage.clickDmsTick();
        });
        step("Check the appearance of DMS authorization pop-up", () -> {
            doctorChoicePage.checkDmsAuthPresence();
        });
    }
}
