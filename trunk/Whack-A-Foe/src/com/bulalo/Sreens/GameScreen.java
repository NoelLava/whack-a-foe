package com.bulalo.Sreens;

import com.badlogic.gdx.Screen;

public class GameScreen implements Screen{

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		System.out.println("Game Screen - resize");
	}

	@Override
	public void show() {
		System.out.println("Game Screen - show");
	}

	@Override
	public void hide() {
		System.out.println("Game Screen - hide");
	}

	@Override
	public void pause() {
		System.out.println("Game Screen - pause");
	}

	@Override
	public void resume() {
		System.out.println("Game Screen - resume");	
	}

	@Override
	public void dispose() {
		System.out.println("Game Screen - dispose");
	}

}
