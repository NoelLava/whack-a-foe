package com.bulalo.FileUpload;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.bulalo.CustomizeWorld.CustomWorld;
import com.bulalo.UI.Button;

public class UploadRenderer {
	
	private ShapeRenderer shapeRenderer;
	private OrthographicCamera cam;
	private SpriteBatch batcher;
	
	private TextureRegion csbg;
	Button backButton,uploadButton;
	CustomWorld custom = new CustomWorld();
	UploadWorld upload = new UploadWorld();
	private List<Button> customButtons;
	
	public UploadRenderer(){
		cam = new OrthographicCamera();
		cam.setToOrtho(true, 160, 256);
		
		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);
		
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
		
		this.customButtons = CustomWorld.getCustomButtons();
		backButton = customButtons.get(0);
		
		uploadButton = upload.getButton();
		initAssets();
	}
	
	private void initAssets() {
	}

	public void drawBackground(TextureRegion region) {
		batcher.draw(region, 0, 0, 160, 256);
	}
	
	public void render(float runTime){		
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        
        shapeRenderer.begin(ShapeType.Filled);
        
        shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
        shapeRenderer.rect(0, 0, 160, 256);

        shapeRenderer.end();

        batcher.begin();
        batcher.disableBlending();
       backButton.draw(batcher);
       uploadButton.draw(batcher);
        
        batcher.enableBlending();
        batcher.end();

    }



}
