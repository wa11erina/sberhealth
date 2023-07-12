package ru.sberhealth.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class DiagnosticsTests extends TestBase {

    @Test
    @Tag("diagnostics")
    @DisplayName("Successful search result from the complete list of diagnostic procedures")
    void searchDiagnosticProcedureFromCompleteList() {
        step ("Open 'Диагностика' page", () -> {
            diagnosticsPage.clickDiagnosticsLink();
        });
        step ("Choose city", () -> {
            diagnosticsPage.chooseCity("Санкт-Петербург");
        });
        step ("Choose diagnostics procedure", () -> {
            diagnosticsPage.chooseDiagnostics("4D УЗИ");
        });
        step ("Choose metro station", () -> {
            diagnosticsPage.chooseMetroStation("Василеостровская");
        });
        step ("Check diagnostics search results", () -> {
            diagnosticsPage.checkSearchResults("4D УЗИ","Василеостровская");
        });
    }

    @Test
    @Tag("diagnostics")
    @DisplayName("Successful result for matching diagnostics to physiological systems")
    void matchDiagnosticsToBodyIssues() {
        step("Open 'Диагностика' page", () -> {
            diagnosticsPage.clickDiagnosticsLink();
        });
        step("Choose city", () -> {
            diagnosticsPage.chooseCity("Санкт-Петербург");
        });
        step("Match diagnostics to body system", () -> {
            diagnosticsPage.findMatchDiagnosticsBlock();
            diagnosticsPage.chooseBodyOrgan("Слуха");
        });
        step ("Specify organ to diagnose", () -> {
            diagnosticsPage.specifyOrganToDiagnose("Ухо (слух)");
        });
        step ("Choose metro station", () -> {
            diagnosticsPage.chooseMetroStation("Пионерская");
        });
        step ("Verify diagnostics search results", () -> {
            diagnosticsPage.verifyFoundResults("Ухо (слух)","Пионерская");
        });

    }
}
