package com.portfolio.util;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

import java.io.IOException;
import java.util.Properties;

public class ConfigurationManager {
    private static final String ENV_PATH = "environment.properties";

    public static Props props() {
        return ConfigFactory.create(Props.class);
    }

    static {
        final Properties props = new Properties();
        try {
            props.load(ClassLoader.getSystemResourceAsStream(ENV_PATH));
            System.setProperty("env", props.getProperty("env"));
        } catch (IOException e) {
            throw new RuntimeException(String.format("File '%s' is absent at system resources", ENV_PATH), e);
        }
    }

    @Config.Sources("classpath:${env}.properties")
    public interface Props extends Config {
        @Key("base.url")
        String baseUrl();

        @Key("base.path")
        String basePath();
    }
}
