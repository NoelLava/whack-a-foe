package com.bulalo.Screens;

import com.badlogic.gdx.Screen;
import com.bulalo.CustomizeWorld.CustomizeRenderer;
import com.bulalo.whackafoe.WaFGame;

public class CustomizeScreen implements Screen {
	WaFGame game;
	CustomizeRenderer renderer;
	private float runTime = 0;
	
	public CustomizeScreen(WaFGame game){
		this.game = game;
	}
	
	public CustomizeScreen(){
		System.out.println("Game Screen Attached");
		
		renderer = new CustomizeRenderer(); // initialize the gameRenderer
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
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
