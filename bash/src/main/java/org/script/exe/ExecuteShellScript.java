package org.script.exe;

import org.script.constant.Constant;

import java.io.IOException;

import static org.script.constant.Constant.*;

public class ExecuteShellScript {

    public static void executeShellScript(String string, String type) {
        try {
            Process process;
            if (type.equals(SCRIPT_PATH))
                process = Runtime.getRuntime().exec(new String[]{"bash", string});
            else if (type.equals(SCRIPT_COMMAND))
                process = Runtime.getRuntime().exec(string);
            else process = null;

            if (process == null) {
                System.out.println("process code not exist");
                return;
            }

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("✅ " + ANSI_GREEN + "Script executed successfully." + Constant.ANSI_RESET);
            } else {
                System.err.println("❌ Script execution failed with exit code: " + ANSI_RED + exitCode + ANSI_RESET);
            }
        } catch (InterruptedException | IOException e) {
            System.err.println("Error executing script: " + e.getMessage());
            e.fillInStackTrace();
        }
    }
}