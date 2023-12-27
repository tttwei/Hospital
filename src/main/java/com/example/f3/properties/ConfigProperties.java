package com.example.f3.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties (prefix = "fisco.config")
@Data
public class ConfigProperties {
    public static String doctorContract;
    public static String patientContract;
    public static String CasesContract;
    public static String peers;
    public static String SDKFile;
    public static String pemAccountFilePath;


}
