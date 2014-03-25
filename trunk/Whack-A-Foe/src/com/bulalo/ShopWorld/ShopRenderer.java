package com.bulalo.ShopWorld;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.bulalo.GameObjects.Hammers;
import com.bulalo.GameObjects.Upgrades;
import com.bulalo.Helpers.AssetLoader;
import com.bulalo.UI.Button;

public class ShopRenderer {
	private static ShopWorld shop = new ShopWorld();
	private ShapeRenderer shapeRenderer;
	
	private OrthographicCamera cam;
	
	private SpriteBatch batcher;
	private TextureRegion ssbg;
	private TextureRegion kahoy;
	private TextureRegion bakal;
	private TextureRegion ginto;
	
	private static TextureRegion pamalo;
	
	private List<Button> shopButtons;
	private List<Button> buyButtons;
	private List<Button> hammerButtons;
	private List<Button> useButtons;
	
	private Button buyButton;
	private Button useButton;
	
	public ShopRenderer(ShopWorld ShopWorld) {
		shop = ShopWorld;
		this.shopButtons = ShopWorld.getShopButtons();
		this.buyButtons = ShopWorld.getBuyButtons();
		this.hammerButtons = ShopWorld.getHammerButtons();
		this.useButtons = ShopWorld.getUseButtons();
		
		cam = new OrthographicCamera();
		cam.setToOrtho(true, 160, 256);
		
		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);
		
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
		
		initGameObjects();
		initAssets();
		
	}
	
	
	private void initAssets(){
		ssbg = AssetLoader.ssBg;
		kahoy = AssetLoader.kahoy;
		bakal = AssetLoader.bakal;
		ginto = AssetLoader.ginto;

	}
	
	private void initGameObjects(){
		}
	
	public void drawBackground(TextureRegion region){
		batcher.draw(region, 0, 0, 160, 256);
	}
	
	
	private void drawButtons(){
		for(Button button : shopButtons) {
			button.draw(batcher);
        }
		for (Button button : hammerButtons){
			button.draw(batcher);
		}
		
	}
	
<<<<<<< HEAD
	private void drawTickets(){
		batcher.draw(AssetLoader.ticket, 2, 230,
				AssetLoader.ticket.getRegionWidth() / 2,
				AssetLoader.ticket.getRegionHeight() / 2);
		
		String ticketZeros = (AssetLoader.getTicket() < 10)?"00":(AssetLoader.getTicket() >= 10 && AssetLoader.getTicket() < 100)?"0":"";
		AssetLoader.bitGoldSh.draw(batcher, ticketZeros + AssetLoader.getTicket(), (AssetLoader.ticket.getRegionWidth() / 8) + 5, (AssetLoader.ticket.getRegionHeight() / 8) + 226);
		AssetLoader.bitGold.draw(batcher, ticketZeros + AssetLoader.getTicket(), (AssetLoader.ticket.getRegionWidth() / 8) + 6, (AssetLoader.ticket.getRegionHeight() / 8) + 225);
=======
	private void drawBuyButtons(){
		if(hammerButtons.get(0).isJustPressed()){
			this.buyButton = buyButtons.get(0);
			buyButton.draw(batcher);
		}
		else if(hammerButtons.get(1).isJustPressed()){
			this.buyButton = buyButtons.get(1);
			buyButton.draw(batcher);
		}
		else if(hammerButtons.get(2).isJustPressed()){
			this.buyButton = buyButtons.get(2);
			buyButton.draw(batcher);
		}
	}
	
	private void drawUseButtons(){
		if(buyButtons.get(0).isJustPressed()){
			this.useButton = useButtons.get(0);
			useButton.draw(batcher);
		}
		else if(buyButtons.get(1).isJustPressed()){
			this.useButton = useButtons.get(1);
			useButton.draw(batcher);
		}
		else if(buyButtons.get(2).isJustPressed()){
			this.useButton = useButtons.get(2);
			useButton.draw(batcher);
		}
>>>>>>> 9456b0c2de95267a00adae7fc4569de2656ebd0c
	}
	
	public void render(float runTime) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		shapeRenderer.begin(ShapeType.Filled);
		
		shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
		shapeRenderer.rect(0, 0, 160, 256); 
		
		shapeRenderer.end();
		
		batcher.begin();
		
		batcher.disableBlending();
		
		drawBackground(ssbg);;
		
		batcher.enableBlending();
		
		drawButtons();
<<<<<<< HEAD
		drawHammer(kahoy, 20, 50, runTime);
		drawHammer1(bakal, 100, 50, runTime);
		drawHammer2(ginto, 180, 50, runTime);
		drawTickets();
		
=======
		drawBuyButtons();
		drawUseButtons();
>>>>>>> 9456b0c2de95267a00adae7fc4569de2656ebd0c
		batcher.end();
	}
}
