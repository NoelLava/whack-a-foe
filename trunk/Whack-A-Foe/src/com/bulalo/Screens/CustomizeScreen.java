package com.bulalo.Screens;

import com.badlogic.gdx.Screen;
import com.bulalo.CustomizeWorld.CustomizeRenderer;
import com.bulalo.whackafoe.WaFGame;

public class CustomizeScreen implements Screen{
	WaFGame game;
	CustomizeRenderer renderer;
	private float runTime = 0;
	
	
	public CustomizeScreen(WaFGame game){
		this.game = game;
	}
	
	public CustomizeScreen(){
		System.out.println("Game Screen Attached");
		
		renderer = new CustomizeRenderer();  //initialize the gameRenderer
	}
	
	@Override
	public void render(float delta) {
		runTime += delta;
		renderer.render(runTime);
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
