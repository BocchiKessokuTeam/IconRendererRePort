package top.gregtao.iconrenderer.commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import top.gregtao.iconrenderer.utils.FileHelper;

import java.io.IOException;
import java.util.List;

public class CommandInit {
    public static void registerCommands() {
        assert ClientCommandManager.getActiveDispatcher() != null;
        ClientCommandManager.getActiveDispatcher().register(ClientCommandManager.literal("exporticons")
                .then(ClientCommandManager.argument("modid", StringArgumentType.string())
                        .executes((context) -> {
                            String modId = context.getArgument("modid", String.class);
                            try {
                                new FileHelper(modId);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            return 1;
                        })
                )
        );
        ClientCommandManager.getActiveDispatcher().register(ClientCommandManager.literal("exporticons")
                .then(ClientCommandManager.literal("all")
                        .executes((context) -> {
                            List<ModContainer> loadedMods = FabricLoader.getInstance().getAllMods().stream().toList();
                            int i;
                            for (i = 0; i < loadedMods.size(); ++i) {
                                try {
                                    new FileHelper(loadedMods.get(i).getMetadata().getId());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            return 1;
                        })
                )
        );
    }
}
