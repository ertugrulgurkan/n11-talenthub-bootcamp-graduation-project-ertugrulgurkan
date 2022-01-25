package com.ertugrul.credit.factory;

import com.ertugrul.credit.component.notifyMessage.NotifyMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NotifyMessageFactory {
    private final List<NotifyMessage> notifyMessages;
    private static final Map<String, NotifyMessage> notifyMessageCache = new HashMap<>();

    public NotifyMessageFactory(List<NotifyMessage> notifyMessages) {
        this.notifyMessages = notifyMessages;
    }

    @PostConstruct
    public void initNotifyMessageCache() {
        for (NotifyMessage message : notifyMessages) {
            notifyMessageCache.put(message.getType(), message);
        }
    }

    public static NotifyMessage getNotifyMessage(String type) {
        NotifyMessage service = notifyMessageCache.get(type);
        if (service == null) throw new RuntimeException("Unknown notify message type: " + type);
        return service;

    }
}
