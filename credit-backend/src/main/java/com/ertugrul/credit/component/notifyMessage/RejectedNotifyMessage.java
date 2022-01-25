package com.ertugrul.credit.component.notifyMessage;

import com.ertugrul.credit.enums.CreditApplicationResult;
import org.springframework.stereotype.Component;

@Component
public class RejectedNotifyMessage implements NotifyMessage {

    @Override
    public String getType() {
        return CreditApplicationResult.REJECTED.getResult();
    }

    @Override
    public String getMessage(String fullName, double limit) {
        StringBuilder notifyMessage = new StringBuilder();
        notifyMessage.append("Dear ").append(fullName).append(", ")
                .append("your credit application has been ")
                .append(this.getType()).append(". ")
                .append("Thank you for your application.");
        return notifyMessage.toString();
    }

}
