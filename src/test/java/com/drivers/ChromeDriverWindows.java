package com.drivers;

public class ChromeDriverWindows implements ChromeDriverOs {
    private String fileName;

    public ChromeDriverWindows(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String getDriverPath() {
        return String.format("%s/%s", System.getProperty("user.dir"), fileName);
    }
}
