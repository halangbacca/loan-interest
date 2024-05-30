package com.halan.loans.factory;

import com.halan.loans.domain.Customer;

public class CustomerFactory {
    public static Customer build() {
        return new Customer(25, "123.456.798-00", "Name", 5000.00, "SC");
    }

    public static Customer build(int age) {
        return new Customer(age, "123.456.798-00", "Name", 5000.00, "SC");
    }

    public static Customer build(Double income) {
        return new Customer(25, "123.456.798-00", "Name", income, "SC");
    }

    public static Customer build(String location) {
        return new Customer(25, "123.456.798-00", "Name", 5000.00, location);
    }
}
