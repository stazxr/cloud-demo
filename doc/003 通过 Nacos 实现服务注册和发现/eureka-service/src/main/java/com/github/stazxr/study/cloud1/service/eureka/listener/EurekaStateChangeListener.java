package com.github.stazxr.study.cloud1.service.eureka.listener;

import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EurekaStateChangeListener {
    @EventListener
    public void listen(EurekaInstanceCanceledEvent eurekaInstanceCanceledEvent) {
        String appName = eurekaInstanceCanceledEvent.getAppName();
        String serverId = eurekaInstanceCanceledEvent.getServerId();
        log.info("EurekaInstanceCanceledEvent, appName={}, serverId={}", appName, serverId);
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        log.info("EurekaInstanceRegisteredEvent, instanceInfo={}", instanceInfo);
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        String appName = event.getAppName();
        String serverId = event.getServerId();
        log.info("EurekaInstanceRenewedEvent, appName={}, serverId={}", appName, serverId);
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        Object source = event.getSource();
        log.info("EurekaRegistryAvailableEvent, source={}", source);
    }

    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        Object source = event.getSource();
        log.info("EurekaServerStartedEvent, source={}", source);
    }
}
