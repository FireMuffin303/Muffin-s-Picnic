package net.firemuffin303.omorbasket.forge.gamerule;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.GameRules;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;

public class EnumValue<T extends Enum<T>> extends GameRules.Value<EnumValue<T>> {
    private final Class<T> classType;
    private T value;
    public EnumValue(GameRules.Type<EnumValue<T>> arg,T value) {
        super(arg);
        this.classType = value.getDeclaringClass();
        this.value = value;
    }

    /*
    public static <T extends Enum<T>> GameRules.Type<EnumValue<T>> create(T value){
        return create(value,(minecraftServer, tEnumValue) -> {});
    }


    public static <T extends Enum<T>> GameRules.Type<EnumValue<T>> create(T value, BiConsumer<MinecraftServer,EnumValue<T>> consumer){
        return new GameRules.Type<>(StringArgumentType::string, (enumValueType) -> {
            return new EnumValue<>(enumValueType,Enum.valueOf(enumValueType.createRule().classType,value.name()));
        },consumer);
    }

     */

    @Override
    protected void updateFromArgument(CommandContext<CommandSourceStack> commandContext, String string) {
        this.value = Enum.valueOf(this.classType,StringArgumentType.getString(commandContext,string));
    }

    @Override
    protected void deserialize(String string) {
        this.value = Enum.valueOf(this.classType,string);
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
        return new EnumValue<>(this.type,this.value);
    }

    @Override
    public void setFrom(EnumValue<T> arg, @Nullable MinecraftServer minecraftServer) {
        this.value = arg.value;
        this.onChanged(minecraftServer);
    }
}
