package com.bulalo.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.bulalo.GameWorld.MenuRenderer;
import com.bulalo.GameWorld.MenuWorld;
import com.bulalo.whackafoe.WaFGame;

public class MainMenuScreen implements Screen{

	WaFGame game;
	MenuWorld menu;
	MenuRenderer render;
	private float runTime = 0;

	
	public MainMenuScreen(){
		System.out.println("Main Menu initialized");
		menu = new MenuWorld();
		render = new MenuRenderer(menu);
	
		//Gdx.input.setInputProcessor(new InputHandler(menu.getPlayButton()));
		
	}
	
	public MainMenuScreen(WaFGame game){
        this.game = game;
}
	
	@Override
	public void render(float delta) {
		if (Gdx.input.justTouched()) // use your own criterion here
            game.setScreen(game.gameScreen);//runTime += delta;
		//menu.update(delta);
		render.render(runTime);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
