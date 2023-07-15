package ru.sberhealth.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class OnlineConsultationTests extends TestBase {

    @Test
    @Tag("test")
    @Tag("consultation")
    @DisplayName("Check presence of 'Срочные консультации (Терапевт, педиатр, ветеринар)' on 'Онлайн-консультации' page")
    void checkUrgentLinks() {
        step("Open 'Онлайн-консультации' page", () -> {
            onlineConsultationPage.clickOnlineConsultation();
        });
        step("Check presence of links", () -> {
            onlineConsultationPage.checkPresenceofUrgentLinks();
        });
    }

    @Test
    @Tag("test")
    @Tag("consultation")
    @DisplayName("Check the opportunity to get duty therapist's online consultation")
    void checkUrgentTherapist() {
        step("Open 'Онлайн-консультации' page", () -> {
            onlineConsultationPage.clickOnlineConsultation();
        });
        step("Click 'Терапевт' link", () -> {
            onlineConsultationPage.clickTherapistLink();
        });
        step("Check headers 'Дежурный терапевт' & 'Дежурный терапевт поможет онлайн' presence", () -> {
            onlineConsultationPage.checkTherapistHeaders();
        });
        step("Check duty therapist consultation cost", () -> {
            onlineConsultationPage.checkConsultationCost("1990 ₽");
        });
        step("Click 'Купить сейчас' button", () -> {
            onlineConsultationPage.clickBuyConsultation();
        });
        step("Verify consultation info & cost", () -> {
            onlineConsultationPage.verifyTherapistConsultationInfo("1 990", "₽");
        });
        step("Check that there is authorization via mobile number, Сбер ID & Госуслуги", () -> {
            onlineConsultationPage.checkAuthOpportunities();
        });
    }

    @Test
    @Tag("test")
    @Tag("consultation")
    @DisplayName("Check the opportunity to get duty paediatrician's online consultation")
    void checkUrgentPaediatrician() {
        step("Open 'Онлайн-консультации' page", () -> {
            onlineConsultationPage.clickOnlineConsultation();
        });
        step("Click 'Педиатр' link", () -> {
            onlineConsultationPage.clickPaediatricianLink();
        });
        step("Check headers 'Дежурный педиатр' & 'Дежурный педиатр поможет онлайн' presence", () -> {
            onlineConsultationPage.checkPaediatricianHeaders();
        });
        step("Check duty pediatrician consultation cost", () -> {
            onlineConsultationPage.checkConsultationCost("1990 ₽");
        });
        step("Click 'Купить сейчас' button", () -> {
            onlineConsultationPage.clickBuyConsultation();
        });
        step("Verify consultation info & cost", () -> {
            onlineConsultationPage.verifyPediatricianConsultationInfo("1 990", "₽");
        });
        step("Check that there is authorization via mobile number, Сбер ID & Госуслуги", () -> {
            onlineConsultationPage.checkAuthOpportunities();
        });
    }

    @Test
    @Tag("test")
    @Tag("consultation")
    @DisplayName("Check the opportunity to get duty vet's online consultation")
    void checkUrgentVet() {
        step("Open 'Онлайн-консультации' page", () -> {
            onlineConsultationPage.clickOnlineConsultation();
        });
        step("Click 'Ветеринар' link", () -> {
            onlineConsultationPage.clickVetLink();
        });
        step("Check headers 'Дежурный ветеринар' & 'Дежурный ветеринар поможет онлайн' presence", () -> {
            onlineConsultationPage.checkVetHeaders();
        });
        step("Check duty vet consultation cost", () -> {
            onlineConsultationPage.checkConsultationCost("990 ₽");
        });
        step("Click 'Купить сейчас' button", () -> {
            onlineConsultationPage.clickBuyConsultation();
        });
        step("Verify consultation info & cost", () -> {
            onlineConsultationPage.verifyVetConsultationInfo("990", "₽");
        });
        step("Check that there is authorization via mobile number, Сбер ID & Госуслуги", () -> {
            onlineConsultationPage.checkAuthOpportunities();
        });
    }
}
