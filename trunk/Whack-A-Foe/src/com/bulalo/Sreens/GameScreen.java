package com.bulalo.Sreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.bulalo.GameWorld.GameRenderer;
import com.bulalo.GameWorld.GameWorld;
import com.bulalo.WaFHelpers.InputHandler;

public class GameScreen implements Screen{
	private GameWorld world;
	private GameRenderer renderer;
	private float runTime = 0;
	
	public GameScreen(){
		float screenWidth = Gdx.graphics.getWidth();
		float screenHeight = Gdx.graphics.getHeight();
		float gameWidth = 136;
		float gameHeight = screenHeight / (screenWidth / gameWidth);
		
		world = new GameWorld();
		renderer = new GameRenderer(world ,(int) gameHeight);
		
		Gdx.input.setInputProcessor(new InputHandler(world.getDummy()));
	}
	
	@Override
	public void render(float delta) {
		runTime += delta;
		world.update(delta); // GameWorld updates 
		renderer.render(runTime); // GameRenderer renders
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
