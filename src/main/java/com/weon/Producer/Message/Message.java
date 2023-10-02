package com.weon.Producer.Message;

import java.time.LocalDate;

public interface Message {
    int getId();
    String getOrigin();
    String getDestination();
    LocalDate getDate();
}