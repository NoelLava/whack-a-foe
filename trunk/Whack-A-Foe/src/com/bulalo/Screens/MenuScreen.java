package com.bulalo.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.bulalo.MenuWorld.MenuInputHandler;
import com.bulalo.MenuWorld.MenuRenderer;
import com.bulalo.MenuWorld.MenuWorld;
import com.bulalo.whackafoe.WaFGame;

public class MenuScreen implements Screen{

	WaFGame game;
	MenuWorld menu;
	MenuRenderer render;
	private float runTime = 0;

	public MenuScreen(WaFGame game){
		this.game = game;
	}
	
	public MenuScreen(){
		System.out.println("Main Menu initialized");
		menu = new MenuWorld();
		System.out.println("MenuWorld initialized");
		render = new MenuRenderer(menu);
		
		Gdx.input.setInputProcessor(new MenuInputHandler(menu));
	}
	
	@Override
	public void render(float delta) {
		runTime += delta;
		//if (Gdx.input.justTouched()) // use your own criterion here
        //    game.setScreen(game.gameScreen);//runTime += delta;
		menu.update(delta);
		render.render(runTime);
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
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
	}

}
