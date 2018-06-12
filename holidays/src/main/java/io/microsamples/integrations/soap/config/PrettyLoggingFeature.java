package io.microsamples.integrations.soap.config;

import org.apache.cxf.ext.logging.LoggingFeature;

public class PrettyLoggingFeature extends LoggingFeature {

    public PrettyLoggingFeature(){
        super.setPrettyLogging(true);
    }
}