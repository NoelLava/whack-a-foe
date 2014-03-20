package com.bulalo.Screens;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.bulalo.CustomizeWorld.CustomInputHandler;
import com.bulalo.CustomizeWorld.CustomWorld;
import com.bulalo.CustomizeWorld.CustomizeRenderer;
import com.bulalo.GameObjects.Tables;
import com.bulalo.GameWorld.GameWorld;
import com.bulalo.Helpers.AssetLoader;
import com.bulalo.UI.Button;
import com.bulalo.whackafoe.WaFGame;
 
public class CustomizeScreen implements Screen {
	WaFGame game;
	CustomizeRenderer renderer;
	private String background = "";
	private float runTime = 0;
	private CustomWorld custom;
	private Tables table;
	private GameWorld world;
	
	private static List<Button> customButtons;
	private Button backButton;
	
	float screenWidth;
    float screenHeight;
    float gameWidth;
    float gameHeight;   

	
//	public CustomizeScreen(WaFGame game){
//		this.game = game;
//	}
	
	public CustomizeScreen(WaFGame game){
		this.game = game;
		screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
        gameWidth = 160;
        gameHeight = screenHeight / (screenWidth / gameWidth);
		
		System.out.println("Custom Screen Attached");
		custom = new CustomWorld();			//initialize the gameWorld
		renderer = new CustomizeRenderer(custom);  //initialize the gameRenderer
		Gdx.input.setInputProcessor(new CustomInputHandler(custom, screenWidth/gameWidth, screenHeight/gameHeight));
		
		customButtons = CustomWorld.getCustomButtons();
		backButton = customButtons.get(0);
	}

	@Override
	public void render(float delta) {
		runTime += delta;
		
		if(backButton.isJustPressed()){
			game.setScreen(new MenuScreen(game));
			this.dispose();
		}
		
		custom.update(delta);
		renderer.render(runTime);

	}
	
	public String getBackground(){
		return background;
	}

	@Override
	public void resize(int width, int height) {	
	}

	@Override
	public void show() {
		AssetLoader.gameMusic.play();
		AssetLoader.gameMusic.setLooping(true);
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
		AssetLoader.gameMusic.stop();
	}

}
