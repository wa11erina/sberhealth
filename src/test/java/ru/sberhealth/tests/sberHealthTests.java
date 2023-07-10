package ru.sberhealth.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.sberhealth.pages.MainPageHeader;

public class sberHealthTests extends TestBase{


    @Test
    @Tag("Main_Page")
    @Tag("Check_presence")
    @DisplayName("Check 'СберЗдоровье' logo presence")
    void checkLogo() {
        mainPageHeader.openMainPage()
                        .checkLogo();



    }
}
