package me.pokerman99.builderplugin.commands;

import me.pokerman99.builderplugin.Main;
import me.pokerman99.builderplugin.Utils;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;

public class eventkit implements CommandExecutor{

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (Main.eventkit == false) return CommandResult.empty();
        if (Main.executed.contains(src.getIdentifier())) return CommandResult.empty();
        String kit = args.<String>getOne("kit").get();

        switch (kit){
            case "event1":{
                Sponge.getCommandManager().process(Sponge.getServer().getConsole(), "kit give %player% event1".replace("%player%", src.getName()));
                Main.executed.add(src.getIdentifier());
                break;
            }
            case "event2":{
                Sponge.getCommandManager().process(Sponge.getServer().getConsole(), "kit give %player% event2".replace("%player%", src.getName()));
                Main.executed.add(src.getIdentifier());
                break;
            }
            case "event3":{
                Sponge.getCommandManager().process(Sponge.getServer().getConsole(), "kit give %player% event3".replace("%player%", src.getName()));
                Main.executed.add(src.getIdentifier());
                break;
            }
            case "event4":{
                Sponge.getCommandManager().process(Sponge.getServer().getConsole(), "kit give %player% event4".replace("%player%", src.getName()));
                Main.executed.add(src.getIdentifier());
                break;
            }
            case "event5":{
                Sponge.getCommandManager().process(Sponge.getServer().getConsole(), "kit give %player% event5".replace("%player%", src.getName()));
                Main.executed.add(src.getIdentifier());
                break;
            }
            case "event6":{
                Sponge.getCommandManager().process(Sponge.getServer().getConsole(), "kit give %player% event6".replace("%player%", src.getName()));
                Main.executed.add(src.getIdentifier());
                break;
            }
            default:{
                Utils.sendMessage(src, "&cThis kit is not supported!");
                break;
            }
        }
        return CommandResult.success();
    }
}
