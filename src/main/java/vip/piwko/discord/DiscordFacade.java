package vip.piwko.discord;

import discord4j.core.DiscordClient;

public class DiscordFacade {

    private static DiscordFacade INSTANCE = null;

    private DiscordClient client;

    private DiscordFacade() {
        this.client = DiscordClient.create(DiscordConfig.get().getToken());
    }

    public static DiscordFacade get() {
        if (INSTANCE == null) {
            INSTANCE = new DiscordFacade();
        }
        return INSTANCE;
    }

    public void sendMessage(String message) {
        this.client.
    }

}
