//This Class is the one responsible for rendering the game objects to the game screen. This class will be later on called in the gameScreen class 
package com.bulalo.GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GameRenderer {
	private GameWorld myWorld;
	private ShapeRenderer shapeRenderer;
	
	private OrthographicCamera cam;
	
	public GameRenderer(GameWorld world){
		myWorld = world;
		
		cam = new OrthographicCamera();
		cam.setToOrtho(true, 160, 256);
		
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
	}
	
	public void render(){
		System.out.println("GameRenderer - render");
		
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        
        //tells the shaperenderer to begin
        shapeRenderer.begin(ShapeType.Filled);
        
        // Chooses RGB Color of 87, 109, 120 at full opacity
        shapeRenderer.setColor(87 / 255.0f, 109 / 255.0f, 120 / 255.0f, 1);

        // Draws the rectangle from myWorld (Using ShapeType.Filled)
        //shapeRenderer.rect(myWorld.getRect().x, myWorld.getRect().y,
        //        myWorld.getRect().width, myWorld.getRect().height);

        // Tells the shapeRenderer to finish rendering
        // We MUST do this every time.
        shapeRenderer.end();

        // Tells shapeRenderer to draw an outline of the following shapes
        shapeRenderer.begin(ShapeType.Line);

        // Chooses RGB Color of 255, 109, 120 at full opacity
        shapeRenderer.setColor(255 / 255.0f, 109 / 255.0f, 120 / 255.0f, 1);

        // Draws the rectangle from myWorld (Using ShapeType.Line)
        //shapeRenderer.rect(myWorld.getRect().x, myWorld.getRect().y,
        //        myWorld.getRect().width, myWorld.getRect().height);

        shapeRenderer.end();
    }	
}
