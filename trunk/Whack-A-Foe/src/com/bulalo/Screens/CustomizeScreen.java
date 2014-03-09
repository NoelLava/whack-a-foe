package com.bulalo.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.bulalo.CustomizeWorld.CustomWorld;
import com.bulalo.CustomizeWorld.CustomizeRenderer;
import com.bulalo.GameObjects.Tables;
import com.bulalo.Helpers.InputHandler;
import com.bulalo.whackafoe.WaFGame;

public class CustomizeScreen implements Screen {
	WaFGame game;
	CustomizeRenderer renderer;
	private float runTime = 0;
	private CustomWorld custom;
	private Tables table;
	public CustomizeScreen(WaFGame game){
		this.game = game;
	}
	
	public CustomizeScreen(){
		System.out.println("Game Screen Attached");
		custom = new CustomWorld();			//initialize the gameWorld
		renderer = new CustomizeRenderer(custom);  //initialize the gameRenderer
		Gdx.input.setInputProcessor(new InputHandler(custom));
	}

	@Override
	public void render(float delta) {
		runTime += delta;
		custom.update(delta);
		renderer.render(runTime);

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
