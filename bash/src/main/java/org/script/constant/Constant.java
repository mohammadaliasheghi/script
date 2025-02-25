package org.script.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Constant {

    //METHOD
    public static final String ONE = "1";
    public static final String TWO = "2";
    public static final String THREE = "3";

    //PATHS
    public static final String HOME_PATH = System.getProperty("user.home");
    public static final String STOP_FILE_PATH = "./.stop.sh";
    public static final String MAVEN_PATH = "/opt/maven/bin/mvn";

    // ANSI escape codes for colored output
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";

    // List of project paths to build
    public static final List<String> PROJECT_PATHS = List.of(
            HOME_PATH + "/workspace/backend/framework/",
            HOME_PATH + "/workspace/backend/cloud-platform/eureka-server/",
            HOME_PATH + "/workspace/backend/cloud-platform/common-lib/",
            HOME_PATH + "/workspace/backend/cloud-platform/log-lib/",
            HOME_PATH + "/workspace/backend/cloud-platform/security-lib/",
            HOME_PATH + "/workspace/backend/cloud-platform/cache-service/",
            HOME_PATH + "/workspace/backend/cloud-platform/oauth-server/",
            HOME_PATH + "/workspace/backend/cloud-platform/user-service/",
            HOME_PATH + "/workspace/backend/cloud-platform/gateway/",
            HOME_PATH + "/workspace/backend/generalServiceBackend/",
            HOME_PATH + "/workspace/backend/storeroomBackend/",
            HOME_PATH + "/workspace/backend/contractsBackend/",
            HOME_PATH + "/workspace/backend/customerServiceBackend/",
            HOME_PATH + "/workspace/backend/orderingServiceBackend/"
    );

    // List of project paths to run
    public static List<Map<String, String>> mapList() {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("eureka-server", HOME_PATH + "/workspace/backend/cloud-platform/eureka-server/target");
        list.add(map);
        map = new HashMap<>();
        map.put("cache-server", HOME_PATH + "/workspace/backend/cloud-platform/cache-service/target");
        list.add(map);
        map = new HashMap<>();
        map.put("oauth-server", HOME_PATH + "/workspace/backend/cloud-platform/oauth-server/target");
        list.add(map);
        map = new HashMap<>();
        map.put("user-server", HOME_PATH + "/workspace/backend/cloud-platform/user-service/target");
        list.add(map);
        map = new HashMap<>();
        map.put("gateway-server", HOME_PATH + "/workspace/backend/cloud-platform/gateway/target");
        list.add(map);
        map = new HashMap<>();
        map.put("general-server", HOME_PATH + "/workspace/backend/generalServiceBackend/target");
        list.add(map);
        map = new HashMap<>();
        map.put("storeroom-server", HOME_PATH + "/workspace/backend/storeroomBackend/target");
        list.add(map);
        return list;
    }

    //COMMAND TYPE
    public static final String SCRIPT_PATH = "SCRIPT_PATH";
    public static final String SCRIPT_COMMAND = "SCRIPT_COMMAND";
}
