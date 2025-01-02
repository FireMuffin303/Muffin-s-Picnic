package net.firemuffin303.omorbasket.forge;

import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.GameRules;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;

public class EnumValue<T extends Enum<T>> extends GameRules.Value<EnumValue<T>> {
    private T value;
    public EnumValue(GameRules.Type<EnumValue<T>> arg) {
        super(arg);
    }

    @Override
    protected void updateFromArgument(CommandContext<CommandSourceStack> commandContext, String string) {

    }

    @Override
    protected void deserialize(String string) {

    }

    @Override
    public String serialize() {
        return this.value.name().toLowerCase(Locale.ROOT);
    }

    @Override
    public int getCommandResult() {
        return this.value.ordinal();
    }

    @Override
    protected EnumValue<T> getSelf() {
        return this;
    }

    @Override
    protected EnumValue<T> copy() {
        return new EnumValue<>(this.type);
    }

    @Override
    public void setFrom(EnumValue<T> arg, @Nullable MinecraftServer minecraftServer) {
        this.value = arg.value;
        this.onChanged(minecraftServer);
    }
}
