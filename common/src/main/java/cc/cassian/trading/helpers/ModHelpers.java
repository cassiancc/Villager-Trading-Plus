package cc.cassian.trading.helpers;

import cc.cassian.trading.config.ModConfig;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.text.Text;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Consumer;
import java.util.regex.Pattern;

import static cc.cassian.trading.VillagerTrading.MOD_ID;


public class ModHelpers {
    //Shorthand for config.
    public static ModConfig config = ModConfig.get();

    //Check if Cloth Config is installed and its configuration can be used.
    @ExpectPlatform
    public static boolean clothConfigInstalled() {
        throw new AssertionError();
    }



    //Automatically generate translation keys for config options.
    public static Text fieldName(Field field) {
        return Text.translatable("clickthrough.config." + field.getName());
    }


    //Get the current value of a config field.
    @SuppressWarnings("unchecked")
    public static <T> T fieldGet(Object instance, Field field) {
        try {
            return (T) field.get(instance);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    //Set a config field.
    public static <T> Consumer<T> fieldSetter(Object instance, Field field) {
        return t -> {
            try {
                field.set(instance, t);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
