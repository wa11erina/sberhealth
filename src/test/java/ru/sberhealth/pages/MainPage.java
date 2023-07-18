package ru.sberhealth.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    SelenideElement
            headerLinks = $(".the-header__links");

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

        return this;
    }

    public MainPage clickOnlineConsultation() {
        headerLinks.$(byText("Онлайн-консультации")).click();

        return this;
    }

    public MainPage clickDiagnostics() {
        headerLinks.$(byText("Диагностика")).click();

        return this;
    }
}
