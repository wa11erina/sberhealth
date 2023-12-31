package ru.sberhealth.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DiagnosticsPage {
    String diagnosticsPage = "https://diagnostica.docdoc.ru/";
    SelenideElement
            diagnosticsPageElementToCheck = $(".search_form"),
            mainDiagnosticsList = $(".spec_list.diagnostic-top-list"),
            currentCityBlock = $(".about_list_short"),
            cityChoiceBlock = $("#ChangeCityBlock"),
            cityNameInsideDescription = $(".about_list_short"),
            diagnosticsListAccess = $("#chosenDiagnostic"),
            diagnosticsList = $("#spec-list"),
            metroChoiceField = $("[data-autocomplete-id='autocomplete-geo']"),
            chosenStation = $(".ui-corner-all"),
            searchResultsTitle = $("h1"),
            matchDiagnosticsHeader = $("h2"),
            bodyOrgansList = $(".organ-top-list"),
            organsListAccess = $("#chosenOrgan"),
            organsList = diagnosticsList,
            breadCrumbs = $(".breadcrumbs"),
            finalConclusion = $(".h1");


    public DiagnosticsPage openDiagnosticsPage() {
        open(diagnosticsPage);
        mainDiagnosticsList.shouldHave(text("УЗИ"));
        currentCityBlock.shouldHave(text("в Москве"));

        return this;
    }

    public DiagnosticsPage checkDiagnosticsPageOpened() {
        diagnosticsPageElementToCheck.shouldHave(text("Все диагностики"));

        return this;
    }

    public DiagnosticsPage chooseCity(String city, String inTheCity) {
        cityChoiceBlock.click();
        cityChoiceBlock.$(byText(city)).click();
        cityNameInsideDescription.shouldHave(text(inTheCity));

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
        searchResultsTitle.shouldHave(text(procedure))
                .shouldHave(text(station));

        return this;
    }

    public DiagnosticsPage findMatchDiagnosticsBlock() {
        matchDiagnosticsHeader.shouldHave(text("Подобрать исследование"));

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
