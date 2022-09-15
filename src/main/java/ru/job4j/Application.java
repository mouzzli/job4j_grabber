package ru.job4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Application {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new MyTimerTask(), 0, getPeriod(), TimeUnit.SECONDS);
    }

    private static class MyTimerTask implements Runnable {
        public void run() {
            System.out.println("MyTimerTask Run");
        }
    }

    private static int getPeriod() {
        return Integer.parseInt(getProperties().getProperty("period"));
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        try (InputStream in = new FileInputStream("src/main/resources/app.properties")) {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}

