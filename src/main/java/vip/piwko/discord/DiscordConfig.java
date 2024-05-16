package vip.piwko.discord;

public class DiscordConfig {

    private static DiscordConfig INSTANCE = null;

    private String token;

    private DiscordConfig() {}

    public static DiscordConfig get() {
        if (INSTANCE == null) {
            INSTANCE = new DiscordConfig();
        }
        return INSTANCE;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
