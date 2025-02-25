package org.script;

import org.script.constant.Constant;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.script.constant.Constant.*;
import static org.script.exe.ExecuteShellScript.executeShellScript;

public class StoppedScript {

    public static void stop() {
        Map<String, String> serverCommands = new HashMap<>();
        try {
            InputStream is = new FileInputStream(Constant.STOP_FILE_PATH);
            try (Scanner sc = new Scanner(is, StandardCharsets.UTF_8)) {
                String line;
                while (sc.hasNextLine()) {
                    line = sc.nextLine();
                    if (line != null && line.startsWith("#")) {
                        serverCommands.put(line, sc.nextLine());
                        System.out.println(ANSI_CYAN + line + ANSI_RESET);
                    }
                }
                serverCommands.put("#all", "0");
                System.out.println(ANSI_RED + "#all" + ANSI_RESET + " -> " + ANSI_RESET + "All Server Is Down!" + ANSI_RESET);
                Scanner userInputScanner = new Scanner(System.in);
                System.out.print("Please Enter Server Code To Stopped:");
                String userInput = userInputScanner.nextLine();
                if (userInput == null || userInput.isEmpty()) {
                    System.out.println(ANSI_RED + "input is empty" + ANSI_RESET);
                    return;
                }

                if (!userInput.startsWith("#"))
                    userInput = "#" + userInput;

                if (userInput.equals("#all")) {
                    executeShellScript(STOP_FILE_PATH, SCRIPT_PATH);
                    clearFile("0", "0");
                } else {
                    String command = serverCommands.get(userInput);
                    if (command == null || command.isEmpty()) {
                        System.out.println(ANSI_RED + "server not found" + ANSI_RESET);
                        return;
                    }
                    executeShellScript(command, SCRIPT_COMMAND);
                    clearFile(userInput, command);
                }
            }
        } catch (FileNotFoundException e) {
            e.fillInStackTrace();
            System.out.println(e.getMessage());
        }
    }

    private static void clearFile(String command, String serverCommand) {
        Path path = Paths.get(STOP_FILE_PATH);
        if (command.equals("0") && serverCommand.equals("0")) {
            try {
                Files.write(path, new byte[0]);
                System.out.println(ANSI_CYAN + "File cleared successfully." + ANSI_RESET);
            } catch (IOException e) {
                System.err.println(ANSI_RED + "An error occurred: " + e.getMessage() + ANSI_RESET);
            }
        } else {
            try {
                List<String> lines = Files.readAllLines(path);
                List<String> updatedLines = lines.stream()
                        .filter(line -> !line.equals(command) && !line.equals(serverCommand))
                        .toList();
                Files.write(path, updatedLines);
                System.out.println(ANSI_CYAN + "Line removed successfully." + ANSI_RESET);
            } catch (IOException e) {
                System.err.println("An error occurred: " + e.getMessage());
            }
        }
    }
}
