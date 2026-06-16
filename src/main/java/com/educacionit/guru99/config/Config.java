package com.educacionit.guru99.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Config {

    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream input = Config.class.getClassLoader()
                .getResourceAsStream("config/config.properties")) {
            if (input == null) {
                throw new IllegalStateException("No se encontró config/config.properties");
            }
            PROPERTIES.load(input);
        } catch (IOException e) {
            throw new IllegalStateException("Error al cargar configuración", e);
        }
    }

    private Config() {
    }

    public static String getBaseUrl() {
        return PROPERTIES.getProperty("base.url");
    }

    public static String getRegisterUrl() {
        return PROPERTIES.getProperty("register.url");
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(PROPERTIES.getProperty("headless", "false"));
    }

    public static int getImplicitWaitSeconds() {
        return Integer.parseInt(PROPERTIES.getProperty("implicit.wait.seconds", "10"));
    }
}
