package com.ceam.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.events.SessionCreatedEvent;
import org.springframework.session.events.SessionDeletedEvent;
import org.springframework.session.events.SessionExpiredEvent;

/**
 * 解决Session event listener threw exception 问题
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 120)
public class SpringSessionConfiguration {
    /**
     * Redis内session过期事件监听
     */
    @EventListener
    public void onSessionExpired(SessionExpiredEvent expiredEvent) {
        String sessionId = expiredEvent.getSessionId();
    }


    /**
     * Redis内session删除事件监听
     */
    @EventListener
    public void onSessionDeleted(SessionDeletedEvent deletedEvent) {
        String sessionId = deletedEvent.getSessionId();
    }

    /**
     * Redis内session保存事件监听
     */
    @EventListener
    public void onSessionCreated(SessionCreatedEvent createdEvent) {
        String sessionId = createdEvent.getSessionId();
    }
}

