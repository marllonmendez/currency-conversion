package currencyConversion.model;

import currencyConversion.record.CurencyRecord;

public class CurrencyModel {
    private double targetValue;
    private double valueConverted;

    public void info() {
        System.out.printf("Conversão: %.2f.\n", this.valueConverted);
    }

    public void coin(CurencyRecord curencyRecord, double baseValue) {
        this.targetValue = curencyRecord.conversion_rate();
        calculator(baseValue);
    }

    public void calculator(double base) {
        this.valueConverted = base * this.targetValue;
        info();
    }
}
