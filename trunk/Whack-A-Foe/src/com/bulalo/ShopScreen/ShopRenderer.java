package com.bulalo.ShopScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.bulalo.GameObjects.Hammers;
import com.bulalo.Helpers.AssetLoader;

public class ShopRenderer {
	private ShopWorld shopWorld = new ShopWorld();
	private ShapeRenderer shapeRenderer;
	
	private OrthographicCamera cam;
	
	private SpriteBatch batcher;
	private static Hammers wood, steel, gold;
	private TextureRegion shopBg;
	private TextureRegion hammer;
	private TextureRegion hammer1;
	private TextureRegion hammer2;
	
	public ShopRenderer(ShopWorld ShopScreen) {
		shopWorld = ShopScreen;
		cam = new OrthographicCamera();
		cam.setToOrtho(true, 160, 256);
		
		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);
		
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
		
		initGameObjects();
		initAssets();
		
	}
	
	private void initAssets(){
		hammer = AssetLoader.hammer;
		hammer1 = AssetLoader.hammer1;
		hammer2 = AssetLoader.hammer2;
		shopBg = AssetLoader.shopBg;
	
	}
	
	private void initGameObjects(){
		wood = shopWorld.getHammer();
		steel = shopWorld.getHammer1();
		gold = shopWorld.getHammer2();
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
		batcher.draw(AssetLoader.shopBg, 0, 0, 160, 256);
		
		
		batcher.enableBlending();
		
		//batcher.draw(AssetsLoader.dummy,
				//UpgradeDummy.getRect()); dummy.getY(), dummy.getWidth(), dummy.getHeight());
		
		batcher.end();
	}
}
