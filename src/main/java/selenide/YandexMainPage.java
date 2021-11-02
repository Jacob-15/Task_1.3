package selenide;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class YandexMainPage extends BasePage {

    @Step
    public YandexMainPage openChapterLaptop() {
        $(By.xpath("//a[@data-id='market']")).click();
        switchTo().window(1);
        $(By.xpath("//button[@class='_2AMPZ _3CFK9 _2VvV8 _3WgR5']")).click();
        $(By.xpath("//li[@data-zone-data='{\"id\":\"97009164\"}']")).hover();
        $(By.xpath("//div[contains(@data-zone-data,',\"hid\":[\"91013\"]')]/a[contains(.,'Ноутбуки')]")).click();
        return page(YandexMainPage.class);
    }


    @Step
    public YandexMainPage choiceFilterForLoptop() {
        $(By.xpath("//input[@class='_2yK7W _1d02b' and @id='glpricefrom']")).setValue("10000").pressEnter();
        $(By.xpath("//input[@class='_2yK7W _1f2us' and @id='glpriceto']")).setValue("30000").pressEnter();
        $(By.xpath("//span[@class='_1o8_r xUzR2' and contains(.,'HP')]")).click();
        $(By.xpath("//span[@class='_1o8_r xUzR2' and contains(.,'Lenovo')]")).click();
        MarketFilters marketFilters = new MarketFilters();
        marketFilters.choseCountLopTop("Показывать по 12");
        return page(YandexMainPage.class);
    }

    @Step
    public YandexMainPage choiceModelLaptop() throws InterruptedException {
        List<SelenideElement> laptopList = $$(By.xpath("//div[@class='_37suf']/div/h3/a"));
        Thread.sleep(200);
        String firstTitleLaptop = laptopList.stream().map(SelenideElement::getText).findFirst().get();
        $(By.xpath("//input[@id='header-search']")).sendKeys(firstTitleLaptop);
        $(By.xpath("//button[@data-r='search-button']")).click();
        Thread.sleep(50);
        List<SelenideElement> namesLaptopsFromSearchField = $$(By.xpath("//div[@class='_37suf']/div/h3/a"));
        namesLaptopsFromSearchField.stream().map(SelenideElement::getText).findFirst().get().contains(firstTitleLaptop);
        return page(YandexMainPage.class);
    }
}
