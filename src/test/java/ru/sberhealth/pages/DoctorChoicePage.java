package ru.sberhealth.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DoctorChoicePage {
    SelenideElement
        headerLinks = $(".the-header__links"),
        wrongCity = $(".Popover__footer_25aR").$(byText("Нет, не он")),
        listOfCities = $(".CitySelectModal__cities-wrapper_1BfH"),
        searchDoctorInput = $("[data-test-id='search_input']"),
        searchDoctorField = $("[placeholder='Врач, клиника, болезнь, услуга']"),
        dropdownDoctorProfiles = $(".v-autocomplete-list-item"),
        searchAreaInput = $("[data-test-id='search_geo_input']"),
        searchAreaField1 = $("[placeholder='Метро, район, город']"),
        searchAreaField2 = $("[placeholder='Метро, район']"),
        dropdownAreaSuggestions = $("[data-test-id='search_geo_items']"),
        searchButton = $("[data-test-id='search_button']"),
        resultsHeader = $(".top-seo-text__heading h1"),
        kidsTick = $(".checkbox").$(byText("Детский врач")),
        dmsTick = $(".checkbox").$(byText("По полису ДМС")),
        dmsAuth = $("[data-test-id='auth-by-dms']");


    public DoctorChoicePage checkHeaderLinks() {

        headerLinks.shouldHave(text ("Приём врача в клинике"))
                .shouldHave(text ("Онлайн-консультации"))
                .shouldHave(text ("Диагностика"))
                .shouldHave(text ("Анализы"))
                .shouldHave(text ("Услуги"))
                .shouldHave(text ("Компаниям"))
                .shouldHave(text ("Линия доверия"));

        return this;
    }
    public DoctorChoicePage clickDoctorAppointment() {
        headerLinks.$(byText("Приём врача в клинике")).click();

        return this;
    }

    public DoctorChoicePage clickWrongCity() {
        wrongCity.click();

        return this;
    }

    public DoctorChoicePage chooseCity(String city) {
        listOfCities.$(byText(city)).click();

        return this;
    }
    public DoctorChoicePage typeDoctorProfile(String profile) {
        searchDoctorInput.click();
        searchDoctorField.setValue(profile);
        dropdownDoctorProfiles.shouldBe(visible);
        dropdownDoctorProfiles.$(byText(profile)).click();

        return this;
    }
    public DoctorChoicePage typeCityArea1(String value) {
        searchAreaInput.click();
        searchAreaField1.setValue(value);
        dropdownAreaSuggestions.shouldBe(visible);
        dropdownAreaSuggestions.$(byText(value)).click();


        return this;

    }

    public DoctorChoicePage typeCityArea2(String value) {
        searchAreaInput.click();
        searchAreaField2.setValue(value);
        dropdownAreaSuggestions.shouldBe(visible);
        dropdownAreaSuggestions.$(byText(value)).click();


        return this;

    }

    public DoctorChoicePage clickSearchButton() {
        searchButton.click();

        return this;
    }

    public DoctorChoicePage checkRightDoctors(String profile, String value) {
        resultsHeader.shouldHave(text(profile))
                .shouldHave(text(value));

        return this;
    }
    public DoctorChoicePage clickKidsTick() {
        kidsTick.shouldBe(visible).click();

        return this;
    }

    public DoctorChoicePage clickDmsTick() {
        dmsTick.shouldBe(visible).click();

        return this;
    }

    public DoctorChoicePage checkDmsAuthPresence() {
        dmsAuth.should(appear);

        return this;
    }
}
