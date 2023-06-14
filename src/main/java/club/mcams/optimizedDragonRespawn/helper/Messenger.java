/*
 * This file is part of the optimizedDragonRespawn project, licensed under the
 * GNU Lesser General Public License v3.0
 *
 * Copyright (C) 2023  Fallen_Breath and contributors
 *
 * optimizedDragonRespawn is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * optimizedDragonRespawn is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with optimizedDragonRespawn.  If not, see <https://www.gnu.org/licenses/>.
 */

package club.mcams.optimizedDragonRespawn.helper;
//#if MC >= 11600 && MC < 11900
//$$ import net.minecraft.util.Util;
//#endif
//#if MC >= 11900
//$$ import net.minecraft.text.Text;
//#endif

import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;
import net.minecraft.text.BaseText;

public final class Messenger {
    // Simple Text
    public static BaseText s(Object text) {
        return
                //#if MC >= 11900
                //$$ Text.literal
                //#else
                new LiteralText
                        //#endif
                        (text.toString());
    }

    private static void __tell(ServerCommandSource source, BaseText text, boolean broadcastToOps) {
        source.sendFeedback(
                //#if MC >= 12000
                //$$ () ->
                //#endif
                text, broadcastToOps
        );
    }

    public static void tell(ServerCommandSource source, BaseText text, boolean broadcastToOps)
    {
        __tell(source, text, broadcastToOps);
    }

    public static void tell(ServerCommandSource source, BaseText text) {
        tell(source, text, false);
    }
}