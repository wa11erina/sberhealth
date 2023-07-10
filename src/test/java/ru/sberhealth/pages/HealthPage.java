package ru.sberhealth.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HealthPage {
    SelenideElement
        headerLinks = $(".the-header__links"),
        wrongCity = $(".Popover__footer_25aR").$(byText("Нет, не он")),
        listOfCities = $(".CitySelectModal__cities-wrapper_1BfH"),
        doctorSearchField = $("[placeholder='Врач, клиника, болезнь, услуга']"),
        dropdownSuggestions = $(".v-autocomplete-list");

    public HealthPage openMainPage() {
        open(baseUrl);
        return this;
    }

    public HealthPage checkHeaderLinks() {

        headerLinks.shouldHave(text ("Приём врача в клинике"))
                .shouldHave(text ("Онлайн-консультации"))
                .shouldHave(text ("Диагностика"))
                .shouldHave(text ("Анализы"))
                .shouldHave(text ("Услуги"))
                .shouldHave(text ("Компаниям"))
                .shouldHave(text ("Линия доверия"));

        return this;
    }
    public HealthPage clickDoctorAppointment() {
        headerLinks.$(byText("Приём врача в клинике")).click();

        return this;
    }

    public HealthPage clickWrongCity() {
        wrongCity.click();

        return this;
    }

    public HealthPage chooseCity(String city) {
        listOfCities.$(byText(city)).click();

        return this;
    }
    public HealthPage typeDoctorProfile(String profile) {
        doctorSearchField.setValue(profile).shouldBe(visible);
        dropdownSuggestions.shouldBe(visible);
        doctorSearchField.pressEnter();

        return this;
    }
}
