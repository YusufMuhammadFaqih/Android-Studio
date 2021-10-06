package com.FullGaugeLibrary;

import com.FullGaugeLibrary.contract.ValueFormatter;

public class ValueFormatterImpl implements ValueFormatter {
    @Override
    public String getFormattedValue(double value) {
        return String.valueOf(value);
    }
}
