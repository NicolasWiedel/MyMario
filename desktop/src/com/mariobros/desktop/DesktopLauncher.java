package com.mariobros.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mariobros.GameConfig;
import com.mariobros.MarioBros;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = (int) GameConfig.WIDTH;
		config.height = (int)GameConfig.HEIGHT;
		config.title = "MyMario v1.0 Prototype";

		new LwjglApplication(new MarioBros(), config);
	}
}
