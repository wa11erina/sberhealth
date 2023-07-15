package ru.sberhealth.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DiagnosticsPage {
    SelenideElement
        headerLinks = $(".the-header__links"),
        cityChoiceBlock = $("#ChangeCityBlock"),
        listOfCities = $(".b-dropdown_list"),
        diagnosticsListAccess = $("#chosenDiagnostic"),
        diagnosticsList = $("#spec-list"),
        metroChoiceField = $("[placeholder='Укажите метро']"),
        chosenStation = $(".ui-menu-item"),
        headerResults = $("h1"),
        matchDiagnosticsHeader = $("h2"),
        bodyOrgansList = $(".organ-top-list"),
        organsListAccess = $("#chosenOrgan"),
        organsList = diagnosticsList,
        breadCrumbs = $ (".breadcrumbs"),
        finalConclusion = $(".h1");


    public DiagnosticsPage openDiagnosticsPage() {
        open("https://diagnostica.docdoc.ru/");
        $(".spec_list.diagnostic-top-list").shouldHave(text("УЗИ"));
        $(".about_list_short").shouldHave(text("в Москве"));
        return this;
    }
    public DiagnosticsPage chooseCity(String city) {
        cityChoiceBlock.click();
        listOfCities.$(byText(city)).click();

        return this;
    }

    public DiagnosticsPage chooseDiagnostics(String procedure) {
        diagnosticsListAccess.shouldBe(interactable);
        diagnosticsListAccess.click();
        diagnosticsList.shouldBe(visible).$(byText(procedure)).click();

        return this;
    }

    public DiagnosticsPage chooseMetroStation(String station) {
        metroChoiceField.click();
        metroChoiceField.setValue(station);
        chosenStation.shouldBe(visible).$(byText(station)).click();


        return this;
    }
    public DiagnosticsPage checkSearchResults(String procedure, String station) {
        headerResults.shouldHave(text (procedure))
                .shouldHave(text(station));

        return this;

    }
    public DiagnosticsPage findMatchDiagnosticsBlock() {
        matchDiagnosticsHeader.shouldHave(text ("Подобрать исследование"));

        return this;
    }

    public DiagnosticsPage chooseBodyOrgan(String value) {
        bodyOrgansList.shouldBe(visible).$(byText(value)).click();

        return this;
    }

    public DiagnosticsPage specifyOrganToDiagnose(String organ) {
        organsListAccess.shouldBe(interactable);
        organsListAccess.click();
        organsList.shouldBe(visible).$(byText(organ)).click();

        return this;
    }

    public DiagnosticsPage verifyFoundResults(String organ, String station) {
        breadCrumbs.shouldHave(text(organ))
                .shouldHave(text(station));
        finalConclusion.shouldHave(text("Найдено"));

        return this;
    }
}
