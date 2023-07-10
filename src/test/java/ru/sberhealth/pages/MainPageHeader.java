package ru.sberhealth.pages;

import com.codeborne.selenide.SelenideElement;
import ru.sberhealth.tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPageHeader extends TestBase {
    SelenideElement
        logo = $(".the-header__logo");

    public MainPageHeader openMainPage() {
        open(baseUrl);
        return this;
    }

    public void checkLogo() {
        logo.shouldHave(text ("Сбер Здоровье"));
    }
}
