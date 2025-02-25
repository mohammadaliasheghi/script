package org.script;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.script.constant.Constant.*;

public class RunningScript {

    public static void run() {
        createStopFile();
        for (Map<String, String> map : mapList())
            executingJarFiles(
                    map.keySet().stream().findFirst().orElse(""),
                    map.values().stream().findFirst().orElse("")
            );
    }

    private static void createStopFile() {
        File stopFile = new File(STOP_FILE_PATH);
        try {
            if (!stopFile.exists()) {
                stopFile.createNewFile();
                stopFile.setExecutable(true, false);
                stopFile.setReadable(true, false);
                stopFile.setWritable(true, false);
            }
        } catch (IOException e) {
            System.err.println("Failed to create stop file: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private static void executingJarFiles(String appName, String jarPath) {
        File jarDir = new File(jarPath);
        if (jarDir.exists() && jarDir.isDirectory()) {
            System.out.println(ANSI_GREEN + "Running " + appName + ANSI_RESET);
            File appJar = new File(jarPath + "/app.jar");
            if (!appJar.exists()) {
                File[] jarFiles = jarDir.listFiles((dir, name) -> name.endsWith(".jar"));
                if (jarFiles != null && jarFiles.length > 0) {
                    jarFiles[0].renameTo(appJar);
                }
            }

            if (appJar.exists()) {
                try {
                    // Create a log file for the application
                    File logFile = new File(jarPath + "/" + appName + ".log");
                    long processId = getProcessId(logFile, appJar, jarDir);
                    System.out.println("Process ID: " + processId);
                    // Sleep for 50 seconds to allow the application to start
                    //Thread.sleep(50000);
                    progressbar(logFile);

                    // Add stop command to the list
                    List<String> stopCommands = new ArrayList<>();
                    stopCommands.add("#" + appName);
                    stopCommands.add("kill " + processId);
                    writeStopCommands(stopCommands);

                    // Check if the server is up
                    System.out.println();
                    if (isServerUp(logFile))
                        System.out.println(ANSI_RESET + appName + " is up and running." + ANSI_RESET);
                    else
                        System.out.println(ANSI_RED + appName + " is not up!" + ANSI_RESET);
                } catch (IOException e) {
                    System.err.println("Error starting " + appName + ": " + e.getMessage());
                    e.fillInStackTrace();
                }
            } else {
                System.err.println("No JAR file found for " + appName);
                System.exit(1);
            }
        } else {
            System.err.println(appName + " not found!");
            System.exit(1);
        }
    }

    private static void progressbar(File logFile) {
        int progress = 1;
        while (!isServerUp(logFile)) {
            System.out.print(ANSI_CYAN + "o" + ANSI_RESET);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.fillInStackTrace();
            }
            progress += 1;
            if (progress >= 60) break;
        }
    }

    private static long getProcessId(File logFile, File appJar, File jarDir) throws IOException {
        if (!logFile.exists()) {
            logFile.createNewFile();
        }
        // Start the process and redirect output to the log file
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", appJar.getAbsolutePath());
        processBuilder.directory(jarDir);
        processBuilder.redirectErrorStream(true);
        processBuilder.redirectOutput(logFile);
        Process process = processBuilder.start();
        return process.pid();
    }

    private static boolean isServerUp(File logFile) {
        try {
            // Read the log file to check if the server started successfully
            String logContent = new String(Files.readAllBytes(Paths.get(logFile.getAbsolutePath())));
            return logContent.contains("JVM running"); // Spring Boot success message
        } catch (IOException e) {
            System.err.println("Error reading log file: " + e.getMessage());
            return false;
        }
    }

    private static void writeStopCommands(List<String> commands) {
        try (FileWriter writer = new FileWriter(STOP_FILE_PATH, true)) {
            for (String command : commands)
                writer.write(command + "\n");
        } catch (IOException e) {
            System.err.println("Failed to write stop commands: " + e.getMessage());
        }
    }
}
