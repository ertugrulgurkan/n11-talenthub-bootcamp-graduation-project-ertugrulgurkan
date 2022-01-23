package com.ertugrul.credit.service;

import com.ertugrul.credit.entity.User;

public interface UserNotificationService {
    void notifyCustomer(User user, String message);
}
