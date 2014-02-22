package com.bulalo.whackafoe;

import com.badlogic.gdx.Game;
import com.bulalo.Screens.GameScreen;
import com.bulalo.Helpers.AssetLoader;

public class WaFGame extends Game {

	@Override
	public void create() {
		System.out.println("Game created");
		AssetLoader.load();
		setScreen(new GameScreen());
	}
	
	@Override
	public void dispose(){
		super.dispose();
		AssetLoader.dispose();
	}
	
}
