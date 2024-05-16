package vip.piwko.logging;

import vip.piwko.discord.DiscordFacade;

public class Logger {

    public static String formatString(Level level, String str, Object[] args) {
        if (str == null || args == null) {
            throw new IllegalArgumentException("Input string and arguments array cannot be null.");
        }

        StringBuilder result = new StringBuilder();

        result.append(level);
        result.append(':');

        int argIndex = 0;
        int i = 0;

        while (i < str.length()) {
            if (i + 1 < str.length() && str.charAt(i) == '{' && str.charAt(i + 1) == '}') {
                if (argIndex < args.length) {
                    result.append(args[argIndex] != null ? args[argIndex].toString() : "null");
                    argIndex++;
                } else {
                    result.append(" ");  // Replace with empty string if no more arguments
                }
                i += 2;  // Skip past "{}"
            } else {
                result.append(str.charAt(i));
                i++;
            }
        }

        return result.toString();
    }

    public static void log(Level level, String message, Object... parameters) {
        String formattedMessage = formatString(level, message, parameters);
        DiscordFacade.sendMessage(formattedMessage);
    }

}
