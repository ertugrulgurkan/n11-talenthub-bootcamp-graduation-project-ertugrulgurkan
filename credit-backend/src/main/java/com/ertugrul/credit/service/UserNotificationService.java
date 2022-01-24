package com.ertugrul.credit.service;

import com.ertugrul.credit.entity.User;

public interface UserNotificationService {
    void notifyUser(User user, String message);
}
