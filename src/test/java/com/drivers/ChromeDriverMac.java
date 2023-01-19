package com.drivers;

public class ChromeDriverMac implements ChromeDriverOs {
    private String fileName;
    public ChromeDriverMac(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String getDriverPath() {
        return String.format("%s/%s", System.getProperty("user.dir"), fileName);
    }
}
