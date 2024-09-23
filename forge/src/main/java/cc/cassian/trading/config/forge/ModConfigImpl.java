package cc.cassian.trading.config.forge;

import cc.cassian.trading.VillagerTrading;
import net.minecraftforge.fml.loading.FMLLoader;

import java.nio.file.Path;


public class ModConfigImpl {
    public static Path configPath() {
        return Path.of(FMLLoader.getGamePath() + "/config").resolve(VillagerTrading.MOD_ID + ".json");
    }
}
