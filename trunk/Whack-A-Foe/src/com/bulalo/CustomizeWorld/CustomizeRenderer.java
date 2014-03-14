package com.bulalo.CustomizeWorld;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.bulalo.GameObjects.CustomDummy;
import com.bulalo.GameObjects.Tables;
import com.bulalo.Helpers.AssetLoader;
import com.bulalo.UI.Button;

public class CustomizeRenderer {
	private static CustomWorld custom = new CustomWorld();
	private ShapeRenderer shapeRenderer;
	
	private OrthographicCamera cam;
	
	private SpriteBatch batcher;
	private static Tables table,table1,table2;
	private CustomDummy dummy,dummy1,dummy2;
	
	private TextureRegion csbg;
	private TextureRegion wood;
	private TextureRegion steel;
	private TextureRegion carbon;
	private TextureRegion dummyDefault;
	private TextureRegion dummyOffice;
	private TextureRegion dummyJanitor;
	
	private static TextureRegion background;
	
	private List<Button> customButtons;

	public CustomizeRenderer(CustomWorld customWorld){
		custom = customWorld;
		this.customButtons = CustomWorld.getCustomButtons();
		
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
		table = custom.getTable();
		table1 = custom.getTable();
		table2 = custom.getTable();
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
		wood = AssetLoader.wood;
		
		steel = AssetLoader.steel;
		carbon = AssetLoader.carbon;
		dummyDefault = AssetLoader.dummyDefault;
		dummyOffice = AssetLoader.dummyOffice;
		dummyJanitor = AssetLoader.dummyJanitor;
		
		//background = AssetLoader.getBackground();
		//background = getBackground();
		
	}

	private void initGameObjects() {
		table = custom.getTable();
		table1 = custom.getTable1();
		table2 = custom.getTable2();
	
		dummy = custom.getDummy();
		dummy1 = custom.getDummy1();
		dummy2 = custom.getDummy2();
	}
	
	public void drawBackground(TextureRegion region) {
		batcher.draw(region, 0, 0, 160, 256);
	}

	public void drawTable(TextureRegion region, float x, float y, float runTime) {
		batcher.draw(region, table.getX(), table.getY(), table.getWidth(),
				table.getHeight());
	}

	public void drawTable1(TextureRegion region, float x, float y, float runTime) {
		batcher.draw(region, table1.getX(), table1.getY(), table1.getWidth(),
				table1.getHeight());
	}

	public void drawTable2(TextureRegion region, float x, float y, float runTime) {
		batcher.draw(region, table2.getX(), table2.getY(), table2.getWidth(),
				table2.getHeight());
	}
	
	public void drawDummy(TextureRegion region, float x, float y, float runTime) {
		batcher.draw(region, dummy.getX(), dummy.getY(), dummy.getWidth(),
				dummy.getHeight());
	}
	
	public void drawDummy1(TextureRegion region, float x, float y, float runTime) {
		batcher.draw(region, dummy1.getX(), dummy1.getY(), dummy1.getWidth(),
				dummy1.getHeight());
	}
	
	public void drawDummy2(TextureRegion region, float x, float y, float runTime) {
		batcher.draw(region, dummy2.getX(), dummy2.getY(), dummy2.getWidth(),
				dummy2.getHeight());
	}
	
	private void drawButtons(){
		for(Button button : customButtons) {
			button.draw(batcher);
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
        drawTable(wood,20,50,runTime);
        drawTable1(steel,100,50,runTime);
        drawTable2(carbon,180,50,runTime);
        drawDummy(dummyOffice,20,150,runTime);
        drawDummy1(dummyJanitor,100,150,runTime);
        drawDummy2(dummyDefault,180,150,runTime);
        
        batcher.end();

    }
}
