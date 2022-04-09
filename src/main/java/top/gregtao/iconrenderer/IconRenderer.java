package top.gregtao.iconrenderer;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.gregtao.iconrenderer.commands.CommandInit;

public class IconRenderer implements ModInitializer {
	public static Logger logger = LoggerFactory.getLogger("Icon Renderer");

	@Override
	public void onInitialize() {
		CommandInit.registerCommands();
	}
}
