package com.drivers;

import java.util.HashMap;

public class ChromeDriverDirector {
    private String driverOs;
    private HashMap<String, ChromeDriverOs> configuration;

    public ChromeDriverDirector(String driverOs) {
        this.driverOs = driverOs;
        this.configuration = new HashMap<>();
        this.configure();
    }

    public void configure() {
        configuration.put("mac", new ChromeDriverMac("chromedriver"));
        configuration.put("windows", new ChromeDriverWindows("chromedriver.exe"));
        configuration.put("linux", new ChromeDriverLinux("chromedriver"));
    }

    public String pick() {
        return configuration.get(this.driverOs).getDriverPath();
    }
}
