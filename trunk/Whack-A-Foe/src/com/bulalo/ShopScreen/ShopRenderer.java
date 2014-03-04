package com.bulalo.ShopScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.bulalo.Helpers.AssetsLoader;

public class ShopRenderer {
	private ShopWorld shopWorld;
	private ShapeRenderer shapeRenderer;
	
	private OrthographicCamera cam;
	
	private SpriteBatch batcher;
	
	public ShopRenderer(ShopWorld ShopScreen) {
		shopWorld = ShopScreen;
		
		cam = new OrthographicCamera();
		cam.setToOrtho(true, 160, 256);
		
		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);
		
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
		
	}
	
	public void render(float runTime) {
		//UpgradeDummy dummy = upgradeScreen.getDummy();
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		shapeRenderer.begin(ShapeType.Filled);
		
		shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
		shapeRenderer.rect(0, 0, 160, 256); 
		
		shapeRenderer.end();
		
		batcher.begin();
		
		batcher.disableBlending();
		batcher.draw(AssetsLoader.sbg, 0, 0, 160, 256);
		
		
		batcher.enableBlending();
		
		//batcher.draw(AssetsLoader.dummy,
				//UpgradeDummy.getRect()); dummy.getY(), dummy.getWidth(), dummy.getHeight());
		
		batcher.end();
	}
}