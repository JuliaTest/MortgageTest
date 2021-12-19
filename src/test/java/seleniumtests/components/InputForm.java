package seleniumtests.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class InputForm {
    public void openPage(){
        Selenide.open("https://calcus.ru/kalkulyator-ipoteki");
    }

    public void setCost(String cost){
        $(byAttribute("name", "cost")).setValue(cost);
    }

    public void setStartSum(String startSum) {
        $(byAttribute("name", "start_sum")).setValue(startSum);
    }

    public String getCreditSum() {
        String creditSum = $("span.credit_sum_value").text();
        return creditSum;
    }

    public void setPeriod(String period) {
        $(byAttribute("name", "period")).sendKeys(period);
    }

    public void selectPeriodType(String periodType) {
        $(byAttribute("name", "period_type")).selectOptionByValue(periodType);
    }

    public void setPercent(String percent) {
        $(byAttribute("name", "percent")).setValue(percent);
    }

    public void selectPaymentType(String paymentType) {
        $(byText(paymentType)).click();
    }

    public MortgageResult clickCalculateButton(){
        $(byAttribute("value", "Рассчитать")).click();
        return new MortgageResult();
    }

    public String getPeriodError(){
        return $(byId("period-error")).shouldBe(Condition.visible).text();
    }

}
