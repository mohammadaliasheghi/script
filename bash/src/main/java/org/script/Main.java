package org.script;

import java.util.Scanner;

import static org.script.MavenBuildScript.build;
import static org.script.RunningScript.run;
import static org.script.StoppedScript.stop;
import static org.script.constant.Constant.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                choose the method number\s
                 (1) -> Building\s
                 (2) -> Running\s
                 (3) -> Stopped:""");
        String input = scanner.nextLine();

        switch (input) {
            case ONE -> build();
            case TWO -> run();
            case THREE -> stop();
            default -> System.out.println("Invalid input");
        }
    }
}