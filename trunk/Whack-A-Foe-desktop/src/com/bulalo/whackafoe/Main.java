package com.bulalo.whackafoe;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Whack-A-Foe";
		cfg.useGL20 = false;
		cfg.width = 272;
		cfg.height = 434;
		
		new LwjglApplication(new WaFGame(), cfg);
	}
}
