package com.bulalo.CustomizeWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.bulalo.GameObjects.Tables;
import com.bulalo.Helpers.AssetLoader;

public class CustomizeRenderer {
	private CustomWorld custom;
	private ShapeRenderer shapeRenderer;
	
	private OrthographicCamera cam;
	
	private SpriteBatch batcher;
	private Tables table;
	private TextureRegion csbg;
	private TextureRegion wood;
	private TextureRegion steel;
	private TextureRegion carbon;

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
	}
	
	public void drawTable(float runTime){
	      
			batcher.draw(
	                wood, table.getX(), table.getY(), table.getWidth(), table.getHeight());
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
        batcher.draw(csbg, 0, 0, 160, 256);
        /*
        batcher.enableBlending();
        batcher.draw(wood,0,50,22,42);
        */
        // End SpriteBatch
        batcher.end();

    }
}
