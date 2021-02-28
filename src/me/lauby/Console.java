package me.lauby;

public class Console {

    private static final String WILDCARD = "\\{}";

    private Console() {
    }

    public static void log(final String msg, final Object... args) {
        if (msg == null) {
            System.out.println();
            return;
        }
        if (msg.length() < WILDCARD.length() || args.length == 0) {
            System.out.println(msg);
            return;
        }
        String message = msg;
        for (Object arg : args) {
            message = message.replaceFirst(WILDCARD, arg.toString());
        }
        System.out.println(message);
    }
}
