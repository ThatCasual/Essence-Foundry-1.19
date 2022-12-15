package net.thatcasual.essencefoundry.screen;

import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlers {

    public static ScreenHandlerType<ExtractorScreenHandler> EXTRACTOR_SCREEN_HANDLER;

    public static void registerScreenHandlers(){
        EXTRACTOR_SCREEN_HANDLER = new ScreenHandlerType<>(ExtractorScreenHandler::new);
    }

}
