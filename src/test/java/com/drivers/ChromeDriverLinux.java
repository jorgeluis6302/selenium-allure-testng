package com.drivers;

public class ChromeDriverLinux implements ChromeDriverOs {
    private String fileName;

    public ChromeDriverLinux(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String getDriverPath() {
        return String.format("%s/%s", System.getProperty("user.dir"), fileName);
    }
}
