package ru.sberhealth.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DoctorChoicePage {
    String doctorChoicePage = "https://docdoc.ru/doctor";
    SelenideElement
            wrongCity = $(".Popover__footer_25aR").$(byText("Нет, не он")),
            listOfCities = $(".CitySelectModal__cities-wrapper_1BfH"),
            searchDoctorInput = $("[data-test-id='search_input']"),
            searchDoctorField = $("[placeholder='Врач, клиника, болезнь, услуга']"),
            dropdownDoctorProfiles = $(".v-autocomplete-list-item"),
            searchAreaInput = $("[data-test-id='search_geo_input']"),
            searchAreaField = $("[data-test-id=search_geo_input] .v-autocomplete-input"),
            dropdownAreaSuggestions = $("[data-test-id='search_geo_items']"),
            searchButton = $("[data-test-id='search_button']"),
            resultsHeader = $(".top-seo-text__heading h1"),
            kidsTick = $("[data-test-id='search-form-filters']").$(byText("Детский врач")),
            dmsTick = $("[data-test-id='search-form-filters']").$(byText("По полису ДМС")),
            dmsAuth = $("[data-test-id='auth-by-dms']");


    public DoctorChoicePage openDoctorChoicePage() {
        open(doctorChoicePage);

        return this;
    }

    public DoctorChoicePage clickWrongCity() {
        wrongCity.click();

        return this;
    }

    public DoctorChoicePage chooseCity(String city) {
        listOfCities.shouldBe(visible).$(byText(city)).click();

        return this;
    }

    public DoctorChoicePage typeDoctorProfile(String profile) {
        searchDoctorInput.click();
        searchDoctorField.setValue(profile);
        dropdownDoctorProfiles.shouldBe(visible).$(byText(profile)).click();

        return this;
    }

    public DoctorChoicePage typeCityArea1(String value) {
        searchAreaInput.click();
        searchAreaField.setValue(value);
        dropdownAreaSuggestions.shouldBe(visible).$(byText(value)).click();

        return this;
    }

    public DoctorChoicePage typeCityArea2(String value) {
        searchAreaInput.click();
        searchAreaField.setValue(value);
        dropdownAreaSuggestions.shouldBe(visible).$(byText(value)).click();

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
        kidsTick.click();

        return this;
    }

    public DoctorChoicePage clickDmsTick() {
        dmsTick.click();

        return this;
    }

    public DoctorChoicePage checkDmsAuthPresence() {
        dmsAuth.should(appear);

        return this;
    }
}
