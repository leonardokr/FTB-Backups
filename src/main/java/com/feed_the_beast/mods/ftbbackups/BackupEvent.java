package com.feed_the_beast.mods.ftbbackups;

import net.minecraftforge.fml.common.eventhandler.Event;

import javax.annotation.Nullable;
import java.io.File;
import java.util.function.Consumer;

/**
 * @author LatvianModder
 */
public class BackupEvent extends Event
{
	public static class Pre extends BackupEvent
	{
		private final Consumer<File> callback;

		public Pre(Consumer<File> c)
		{
			callback = c;
		}

		public void add(File file)
		{
			callback.accept(file);
		}
	}

	public static class Post extends BackupEvent
	{
		private final Backup backup;
		private final Exception error;

		public Post(Backup b, @Nullable Exception ex)
		{
			backup = b;
			error = ex;
		}

		public Backup getBackup()
		{
			return backup;
		}

		@Nullable
		public Exception getError()
		{
			return error;
		}
	}
}