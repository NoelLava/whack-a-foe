//This Class is the one responsible for rendering the game objects to the game screen. This class will be later on called in the gameScreen class 
package com.bulalo.GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.bulalo.GameObjects.Dummy;
import com.bulalo.Helpers.AssetLoader;

public class GameRenderer {
	private GameWorld myWorld;
	private ShapeRenderer shapeRenderer;
	
	private OrthographicCamera cam;
	
	private SpriteBatch batcher;
	
	private Dummy dummy;
	
	private TextureRegion table;
	private Animation dummyAnimation;
	private Animation dummyDies;
	
	public GameRenderer(GameWorld world){
		myWorld = world;
		
		cam = new OrthographicCamera();
		cam.setToOrtho(true, 160, 256);
		
		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);
		
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
		
		initGameObjects();
		initAssets();
	}
	
	private void initGameObjects(){
		dummy = myWorld.getDummy();
	}
	
	private void initAssets(){
		table = AssetLoader.table;
		dummyAnimation = AssetLoader.dummyAnimation;
		dummyDies = AssetLoader.dummyDies;
	}
	
	public void drawDummy(float runTime){
	    if(dummy.isAlive()){   
			batcher.draw(dummyAnimation.getKeyFrame(runTime),
	                dummy.getX(), dummy.getY(), dummy.getWidth(), dummy.getHeight());
	    }else{
	    	batcher.draw(dummyDies.getKeyFrame(runTime),
	                dummy.getX(), dummy.getY(), dummy.getWidth(), dummy.getHeight());
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
        batcher.draw(table, 0, 0, 160, 256);
        
        batcher.enableBlending();
 
        drawDummy(runTime);
        
        // End SpriteBatch
        batcher.end();

    }	
}
