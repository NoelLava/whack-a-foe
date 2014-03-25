package com.bulalo.CustomizeWorld;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.bulalo.GameObjects.Tables;
import com.bulalo.Helpers.AssetLoader;
import com.bulalo.UI.Button;

public class CustomizeRenderer {
	private static CustomWorld custom = new CustomWorld();
	private static CustomInputHandler customI = new CustomInputHandler();
	private ShapeRenderer shapeRenderer;
	
	private OrthographicCamera cam;
	
	private SpriteBatch batcher;
	private static Tables table,table1,table2;
	
	private TextureRegion csbg;
	private TextureRegion wood;
	private TextureRegion steel;
	private TextureRegion carbon;
	private TextureRegion dummyDefault;
	private TextureRegion dummyOffice;
	private TextureRegion dummyJanitor;
	
	private Button useTableButtons, useDummyButtons;
	
	private static TextureRegion background;
	
	private List<Button> customButtons;
	private List<Button> useButton;
	
	public CustomizeRenderer(CustomWorld customWorld){
		custom = customWorld;
		this.customButtons = CustomWorld.getCustomButtons();
		this.useButton = CustomWorld.getUseButton();
		
		cam = new OrthographicCamera();
		cam.setToOrtho(true, 160, 256);
		
		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);
		
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
		
		initGameObjects();
		initAssets();
	}

	public static TextureRegion getBackground() {
		if (table.isPressed() == true) {
			System.out.println("changed to wood");
			background = AssetLoader.wood;
		} else if (table1.isPressed() == true) {
			System.out.println("changed to carbon");
			background = AssetLoader.carbon;
		} else if (table2.isPressed() == true) {
			System.out.println("changed to steel");
			background = AssetLoader.steel;
		} else {
			System.out.println("default bg");
			background = AssetLoader.csBg;
		}System.out.println("click tester");
		return background;
	}
	
	private void initAssets() {
		csbg = AssetLoader.csBg;
		
		
		//background = AssetLoader.getBackground();
		//background = getBackground();
		
	}

	private void initGameObjects() {
	
	
	}
	
	public void drawBackground(TextureRegion region) {
		batcher.draw(region, 0, 0, 160, 256);
	}


	private void drawButtons(){
		for(Button button : customButtons) {
			button.draw(batcher);
        }		
	}
	
	private void drawUseButton(){
		if(customButtons.get(1).isJustPressed()){
			this.useTableButtons = useButton.get(0);
			useTableButtons.draw(batcher);
		}
		else if(customButtons.get(2).isJustPressed()){
			this.useTableButtons = useButton.get(1);
			useTableButtons.draw(batcher);
		}
		else if(customButtons.get(3).isJustPressed()){
			this.useTableButtons = useButton.get(2);
			useTableButtons.draw(batcher);
			
		}
		else if(customButtons.get(4).isJustPressed()){
			this.useDummyButtons = useButton.get(3);
			useDummyButtons.draw(batcher);
		}
		else if(customButtons.get(5).isJustPressed()){
			this.useDummyButtons = useButton.get(4);
			useDummyButtons.draw(batcher);
		}
		else if(customButtons.get(6).isJustPressed()){
			this.useDummyButtons = useButton.get(5);
			useDummyButtons.draw(batcher);
		}
	}
	
	public void render(float runTime){		
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        
        //tells the shaperenderer to begin
        shapeRenderer.begin(ShapeType.Filled);
        
        // Draw Background color
        shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
        shapeRenderer.rect(0, 0, 160, 256);

        // Tells the shapeRenderer to finish rendering
        // We MUST do this every time.
        shapeRenderer.end();

        //Begin SpriteBatch
        batcher.begin();
        // Disable transparency 
        // This is good for performance when drawing images that do not require
        // transparency.
        batcher.disableBlending();
        //batcher.draw(background, 0, 0, 160, 256);
        
        drawBackground(csbg);
        
        batcher.enableBlending();
       // batcher.draw(wood,0,50,22,42);
        //batcher.draw(steel,40,50,22,42);
        //batcher.draw(carbon,80,50,22,42);
        // End SpriteBatch
        
        drawButtons();
        drawUseButton();
        batcher.end();

    }
}
