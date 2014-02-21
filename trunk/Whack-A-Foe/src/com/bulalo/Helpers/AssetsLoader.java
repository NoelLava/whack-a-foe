package com.bulalo.Helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetsLoader {
	public static Texture texture;
	public static TextureRegion bg;
	public static TextureRegion dummy;
	
	public static void load(){
		texture = new Texture(Gdx.files.internal("data/texture.png"));
		texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		bg = new TextureRegion(texture, 0, 0, 64, 103);
		bg.flip(false, true);
		dummy = new TextureRegion(texture, 60, 0, 14, 29);
		dummy.flip(false, true);
	}
	
	public static void dispose() {
		texture.dispose();
	}
}
