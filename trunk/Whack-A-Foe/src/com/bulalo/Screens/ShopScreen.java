package com.bulalo.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.bulalo.ShopScreen.ShopRenderer;
import com.bulalo.ShopScreen.ShopWorld;
import com.bulalo.whackafoe.WaFGame;
import com.bulalo.Helpers.InputHandler;

public class ShopScreen implements Screen {

	WaFGame game;
	ShopRenderer renderer;
	private float runTime = 0;
	private ShopWorld world;
	private ShopWorld shop;
	public ShopScreen(WaFGame game){
		this.game = game;
	}
	
	public ShopScreen(){
		System.out.println("ShopScreen Attached");
		world = new ShopWorld();
		renderer = new ShopRenderer(world); 
		Gdx.input.setInputProcessor(new InputHandler(world));
	}

	@Override
	public void render(float delta) {
		runTime += delta;
		world.update(delta);
		renderer.render(runTime);
		
	}

	@Override
	public void resize(int width, int height) {
		System.out.println("Resizing");
		
	}

	@Override
	public void show() {
		System.out.println("Show");
		
	}

	@Override
	public void hide() {
		System.out.println("hide");
		
	}

	@Override
	public void pause() {
		System.out.println("pause");
		
	}

	@Override
	public void resume() {
		System.out.println("resume");
		
	}

	@Override
	public void dispose() {
		System.out.println("dispose");
		
	}

}
