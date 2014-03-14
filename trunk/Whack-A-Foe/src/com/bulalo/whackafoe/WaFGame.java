package com.bulalo.whackafoe;

import com.badlogic.gdx.Game;
import com.bulalo.Helpers.AssetLoader;
import com.bulalo.Screens.CustomizeScreen;
import com.bulalo.Screens.GameScreen;
import com.bulalo.Screens.MenuScreen;
import com.bulalo.Screens.ShopScreen;

public class WaFGame extends Game {

	public MenuScreen mainMenu;
	public GameScreen gameScreen;
	public CustomizeScreen customizeScreen;
	public ShopScreen shopScreen;
	Game game;
	
	@Override
	public void create() {
		System.out.println("Game created");

		game = this;
		//mainMenu = new MenuScreen(this);
		gameScreen = new GameScreen();
		customizeScreen = new CustomizeScreen(this);
		shopScreen = new ShopScreen(this);
		AssetLoader.load();
		setScreen(new MenuScreen(this));

	}
	
//	@Override
//	public void render(){
//		//super.render();
//	}
	
	@Override
	public void dispose(){
		super.dispose();
		AssetLoader.dispose();
	}
	
}
