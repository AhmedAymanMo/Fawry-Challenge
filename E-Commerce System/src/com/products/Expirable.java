package com.products;

import java.time.LocalDate;

public interface Expirable
{
    String getName();
    LocalDate getExpireDate();
    boolean isExpired();
}
