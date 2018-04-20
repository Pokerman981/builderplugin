package me.pokerman99.builderplugin;

import com.google.inject.Inject;
import me.pokerman99.builderplugin.commands.eventkit;
import me.pokerman99.builderplugin.commands.eventkitenable;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.config.DefaultConfig;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.text.Text;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


@Plugin(id = "builderplugin",
        name = "builderplugin",
        version = "1.0",
        description = "Plugin for Justin's servers providing easter eggs for the players")

public class Main {

        @Inject
        @DefaultConfig(sharedRoot = false)
        private Path defaultConfig;

        @Inject
        @DefaultConfig(sharedRoot = false)
        public ConfigurationLoader<CommentedConfigurationNode> loader;

        @Inject
        @org.spongepowered.api.config.ConfigDir(sharedRoot = false)
        private Path ConfigDir;

        @Inject
        public PluginContainer plugin;

        public PluginContainer getPlugin() {
            return this.plugin;
        }

        public static CommentedConfigurationNode rootNode;

        public static CommentedConfigurationNode config() {
            return rootNode;
        }

        public void save() throws IOException {
            loader.save(config());
        }

        @Inject
        private Logger logger;

        public Logger getLogger() {
            return logger;
        }

        public static Main instance;

        public static Main getInstance() {
            return instance;
        }

        public static boolean eventkit = false;

        public static List<String> executed = new ArrayList<>();

        @Listener
        public void onInit(GameInitializationEvent event) throws IOException {
            rootNode = loader.load();
            instance = this;

            CommandSpec startcommand = CommandSpec.builder()
                    .permission("builderplugin.admin")
                    .executor(new eventkitenable())
                    .build();

            CommandSpec eventkit = CommandSpec.builder()
                    .executor(new eventkit())
                    .arguments(GenericArguments.onlyOne(GenericArguments.string(Text.of("kit"))))
                    .build();

            Sponge.getCommandManager().register(this, startcommand, "eventkitenable");
            Sponge.getCommandManager().register(this, eventkit, "eventkit");

        }



}
