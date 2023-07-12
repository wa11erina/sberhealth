package ru.sberhealth.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class OnlineConsultationPage {
    SelenideElement
        headerLinks = $(".the-header__links"),
        urgentConsultationPage = $("[data-testid='urgent-consultations-block-wrapper']"),
        therapistLink = $("[data-testid='urgent-consultations-block-container']").$(byText("Терапевт")),
        paediatricianLink = $("[data-testid='urgent-consultations-block-container']").$(byText("Педиатр")),
        vetLink = $("[data-testid='urgent-consultations-block-container']").$(byText("Ветеринар")),
        dutySpecialist = $("[data-testid='catalog-product-banner-wrapper']"),
        dutySpecialistHelpsOnline = $("[data-testid='catalog-product-block-title']"),
        consultationCost = $("[data-testid='catalog-product-price-wrapper']"),
        loginForm = $(".checkout-login");



    public OnlineConsultationPage clickOnlineConsultation() {
        headerLinks.$(byText("Онлайн-консультации")).click();


        return this;
    }

    public OnlineConsultationPage checkPresenceofUrgentLinks() {
        urgentConsultationPage.shouldHave(text("Срочные консультации"))
                .shouldHave(text("Терапевт"))
                .shouldHave(text("Педиатр"))
                .shouldHave(text("Ветеринар"));

        return this;
    }

    public OnlineConsultationPage clickTherapistLink() {
        therapistLink.click();

        return this;
    }

    public OnlineConsultationPage clickPaediatricianLink() {
        paediatricianLink.click();

        return this;

    }

    public OnlineConsultationPage clickVetLink() {
        vetLink.click();

        return this;

    }

    public OnlineConsultationPage checkTherapistHeaders() {
        dutySpecialist.shouldHave(text("Дежурный терапевт"));
        dutySpecialistHelpsOnline.shouldHave(text("Дежурный терапевт поможет онлайн"));

        return this;
    }

    public OnlineConsultationPage checkPaediatricianHeaders() {
        dutySpecialist.shouldHave(text("Дежурный педиатр"));
        dutySpecialistHelpsOnline.shouldHave(text("Дежурный педиатр поможет онлайн"));

        return this;
    }

    public OnlineConsultationPage checkVetHeaders() {
        dutySpecialist.shouldHave(text("Дежурный ветеринар"));
        dutySpecialistHelpsOnline.shouldHave(text("Дежурный ветеринар поможет онлайн"));

        return this;
    }


    public OnlineConsultationPage checkConsultationCost(String cost) {
        consultationCost.shouldHave(text("Стоимость "))
                .shouldHave(text("консультации"))
                .shouldHave(text(cost));

        return this;
    }

    public OnlineConsultationPage clickBuyConsultation() {
        consultationCost.$(byText("Купить сейчас")).click();

        return this;
    }

    public OnlineConsultationPage verifyTherapistConsultationInfo(String cost, String rubles) {
        loginForm.shouldHave(text("Дежурный терапевт - разовая консультация"))
                .shouldHave(text(cost))
                .shouldHave(text(rubles));

        return this;
    }

    public OnlineConsultationPage verifyPediatricianConsultationInfo(String cost, String rubles) {
        loginForm.shouldHave(text("Дежурный педиатр - разовая консультация"))
                .shouldHave(text(cost))
                .shouldHave(text(rubles));

        return this;
    }

    public OnlineConsultationPage verifyVetConsultationInfo(String cost, String rubles) {
        loginForm.shouldHave(text(cost))
                .shouldHave(text(rubles));

        return this;
    }

    public OnlineConsultationPage checkAuthOpportunities() {
        loginForm.shouldHave(text("Введите номер телефона"))
                .shouldHave(text("Войти по Сбер ID"))
                .shouldHave(text("Вход через Госуслуги"));

        return this;
    }

}
