package com.bulalo.ShopWorld;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.bulalo.GameObjects.Hammers;
import com.bulalo.Helpers.AssetLoader;
import com.bulalo.UI.Button;

public class ShopRenderer {
	private static ShopWorld shop = new ShopWorld();
	private ShapeRenderer shapeRenderer;
	
	private OrthographicCamera cam;
	
	private SpriteBatch batcher;
	private static Hammers hammer, hammer1, hammer2;
	private TextureRegion ssbg;
	private TextureRegion kahoy;
	private TextureRegion bakal;
	private TextureRegion ginto;
	
	private List<Button> shopButtons;
	
	public ShopRenderer(ShopWorld ShopWorld) {
		shop = ShopWorld;
		this.shopButtons = ShopWorld.getShopButtons();
		
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
		ssbg = AssetLoader.ssBg;
		kahoy = AssetLoader.kahoy;
		bakal = AssetLoader.bakal;
		ginto = AssetLoader.ginto;

	}
	
	private void initGameObjects(){
		hammer = shop.getHammer();
		hammer1 = shop.getHammer1();
		hammer2 = shop.getHammer2();

	}
	
	public void drawBackground(TextureRegion region){
		batcher.draw(region, 0, 0, 160, 256);
	}
	
	public void drawHammer(TextureRegion region, float x, float y, float runTime){
		batcher.draw(region, hammer.getX(), hammer.getY(), hammer.getWidth(),
				hammer.getHeight());
	}
	
	public void drawHammer1(TextureRegion region, float x, float y, float runTime){
		batcher.draw(region, hammer1.getX(), hammer1.getY(), hammer1.getWidth(),
				hammer1.getHeight());
		
	}
	
	public void drawHammer2(TextureRegion region, float x, float y, float runTime){
		batcher.draw(region, hammer2.getX(), hammer2.getY(), hammer2.getWidth(),
				hammer2.getHeight());
	}
	
	private void drawButtons(){
		for(Button button : shopButtons) {
			button.draw(batcher);
        }		
	}
	
	public void render(float runTime) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		shapeRenderer.begin(ShapeType.Filled);
		
		shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
		shapeRenderer.rect(0, 0, 160, 256); 
		
		shapeRenderer.end();
		
		batcher.begin();
		
		batcher.disableBlending();
		
		drawBackground(ssbg);;
		
		batcher.enableBlending();
		
		drawButtons();
		drawHammer(kahoy, 20, 50, runTime);
		drawHammer1(bakal, 100, 50, runTime);
		drawHammer2(ginto, 180, 50, runTime);

		
		batcher.end();
	}
}
