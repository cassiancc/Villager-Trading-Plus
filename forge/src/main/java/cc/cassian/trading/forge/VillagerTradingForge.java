package cc.cassian.trading.forge;

import cc.cassian.trading.VillagerTrading;
import cc.cassian.trading.config.forge.ModConfigFactory;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;


@Mod(VillagerTrading.MOD_ID)
public final class VillagerTradingForge {
    public VillagerTradingForge() {
        // Run our common setup.
        VillagerTrading.init();
        registerModsPage();


    }

    //Integrate Cloth Config screen (if mod present) with Forge mod menu.
    public void registerModsPage() {
        ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () -> new ConfigScreenHandler.ConfigScreenFactory(ModConfigFactory::createScreen));
    }

}
