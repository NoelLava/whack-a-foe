package com.bulalo.Sreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;

public class GameScreen implements Screen{

	public GameScreen(){
		System.out.println("GameScreen Attached");
	}
	
	@Override
	public void render(float delta) {
		// Draws the RGB color 10, 15, 230, at 100% opacity
        Gdx.gl.glClearColor(10/255.0f, 15/255.0f, 230/255.0f, 1f);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
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
