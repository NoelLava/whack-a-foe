package com.bulalo.Screens;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.bulalo.CustomizeWorld.CustomInputHandler;
import com.bulalo.CustomizeWorld.CustomWorld;
import com.bulalo.FileUpload.UploadRenderer;
import com.bulalo.UI.Button;
import com.bulalo.whackafoe.WaFGame;

public class UploadScreen implements Screen{

	WaFGame game;
	UploadRenderer renderer;
	CustomWorld custom;
	
	float screenWidth;
    float screenHeight;
    float gameWidth;
    float gameHeight;   
    float runTime = 0;
	
    Button backButton;
    private static List<Button> customButtons;
    
    public UploadScreen(WaFGame game){
		this.game = game;
		screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
        gameWidth = 160;
        gameHeight = screenHeight / (screenWidth / gameWidth);
		
		System.out.println("Custom Screen Attached");
		renderer = new UploadRenderer();  //initialize the gameRenderer
		Gdx.input.setInputProcessor(new CustomInputHandler(custom,screenWidth/gameWidth, screenHeight/gameHeight));
		
		customButtons = CustomWorld.getCustomButtons();
		backButton = customButtons.get(0);
	
	}
    
	@Override
	public void render(float delta) {
	
		runTime += delta;
		if(backButton.isJustPressed()){
			game.setScreen(new CustomizeScreen(game));
			this.dispose();
		}
		renderer.render(delta);
	
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
