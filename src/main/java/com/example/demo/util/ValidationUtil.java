package com.example.demo.util;

public class ValidationUtil {

    public static boolean isValidEmail(String email) {
        return email != null && email.contains("@");
    }

    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("\\d{10}");
    }

    public static boolean isValidString(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
