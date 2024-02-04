package com.example.f3.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties (prefix = "fisco.config")
@Data
public class ConfigProperties {
    public String doctorContract;
    public String patientContract;
    public String CasesContract;
    public String peers;
    public String SDKFile;
    public String pemAccountFilePath;
}
