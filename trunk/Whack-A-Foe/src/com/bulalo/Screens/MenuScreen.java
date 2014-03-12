package com.bulalo.Screens;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.bulalo.MenuWorld.MenuInputHandler;
import com.bulalo.MenuWorld.MenuRenderer;
import com.bulalo.MenuWorld.MenuWorld;
import com.bulalo.UI.Button;
import com.bulalo.whackafoe.WaFGame;

public class MenuScreen implements Screen {

	WaFGame game;
	MenuWorld menu;
	MenuRenderer render;
	private float runTime = 0;

	private static List<Button> menuButtons;

	private Button playButton;
	private Button shopButton;
	private Button customButton;

//	public MenuScreen(WaFGame game) {
//		this.game = game;
//	}

	public MenuScreen(WaFGame game) {
		this.game = game;
		System.out.println("Main Menu initialized");
		menu = new MenuWorld();
		System.out.println("MenuWorld initialized");
		render = new MenuRenderer(menu);

		Gdx.input.setInputProcessor(new MenuInputHandler(menu));
		
		menuButtons = MenuWorld.getMenuButtons();
		playButton = menuButtons.get(0);
		shopButton = menuButtons.get(1);
		customButton = menuButtons.get(2);
		
	}

	@Override
	public void render(float delta) {
		runTime += delta;
		// if (Gdx.input.justTouched()) // use your own criterion here
		// game.setScreen(game.gameScreen);
		
		if(playButton.isJustPressed()){
			game.setScreen(new GameScreen());
		}else if(shopButton.isJustPressed()){
			
		}else if(customButton.isJustPressed()){
			game.setScreen(new CustomizeScreen());
		}
	
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
