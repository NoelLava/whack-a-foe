package com.bulalo.WaFHelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
	public static Texture texture;
	public static TextureRegion table, dummy;

	 public static void load() {

	        texture = new Texture(Gdx.files.internal("data/texture1.png"));
	        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

	        table = new TextureRegion(texture, 0, 0, 65, 104);
	        table.flip(false, true);

	        dummy = new TextureRegion(texture, 65, 0, 14, 29);
	        //dummy.flip(false, true);

	        //TextureRegion[] birds = { birdDown, bird, birdUp };
	        //birdAnimation = new Animation(0.06f, birds);
	        //birdAnimation.setPlayMode(Animation.LOOP_PINGPONG);

	        //skullUp = new TextureRegion(texture, 192, 0, 24, 14);
	        // Create by flipping existing skullUp
	        //skullDown = new TextureRegion(skullUp);
	        //skullDown.flip(false, true);
	    }
	    
	    public static void dispose() {
	        // We must dispose of the texture when we are finished.
	        texture.dispose();
	    }
	
}
