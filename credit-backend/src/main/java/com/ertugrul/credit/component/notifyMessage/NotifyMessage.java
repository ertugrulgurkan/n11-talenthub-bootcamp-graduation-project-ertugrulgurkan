package com.ertugrul.credit.component.notifyMessage;


public interface NotifyMessage {
    String getType();

    String getMessage(String fullName, double limit);
}
