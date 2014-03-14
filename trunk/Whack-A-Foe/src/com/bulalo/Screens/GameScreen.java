//This class is the very screen of the game which displays the game when play button is pressed
package com.bulalo.Screens;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.bulalo.GameWorld.GameRenderer;
import com.bulalo.GameWorld.GameWorld;
import com.bulalo.Helpers.InputHandler;
import com.bulalo.UI.Button;
import com.bulalo.whackafoe.WaFGame;

public class GameScreen implements Screen{
	private static List<Button> gameButtons;
	Button pause;
	
	GameWorld world;
	GameRenderer renderer;
	WaFGame game;
	
	private float runTime = 0;
	
	float screenWidth;
    float screenHeight;
    float gameWidth;
    float gameHeight;   
	
//	public GameScreen(WaFGame game){
//		this.game = game;
//	}
	
	public GameScreen(WaFGame game){
		this.game = game;
		screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
        gameWidth = 160;
        gameHeight = screenHeight / (screenWidth / gameWidth);   
		
        System.out.println("Game Screen Attached");
		
		world = new GameWorld();			//initialize the gameWorld
		renderer = new GameRenderer(world);  //initialize the gameRenderer
		
		Gdx.input.setInputProcessor(new InputHandler(world, screenWidth/gameWidth, screenHeight/gameHeight));
		
		gameButtons = GameWorld.getGameButtons();
		pause = gameButtons.get(0);
		
	}
	
	@Override
	public void render(float delta) {
		runTime += delta;
		
		if(pause.isJustPressed()){
			game.setScreen(new MenuScreen(game));
		}
		
		world.update(delta);
		renderer.render(runTime);
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
