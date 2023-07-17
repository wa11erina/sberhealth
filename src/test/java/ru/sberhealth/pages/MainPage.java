package ru.sberhealth.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    SelenideElement
        headerLinks = $(".the-header__links"),
        doctorChoicePageElementToCheck = $("[data-test-id='search-form-layout']"),
        onlineConsultationPageElementToCheck = $("h4"),
        diagnosticsPageElementToCheck = $(".search_form");

    public MainPage checkHeaderLinks() {
        headerLinks.shouldHave(text("Приём врача в клинике"))
                .shouldHave(text("Онлайн-консультации"))
                .shouldHave(text("Диагностика"))
                .shouldHave(text("Анализы"))
                .shouldHave(text("Услуги"))
                .shouldHave(text("Компаниям"))
                .shouldHave(text("Линия доверия"));

        return this;
    }

    public MainPage clickDoctorChoice() {
        headerLinks.$(byText("Приём врача в клинике")).click();
        doctorChoicePageElementToCheck.shouldHave(text("Запишитесь на приём к врачу онлайн"));

        return this;
    }

    public MainPage clickOnlineConsultation() {
        headerLinks.$(byText("Онлайн-консультации")).click();
        onlineConsultationPageElementToCheck.shouldHave(text("Срочные консультации"));

        return this;
    }

    public MainPage clickDiagnostics() {
        headerLinks.$(byText("Диагностика")).click();
        diagnosticsPageElementToCheck.shouldHave(text("Все диагностики"));

        return this;
    }
}
