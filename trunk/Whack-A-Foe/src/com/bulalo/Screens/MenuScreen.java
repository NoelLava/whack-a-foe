package com.bulalo.Screens;
 
import java.util.List;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.bulalo.Helpers.AssetLoader;
import com.bulalo.MenuWorld.MenuInputHandler;
import com.bulalo.MenuWorld.MenuRenderer;
import com.bulalo.MenuWorld.MenuWorld;
import com.bulalo.UI.Button;
import com.bulalo.whackafoe.WaFGame;

public class MenuScreen implements Screen {

	WaFGame game;
	MenuWorld menu;
	MenuRenderer render;
	private float runTime = 0;

	private static List<Button> menuButtons;
	private static List<Button> sfxButtonsOn;
	
	private Button sfxButtonOn;

	private Button playButton;
	private Button shopButton;
	private Button customButton;

	float screenWidth;
    float screenHeight;
    float gameWidth;
    float gameHeight;   

//	public MenuScreen(WaFGame game) {
//		this.game = game;
//	}

	public MenuScreen(WaFGame game) {
		screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
        gameWidth = 160;
        gameHeight = screenHeight / (screenWidth / gameWidth);        
		
		this.game = game;
		System.out.println("Main Menu initialized");
		menu = new MenuWorld();
		System.out.println("MenuWorld initialized");
		render = new MenuRenderer(menu);

		Gdx.input.setInputProcessor(new MenuInputHandler(menu, screenWidth/gameWidth, screenHeight/gameHeight));
		
		menuButtons = MenuWorld.getMenuButtons();
		playButton = menuButtons.get(0);
		shopButton = menuButtons.get(1);
		customButton = menuButtons.get(2);
		
		sfxButtonsOn = MenuWorld.getSFXButtonOn();
		sfxButtonOn = sfxButtonsOn.get(0); 
	}

	@Override
	public void render(float delta) {
		runTime += delta;
		// if (Gdx.input.justTouched()) // use your own criterion here
		// game.setScreen(game.gameScreen);

		if(playButton.isJustPressed()){
			game.setScreen(new GameScreen(game));
			this.dispose();
		}else if(shopButton.isJustPressed()){
			game.setScreen(new ShopScreen(game));
			this.dispose();
		}else if(customButton.isJustPressed()){
			game.setScreen(new CustomizeScreen(game));
			this.dispose();
		}
	
		menu.update(delta);
		render.render(runTime);
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		AssetLoader.titleMusic.play();
		AssetLoader.titleMusic.setLooping(true);
		//AssetLoader.clearPref();
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
		AssetLoader.titleMusic.stop();
	}

	public float getScreenWidth() {
		return screenWidth;
	}

	public float getScreenHeight() {
		return screenHeight;
	}

	public float getGameWidth() {
		return gameWidth;
	}

	public float getGameHeight() {
		return gameHeight;
	}

	public void setScreenWidth(float screenWidth) {
		this.screenWidth = screenWidth;
	}

	public void setScreenHeight(float screenHeight) {
		this.screenHeight = screenHeight;
	}

	public void setGameWidth(float gameWidth) {
		this.gameWidth = gameWidth;
	}

	public void setGameHeight(float gameHeight) {
		this.gameHeight = gameHeight;
	}

}
