package currencyConversion.model;

import currencyConversion.record.CurencyRecord;

public class CurrencyModel {
    private double targetValue;
    private double valueConverted;

    public void info() {
        System.out.printf("Converted value: %.2f.\n", this.valueConverted);
    }

    public void coin(CurencyRecord coinApi, double baseValue) {
        this.targetValue = coinApi.conversion_rate();
        calculator(baseValue);
    }

    public void calculator(double base) {
        this.valueConverted = base * this.targetValue;
        info();
    }
}
