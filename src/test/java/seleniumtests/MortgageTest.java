package seleniumtests;

import org.junit.jupiter.api.Test;
import seleniumtests.components.InputForm;
import seleniumtests.components.MortgageResult;

import static com.codeborne.selenide.Selenide.sleep;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MortgageTest {
    @Test
    void creditSuccess() {
        InputForm inputForm = new InputForm();
        inputForm.openPage();
        inputForm.setCost("2000000");
        inputForm.setStartSum("200000");
        String creditSum = inputForm.getCreditSum();
        assertThat(creditSum).isEqualTo("1 800 000");
        inputForm.setPeriod("126");
        inputForm.selectPeriodType("M");
        inputForm.setPercent("10");
        inputForm.selectPaymentType("Дифференцированные");
        MortgageResult mortgageResult = inputForm.clickCalculateButton();
        String overPayment = mortgageResult.getOverPayment();
        assertEquals("952 500,00", overPayment);
        sleep(3000);
    }

    @Test
    void creditNegative() {
        InputForm inputForm = new InputForm();
        inputForm.openPage();
        inputForm.setPeriod("-10");
        inputForm.clickCalculateButton();
        String periodError = inputForm.getPeriodError();
        assertEquals("Минимальное значение 1", periodError);
        sleep(3000);
    }

}

