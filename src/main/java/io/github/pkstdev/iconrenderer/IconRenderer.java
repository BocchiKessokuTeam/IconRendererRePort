package io.github.pkstdev.iconrenderer;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.github.pkstdev.iconrenderer.commands.CommandInit;

public class IconRenderer implements ModInitializer {
	public static final Logger logger = LoggerFactory.getLogger("Icon Renderer");
	@Override
	public void onInitialize(ModContainer mod) {
		CommandInit.registerCommands();
	}
}
