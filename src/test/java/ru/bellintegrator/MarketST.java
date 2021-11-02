package ru.bellintegrator;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import selenide.YandexMainPage;

import static com.codeborne.selenide.Selenide.open;

public class MarketST extends SelenideBaseTest {

    @Feature("Проверка сайта yandex market")
    @DisplayName("Проверка фильтров сайта")
    @ParameterizedTest(name = "{displayName}")
    @CsvSource({"USD"})
    public void secondTest() throws InterruptedException {
        open("https://yandex.ru/", YandexMainPage.class)
                .openChapterLaptop()
                .choiceFilterForLoptop()
                .choiceModelLaptop();


    }
}
