package ro.pub.cs.systems.eim.practicaltest01var04;

public interface Constants {

    final public static String USER_NAME = "userName";
    final public static String GROUP_NAME = "groupName";
    final public static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;
    final public static int SERVICE_STOPPED = 0;
    final public static int SERVICE_STARTED = 1;

    final public static String PROCESSING_THREAD_TAG = "[Processing Thread]";

    final public static String BROADCAST_RECEIVER_EXTRA = "message";
    final public static String BROADCAST_RECEIVER_TAG = "[Message]";

    final public static String[] actionTypes = {
            "ro.pub.cs.systems.eim.practicaltest01var04.name",
            "ro.pub.cs.systems.eim.practicaltest01var04.group",
    };
}
