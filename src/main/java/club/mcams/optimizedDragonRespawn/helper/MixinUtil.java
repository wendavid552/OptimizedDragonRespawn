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

import club.mcams.optimizedDragonRespawn.OptimizedDragonRespawn;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.BaseText;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.MixinEnvironment;

public class MixinUtil
{
	public static boolean audit(@Nullable ServerCommandSource source)
	{
		boolean ok;
		BaseText response;
		try
		{
			MixinEnvironment.getCurrentEnvironment().audit();
			response = Messenger.s("Mixin environment audited successfully");
			ok = true;
		}
		catch (Exception e)
		{
			OptimizedDragonRespawn.LOGGER.error("Error when auditing mixin", e);
			response = Messenger.s(String.format("Mixin environment auditing failed, check console for more information (%s)", e));
			ok = false;
		}
		if (source != null)
		{
			Messenger.tell(source, response);
		}
		return ok;
	}
}
