package ru.sberhealth.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class MainPageTests extends TestBase {
    @Test
    @Tag("main_page")
    @DisplayName("Check header links presence")
    void checkLinksText() {
        mainPage.checkHeaderLinks();
    }

    @Test
    @Tag("main_page")
    @DisplayName("Check Doctor choice link")
    void checkDoctorChoiceLink() {
        mainPage.clickDoctorChoice();
        doctorChoicePage.checkDoctorChoicePageOpened();
    }

    @Test
    @Tag("main_page")
    @DisplayName("Check Online Consultation link")
    void checkOnlineConsultationLink() {
        mainPage.clickOnlineConsultation();
        onlineConsultationPage.checkOnlineConsultationPageOpened();
    }

    @Test
    @Tag("main_page")
    @DisplayName("Check Diagnostics link")
    void checkDiagnosticsLink() {
        mainPage.clickDiagnostics();
        diagnosticsPage.checkDiagnosticsPageOpened();
    }
}

