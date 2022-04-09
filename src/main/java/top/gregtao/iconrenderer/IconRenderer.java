package top.gregtao.iconrenderer;

import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.command.api.client.ClientCommandManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.gregtao.iconrenderer.utils.FileHelper;

import java.io.IOException;

public class IconRenderer implements ModInitializer {
	public static final Logger logger = LoggerFactory.getLogger("Icon Renderer");

	@Override
	public void onInitialize(ModContainer mod) {
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
	}
}
