package de.meowlan.ccshenanigans;

import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import dan200.computercraft.api.ComputerCraftAPI;
import de.meowlan.ccshenanigans.computercraft.implementation.peripherals.*;

@Mod(ccshenanigans.MODID)
public class ccshenanigans {
    public static final String MODID = "ccshenanigans";

    private static final Logger LOGGER = LogUtils.getLogger();

    @SuppressWarnings("removal")
    public ccshenanigans() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Hello from CC: Shenanigans!");

        ComputerCraftAPI.registerGenericSource(new BigTelevisionPeripheral());
        ComputerCraftAPI.registerGenericSource(new BoxTelevisionPeripheral());
        ComputerCraftAPI.registerGenericSource(new FramePeripheral());
        ComputerCraftAPI.registerGenericSource(new ProjectorPeripheral());
        ComputerCraftAPI.registerGenericSource(new TelevisionPeripheral());
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
