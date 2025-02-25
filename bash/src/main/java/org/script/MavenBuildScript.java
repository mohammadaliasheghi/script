package org.script;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.script.constant.Constant.*;

public class MavenBuildScript {

    public static void build() {
        System.out.println("Starting Maven clean install and compile for all projects...");

        for (String projectPath : PROJECT_PATHS) {
            System.out.println("\nBuilding project: " + projectPath);
            boolean success = mavenCleanInstallCompile(projectPath);
            if (success) {
                System.out.println(ANSI_GREEN + "✅ Build successful for: " + projectPath + ANSI_RESET);
            } else {
                System.out.println(ANSI_RED + "❌ Build failed for: " + projectPath + ANSI_RESET);
            }
        }

        System.out.println("\nAll builds completed.");
    }

    public static boolean mavenCleanInstallCompile(String projectPath) {
        File projectDir = new File(projectPath);
        if (!projectDir.exists() || !projectDir.isDirectory()) {
            System.err.println("Error: Project directory does not exist or is not a directory: " + projectPath);
            return false;
        }

        try {
            // Create the Maven command
            int exitCode = getExitCode(projectDir);
            return exitCode == 0; // Return true if the build was successful
        } catch (IOException | InterruptedException e) {
            System.err.println("Error executing Maven command for project: " + projectPath);
            e.fillInStackTrace();
            return false;
        }
    }

    private static int getExitCode(File projectDir) throws IOException, InterruptedException {
        List<String> command = new ArrayList<>();
        command.add(MAVEN_PATH); // Use the custom Maven executable
        command.add("clean");
        command.add("install");
        command.add("compile");
        command.add("-DskipTests=true");

        // Execute the command
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        processBuilder.directory(projectDir);
        processBuilder.inheritIO(); // Redirect output to the console

        Process process = processBuilder.start();
        return process.waitFor();
    }
}