package ru.sberhealth.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPageHeader {
    SelenideElement
        headerLinks = $(".the-header__links");

    public MainPageHeader openMainPage() {
        open(baseUrl);
        return this;
    }

    public MainPageHeader checkHeaderLinks() {

        headerLinks.shouldHave(text ("Приём врача в клинике"))
                .shouldHave(text ("Онлайн-консультации"))
                .shouldHave(text ("Диагностика"))
                .shouldHave(text ("Анализы"))
                .shouldHave(text ("Услуги"))
                .shouldHave(text ("Компаниям"))
                .shouldHave(text ("Линия доверия"));

        return this;
    }
}
