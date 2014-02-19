package com.bulalo.Sreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.bulalo.GameWorld.GameRenderer;
import com.bulalo.GameWorld.GameWorld;

public class GameScreen implements Screen{
	private GameWorld world;
	private GameRenderer renderer;
	
	public GameScreen(){
		System.out.println("GameScreen Attached");
		
		world = new GameWorld();
		renderer = new GameRenderer(world);
	}
	
	@Override
	public void render(float delta) {
		world.update(delta); // GameWorld updates 
		renderer.render(); // GameRenderer renders
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
