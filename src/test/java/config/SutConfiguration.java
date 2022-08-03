package config;

import java.io.IOException;
import java.util.Properties;

public class SutConfiguration {

    private static final Properties PROPS = new Properties();

    public static Properties getProps() {
        if (PROPS.isEmpty()) {
            readProps();
        }
        return PROPS;
    }

    private static void readProps() {
        try {
            ClassLoader classLoader = SutConfiguration.class.getClassLoader();
            String environment = System.getProperty("env.code");

            if (null == environment) {
                environment = "DEV";
            }

            switch (environment) {
                case "TEST":
                    PROPS.load(classLoader.getResourceAsStream("sut-properties/application-test.properties"));
                case "UAT":
                    PROPS.load(classLoader.getResourceAsStream("sut-properties/application-uat.properties"));
                default:
                    PROPS.load(classLoader.getResourceAsStream("sut-properties/application-dev.properties"));

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
