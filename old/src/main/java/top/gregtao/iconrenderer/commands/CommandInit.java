package top.gregtao.iconrenderer.commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.QuiltLoader;
import org.quiltmc.qsl.command.api.client.ClientCommandManager;
import top.gregtao.iconrenderer.utils.FileHelper;

import java.io.IOException;
import java.util.List;

public class CommandInit {
    public static void registerCommands() {
        ClientCommandManager.DISPATCHER.register(ClientCommandManager.literal("exporticons")
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
        ClientCommandManager.DISPATCHER.register(ClientCommandManager.literal("exporticons")
                .then(ClientCommandManager.literal("all")
                        .executes((context) -> {
                            List<ModContainer> loadedMods = QuiltLoader.getAllMods().stream().toList();
                            int i;
                            for (i = 0; i < loadedMods.size(); ++i) {
                                try {
                                    new FileHelper(loadedMods.get(i).metadata().id());
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
