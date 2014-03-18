package com.bulalo.Screens;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.bulalo.GameObjects.Hammers;
import com.bulalo.Helpers.AssetLoader;
import com.bulalo.ShopWorld.ShopInputHandler;
import com.bulalo.ShopWorld.ShopRenderer;
import com.bulalo.ShopWorld.ShopWorld;
import com.bulalo.UI.Button;
import com.bulalo.whackafoe.WaFGame;

public class ShopScreen implements Screen {

	WaFGame game;
	ShopRenderer renderer;
	private String pamalo = "";
	private float runTime = 0;
	private ShopWorld shop;
	private Hammers hammer;
	 
	private static List<Button> shopButtons;
	private Button backButton;
	
	float screenWidth;
    float screenHeight;
    float gameWidth;
    float gameHeight;   
	
//	public ShopScreen(WaFGame game){
//		this.game = game;
//	}
    
	public ShopScreen(WaFGame game){
		this.game = game;
		screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
        gameWidth = 160;
        gameHeight = screenHeight / (screenWidth / gameWidth); 
        
		System.out.println("ShopScreen Attached");
		shop = new ShopWorld();
		renderer = new ShopRenderer(shop); 
		Gdx.input.setInputProcessor(new ShopInputHandler(shop, screenWidth/gameWidth, screenHeight/gameHeight));
		
		shopButtons = ShopWorld.getShopButtons();
		backButton = shopButtons.get(0);
	}

	@Override
	public void render(float delta) {
		runTime += delta;
		
		if(backButton.isJustPressed()){
			game.setScreen(new MenuScreen(game));
			this.dispose();
		}
		
		shop.update(delta);
		renderer.render(runTime);
		
	}
	
	public String getHammer(){
		return pamalo;
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		AssetLoader.gameMusic.play();
		AssetLoader.gameMusic.setLooping(true);
	}

	@Override
	public void hide() {	
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {	
	}

	@Override
	public void dispose() {
		AssetLoader.gameMusic.stop();
	}

}
