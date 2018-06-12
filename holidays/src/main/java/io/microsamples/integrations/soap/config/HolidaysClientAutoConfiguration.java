package io.microsamples.integrations.soap.config;

import com.holidaywebservice.holidayservice_v2.HolidayService2Soap;
import org.apache.cxf.ext.logging.LoggingInInterceptor;
import org.apache.cxf.ext.logging.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@EnableConfigurationProperties(HolidaysClientProperties.class)
@ConditionalOnClass(HolidayService2Soap.class)
@Configuration
public class HolidaysClientAutoConfiguration {

    @Bean(name = "holidayServiceProxy")
    public HolidayService2Soap holidayService2Proxy(HolidaysClientProperties holidaysClientProperties) {

        JaxWsProxyFactoryBean jaxWsProxyFactoryBean =
                new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(HolidayService2Soap.class);
        jaxWsProxyFactoryBean.setAddress(holidaysClientProperties.getServiceAddress());

        jaxWsProxyFactoryBean.getOutInterceptors()
                .add(new LoggingOutInterceptor());

        jaxWsProxyFactoryBean.getOutInterceptors()
                .add(new SoapActionInterceptor());

        jaxWsProxyFactoryBean.getInInterceptors()
                .add(new LoggingInInterceptor());

        jaxWsProxyFactoryBean.setFeatures(Arrays.asList(new PrettyLoggingFeature()));

        return (HolidayService2Soap) jaxWsProxyFactoryBean.create();
    }
}
