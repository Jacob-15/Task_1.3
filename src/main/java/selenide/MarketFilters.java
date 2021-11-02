package selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MarketFilters extends BasePage {


    public void choseCountLopTop(String val) {
        $(By.xpath("//button[@class='vLDMf']")).should(Condition.exist).scrollTo().click();
        ElementsCollection dropDown = $$(By.xpath("//div[@class='_3eEaG']/button"));
        dropDown.find(Condition.matchesText(val)).click();
    }

}
