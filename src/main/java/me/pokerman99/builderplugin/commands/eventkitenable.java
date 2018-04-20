package me.pokerman99.builderplugin.commands;

import me.pokerman99.builderplugin.Main;
import me.pokerman99.builderplugin.Utils;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;

public class eventkitenable implements CommandExecutor{

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (Main.eventkit){
            Main.eventkit = false;
            Main.executed.clear();
            Utils.sendMessage(src, "&aSuccessfully disabled the eventkits!");
        } else {
            Main.eventkit = true;
            Utils.sendMessage(src, "&aSuccessfully enabled the eventkits!");
            Utils.sendMessage(src, "&4&lYOU MUST DISABLE THIS ONCE YOU ARE DONE!");
        }
        return CommandResult.success();
    }
}
