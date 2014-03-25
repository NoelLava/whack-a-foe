//This class is the very screen of the game which displays the game when play button is pressed
package com.bulalo.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.bulalo.GameWorld.GameRenderer;
import com.bulalo.GameWorld.GameWorld;
import com.bulalo.Helpers.AssetLoader;
import com.bulalo.Helpers.InputHandler;
import com.bulalo.whackafoe.WaFGame;

public class GameScreen implements Screen{
	 
	GameWorld world;
	GameRenderer renderer;
	WaFGame game;
	
	private float runTime = 0;
	
	float screenWidth;
    float screenHeight;
    float gameWidth;
    float gameHeight;   
    
    int seconds;
    
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
		
		seconds = GameWorld.seconds;
	}
	
	@Override
	public void render(float delta) {
		runTime += delta;		
		
		if(world.backToMain == true){
			game.setScreen(new MenuScreen(game));
			this.dispose();
		}
		
		world.update(delta);
		renderer.render(runTime);
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		AssetLoader.beep.play();
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
		AssetLoader.gameStart.stop();
		AssetLoader.gameMusic2.stop();
		AssetLoader.gameOver.stop();
		AssetLoader.buzzer.stop();
	}	
}
