package seleniumtests.components;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MortgageResult {
    public String getOverPayment (){
        return $("div.result-placeholder-overPayment").shouldBe(visible).text();
    }
}
