package com.bulalo.whackafoe;

import com.badlogic.gdx.Game;
import com.bulalo.Screens.GameScreen;
import com.bulalo.Screens.MainMenuScreen;
import com.bulalo.Helpers.AssetLoader;

public class WaFGame extends Game {

	@Override
	public void create() {
		System.out.println("Game created");
		AssetLoader.load();
		setScreen(new MainMenuScreen());
	}
	
	@Override
	public void dispose(){
		super.dispose();
		AssetLoader.dispose();
	}
	
}
