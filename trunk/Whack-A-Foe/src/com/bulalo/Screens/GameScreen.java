//This class is the very screen of the game which displays the game when play button is pressed
package com.bulalo.Screens;

import com.badlogic.gdx.Screen;
import com.bulalo.GameWorld.GameRenderer;
import com.bulalo.GameWorld.GameWorld;

public class GameScreen implements Screen{
	GameWorld world;
	GameRenderer renderer;
	
	public GameScreen(){
		System.out.println("Game Screen Attached");
		
		world = new GameWorld();		//initialize the gameWorld
		renderer = new GameRenderer(world);  //initialize the gameRenderer
	}
	
	@Override
	public void render(float delta) {
		world.update(delta);
		renderer.render();
	}

	@Override
	public void resize(int width, int height) {
		System.out.println("GameScreen - resizing");
	}

	@Override
	public void show() {
		System.out.println("GameScreen - show calleD");
	}

	@Override
	public void hide() {
		System.out.println("GameScreen - hide called");
	}

	@Override
	public void pause() {
		System.out.println("GameScreen - pause called");
	}

	@Override
	public void resume() {
		System.out.println("GameScreen - resume called");
	}

	@Override
	public void dispose() {

	}	
}
