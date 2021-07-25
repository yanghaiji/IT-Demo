package com.javayh.event.enterprise.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.*;
import org.springframework.stereotype.Component;


/**
 * <p>
 * 企业级开发封装
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-07-18
 */
@Component
public class DemoEventPublisher implements InitializingBean, ApplicationContextAware {

    private static DemoEventPublisher publisher;
    private ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() throws Exception {
        DemoEventPublisher.publisher = this;
    }

    /**
     * Set the ApplicationContext that this object runs in.
     * Normally this call will be used to initialize the object.
     * <p>Invoked after population of normal bean properties but before an init callback such
     * as {@link org.springframework.beans.factory.InitializingBean#afterPropertiesSet()}
     * or a custom init-method. Invoked after {@link ResourceLoaderAware#setResourceLoader},
     * {@link ApplicationEventPublisherAware#setApplicationEventPublisher} and
     * {@link MessageSourceAware}, if applicable.
     * @param applicationContext the ApplicationContext object to be used by this object
     * @throws ApplicationContextException in case of context initialization errors
     * @throws BeansException if thrown by application context methods
     * @see org.springframework.beans.factory.BeanInitializationException
     */

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static void publishEvent(DemoEvent demoEvent){
        publisher.applicationContext.publishEvent(demoEvent);
    }

}
