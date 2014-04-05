package com.bulalo.MenuWorld;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.bulalo.Helpers.AssetLoader;
import com.bulalo.UI.Button;

public class MenuRenderer {
	private static MenuWorld menu = new MenuWorld();
	private ShapeRenderer shapeRenderer;
	
	private OrthographicCamera cam;
	
	private SpriteBatch batcher;
	private TextureRegion titleBg;
	
	private Button sfxMusicButton;
	private Button bgmMusicButton;

	private List<Button> menuButtons;
	private List<Button> sfxButtonsOn;
	private List<Button> bgmButtonsOn;
	private List<Button> sfxButtonsOff;
	private List<Button> bgmButtonsOff;
	
	
	public MenuRenderer(MenuWorld world) {
		menu = world;
        this.menuButtons = MenuWorld.getMenuButtons();
        this.sfxButtonsOn = MenuWorld.getSFXButtonOn();
        this.bgmButtonsOn = MenuWorld.getBGMButtonOn();
        this.sfxButtonsOff = MenuWorld.getSFXButtonOff();
        this.bgmButtonsOff = MenuWorld.getBGMButtonOff();
        
		cam = new OrthographicCamera();
		cam.setToOrtho(true, 160, 256);
		
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
		
		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);

		initAssets();
	}
	
	public void initAssets(){
		titleBg = AssetLoader.titleBg;
		System.out.println(Gdx.files.getExternalStoragePath());
	}
	
	private void drawButtons(){
		for(Button button : menuButtons) {
			button.draw(batcher);
        }
		
		for(Button button: sfxButtonsOn){
			button.draw(batcher);
		}
		
		for(Button button : bgmButtonsOn){
			button.draw(batcher);
		}

	}
	
	private void drawMusicButtons(){
			if(sfxButtonsOn.get(0).isJustPressed() || sfxButtonsOn.get(0).isPressed() || sfxButtonsOff.get(0).isPressed()){
				this.sfxMusicButton = sfxButtonsOff.get(0);
				sfxMusicButton.draw(batcher);
			} 
			
			if(sfxButtonsOff.get(0).isJustPressed() || sfxButtonsOff.get(0).isPressed() || sfxButtonsOn.get(0).isPressed()){
				this.sfxMusicButton = sfxButtonsOn.get(0);
				sfxMusicButton.draw(batcher);
			}

			if(bgmButtonsOn.get(0).isJustPressed() || bgmButtonsOn.get(0).isPressed() || bgmButtonsOff.get(0).isPressed()){
				this.bgmMusicButton = bgmButtonsOff.get(0);
				bgmMusicButton.draw(batcher);
				
			}
			
			if(bgmButtonsOff.get(0).isPressed() || bgmButtonsOff.get(0).isPressed() || bgmButtonsOn.get(0).isPressed()){
				this.bgmMusicButton = bgmButtonsOn.get(0);
				bgmMusicButton.draw(batcher);
		
			}
			
	}


	public void render(float runTime) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		// tells the shaperenderer to begin
		shapeRenderer.begin(ShapeType.Filled);

		// Draw Background color
		shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
		shapeRenderer.rect(0, 0, 160, 256);

		// Tells the shapeRenderer to finish rendering
		// We MUST do this every time.
		shapeRenderer.end();

		// Begin SpriteBatch
		batcher.begin();
		// Disable transparency
		// This is good for performance when drawing images that do not require
		// transparency.
		batcher.disableBlending();
		batcher.draw(titleBg, 0, 0, 160, 256);

		// The buttons need transparency, so we enable that again.
		batcher.enableBlending();
		
		drawButtons();
		drawMusicButtons();
		
		// End SpriteBatch
		batcher.end();

	}
}