package ru.sberhealth.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class DiagnosticsTests extends TestBase {

    @Test
    @Tag("test")
    @Tag("diagnostics")
    @DisplayName("Successful search result from the complete list of diagnostic procedures")
    void searchDiagnosticProcedureFromCompleteList() {
        step("Open 'Диагностика' page", () -> {
            diagnosticsPage.openDiagnosticsPage();
        });
        step("Choose city", () -> {
            diagnosticsPage.chooseCity("Санкт-Петербург");
            $(".about_list_short").shouldHave(Condition.text("в Санкт-Петербурге"));
        });
        step("Choose diagnostics procedure", () -> {
            diagnosticsPage.chooseDiagnostics("4D УЗИ");
        });
        step("Choose metro station", () -> {
            diagnosticsPage.chooseMetroStation("Василеостровская");
        });
        step("Check diagnostics search results", () -> {
            diagnosticsPage.checkSearchResults("4D УЗИ", "Василеостровская");
        });
    }

    @Test
    @Tag("test")
    @Tag("diagnostics")
    @DisplayName("Successful result for matching diagnostics to physiological systems")
    void matchDiagnosticsToBodyIssues() {
        step("Open 'Диагностика' page", () -> {
            diagnosticsPage.openDiagnosticsPage();
        });
        step("Choose city", () -> {
            diagnosticsPage.chooseCity("Санкт-Петербург");
        });
        step("Match diagnostics to body system", () -> {
            diagnosticsPage.findMatchDiagnosticsBlock();
            diagnosticsPage.chooseBodyOrgan("Слуха");
        });
        step("Specify organ to diagnose", () -> {
            diagnosticsPage.specifyOrganToDiagnose("Ухо (слух)");
        });
        step("Choose metro station", () -> {
            diagnosticsPage.chooseMetroStation("Пионерская");
        });
        step("Verify diagnostics search results", () -> {
            diagnosticsPage.verifyFoundResults("Ухо (слух)", "Пионерская");
        });
    }
}
