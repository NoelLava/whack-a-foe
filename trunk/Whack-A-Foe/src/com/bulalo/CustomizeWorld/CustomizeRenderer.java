package com.bulalo.CustomizeWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.bulalo.GameObjects.Tables;
import com.bulalo.GameObjects.Tables1;
import com.bulalo.GameObjects.Tables2;
import com.bulalo.Helpers.AssetLoader;

public class CustomizeRenderer {
	private CustomWorld custom;
	private ShapeRenderer shapeRenderer;
	
	private OrthographicCamera cam;
	
	private SpriteBatch batcher;
	private Tables table;
	private Tables1 table1;
	private Tables2 table2;
	private TextureRegion csbg;
	private TextureRegion wood;
	private TextureRegion steel;
	private TextureRegion carbon;
	
	private TextureRegion background;

	public CustomizeRenderer(CustomWorld customWorld){
		custom = customWorld;
		cam = new OrthographicCamera();
		cam.setToOrtho(true, 160, 256);
		
		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);
		
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
		
		initGameObjects();
		initAssets();
	}

	private void initAssets() {
		csbg = AssetLoader.csBg;
		wood = AssetLoader.wood;
		
		steel = AssetLoader.steel;
		carbon = AssetLoader.carbon;
		
	}

	private void initGameObjects() {
		table = custom.getTable();
		table1 = custom.getTable1();
		table2 = custom.getTable2();
	}
	
	public void drawBackground(TextureRegion region){
		batcher.draw(region, 0, 0, 160, 256);
	}
	
	public void drawTable(TextureRegion region,float x, float y, float runTime){
	      
			batcher.draw(
	                region, table.getX(), table.getY(), table.getWidth(), table.getHeight());
	    }
	
	public void drawTable1(TextureRegion region,float x, float y, float runTime){
	     
		batcher.draw(
                region, table1.getX(), table1.getY(), table1.getWidth(), table1.getHeight());
    }
	
	public void drawTable2(TextureRegion region,float x, float y, float runTime){
	      
		batcher.draw(
                region, table2.getX(), table2.getY(), table2.getWidth(), table2.getHeight());
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
        drawBackground(background);
        batcher.enableBlending();
       // batcher.draw(wood,0,50,22,42);
        //batcher.draw(steel,40,50,22,42);
        //batcher.draw(carbon,80,50,22,42);
        // End SpriteBatch
        drawTable(wood,20,50,runTime);
        drawTable1(steel,100,50,runTime);
        drawTable2(carbon,180,50,runTime);
        
        batcher.end();

        
    }
}
