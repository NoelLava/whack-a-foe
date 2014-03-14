package com.bulalo.Screens;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.bulalo.ShopWorld.ShopInputHandler;
import com.bulalo.ShopWorld.ShopRenderer;
import com.bulalo.ShopWorld.ShopWorld;
import com.bulalo.UI.Button;
import com.bulalo.whackafoe.WaFGame;

public class ShopScreen implements Screen {

	WaFGame game;
	ShopRenderer renderer;
	private float runTime = 0;
	private ShopWorld shop;
	
	private static List<Button> shopButtons;
	private Button backButton;
	
	float screenWidth;
    float screenHeight;
    float gameWidth;
    float gameHeight;   
	
//	public ShopScreen(WaFGame game){
//		this.game = game;
//	}
//	
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
		
		shopButtons = shop.getShopButtons();
		backButton = shopButtons.get(0);
	}

	@Override
	public void render(float delta) {
		runTime += delta;
		
		if(backButton.isJustPressed()){
			game.setScreen(new MenuScreen(game));
		}
		
		shop.update(delta);
		renderer.render(runTime);
		
	}

	@Override
	public void resize(int width, int height) {
		System.out.println("Resizing");
		
	}

	@Override
	public void show() {
		System.out.println("Show");
		
	}

	@Override
	public void hide() {
		System.out.println("hide");
		
	}

	@Override
	public void pause() {
		System.out.println("pause");
		
	}

	@Override
	public void resume() {
		System.out.println("resume");
		
	}

	@Override
	public void dispose() {
		System.out.println("dispose");
		
	}

}
