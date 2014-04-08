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
import com.bulalo.GameObjects.Timer;
import com.bulalo.Helpers.AssetLoader;
import com.bulalo.UI.Button;

public class ShopRenderer {
	static ShopWorld shop = new ShopWorld();
	private ShapeRenderer shapeRenderer;

	private OrthographicCamera cam;

	private SpriteBatch batcher;
	private static Hammers hammer, hammer1, hammer2;
	private TextureRegion ssbg;

	private List<Button> shopButtons;
	private List<Button> useButtons;
	private List<Button> buyButtons;
	private List<Button> hammerButtons;

	private Button buyButton, useButton;

	private Timer warningTimer;

	public ShopRenderer(ShopWorld shopWorld) {
		shop = shopWorld;
		this.shopButtons = ShopWorld.getShopButtons();
		this.useButtons = ShopWorld.getUseButtons();
		this.buyButtons = ShopWorld.getBuyButtons();
		this.hammerButtons = ShopWorld.getHammerButtons();

		cam = new OrthographicCamera();
		cam.setToOrtho(true, 160, 256);

		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);

		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);

		initAssets();

		warningTimer = new Timer(3);
	}

	private void initAssets() {
		ssbg = AssetLoader.ssBg;
	}

	public void drawBackground(TextureRegion region) {
		batcher.draw(region, 0, 0, 160, 256);
	}

	public void drawHammer(TextureRegion region, float x, float y, float runTime) {
		batcher.draw(region, hammer.getX(), hammer.getY(), hammer.getWidth(),
				hammer.getHeight());
	}

	public void drawHammer1(TextureRegion region, float x, float y,
			float runTime) {
		batcher.draw(region, hammer1.getX(), hammer1.getY(),
				hammer1.getWidth(), hammer1.getHeight());

	}

	public void drawHammer2(TextureRegion region, float x, float y,
			float runTime) {
		batcher.draw(region, hammer2.getX(), hammer2.getY(),
				hammer2.getWidth(), hammer2.getHeight());
	}

	private void drawButtons() {
		for (Button button : shopButtons) {
			button.draw(batcher);
		}
		for (Button button : hammerButtons) {
			button.draw(batcher);
		}
	}

	private void drawTickets() {
		batcher.draw(AssetLoader.ticket, 2, 230,
				AssetLoader.ticket.getRegionWidth() / 2,
				AssetLoader.ticket.getRegionHeight() / 2);

		String ticketZeros = (AssetLoader.getTicket() < 10) ? "00"
				: (AssetLoader.getTicket() >= 10 && AssetLoader.getTicket() < 100) ? "0"
						: "";
		AssetLoader.bitGoldSh.draw(batcher,
				ticketZeros + AssetLoader.getTicket(),
				(AssetLoader.ticket.getRegionWidth() / 8) + 5,
				(AssetLoader.ticket.getRegionHeight() / 8) + 226);
		AssetLoader.bitGold.draw(batcher,
				ticketZeros + AssetLoader.getTicket(),
				(AssetLoader.ticket.getRegionWidth() / 8) + 6,
				(AssetLoader.ticket.getRegionHeight() / 8) + 225);

	}

	private void drawBuyButtons() {

		for (int index = 0; index < 5; index++) {
			if (index < 3) {
				if (hammerButtons.get(index).isJustPressed()
						|| buyButtons.get(index).isPressed()
						|| useButtons.get(index).isPressed()) {
					if (index == 0) {
						if (ShopInputHandler.woodIsBought == false) {
							this.buyButton = buyButtons.get(index);
							buyButton.draw(batcher);
						} else if (ShopInputHandler.woodIsBought == true
								|| buyButtons.get(index).isPressed()) {
							this.useButton = useButtons.get(index);
							useButton.draw(batcher);
						}
					} else if (index == 1) {
						if (ShopInputHandler.steelIsBought == false) {
							this.buyButton = buyButtons.get(index);
							buyButton.draw(batcher);
						} else if (ShopInputHandler.steelIsBought == true
								|| buyButtons.get(index).isPressed()) {
							this.useButton = useButtons.get(index);
							useButton.draw(batcher);
						}
					} else if (index == 2) {
						if (ShopInputHandler.goldIsBought == false) {
							this.buyButton = buyButtons.get(index);
							buyButton.draw(batcher);
						} else if (ShopInputHandler.goldIsBought == true
								|| buyButtons.get(index).isPressed()) {
							this.useButton = useButtons.get(index);
							useButton.draw(batcher);
						}
					}
				}
			} else if (index >= 3 && index < 5
					|| useButtons.get(index).isPressed()) {
				if (shopButtons.get(index - 2).isJustPressed()
						|| buyButtons.get(index).isPressed()) {
					this.useButton = buyButtons.get(index);
					useButton.draw(batcher);
				}
			}
		}
	}

	public void drawPrice() {
		// Steel
		AssetLoader.priceShadow.draw(batcher, "*400", 65, 91);
		AssetLoader.priceGold.draw(batcher, "*400", 66, 92);

		// Gold
		AssetLoader.priceShadow.draw(batcher, "*500", 115, 91);
		AssetLoader.priceGold.draw(batcher, "*500", 116, 92);

		// Time Boost
		AssetLoader.priceShadow.draw(batcher, "*200", 30, 159);
		AssetLoader.priceGold.draw(batcher, "*200", 31, 158);

		// Score Boost
		AssetLoader.priceShadow.draw(batcher, "*300", 96, 159);
		AssetLoader.priceGold.draw(batcher, "*300", 97, 158);
	}

	public void drawTransaction() {
		if (ShopInputHandler.insufficientTickets) {
			if(!warningTimer.isRunning){
				warningTimer.start();
			}
			AssetLoader.priceShadow.draw(batcher, "YOU HAVE", 50, 119);
			AssetLoader.bitWarning.draw(batcher, "YOU HAVE", 50, 118);
			AssetLoader.priceGold.draw(batcher, "YOU HAVE", 50, 117);

			AssetLoader.priceShadow.draw(batcher, "INSUFFICIENT TICKETS",
					5, 129);
			AssetLoader.bitWarning.draw(batcher, "INSUFFICIENT TICKETS", 5,
					128);
			AssetLoader.priceGold.draw(batcher, "INSUFFICIENT TICKETS", 5,
					127);
			if (warningTimer.hasCompleted()) {
				ShopInputHandler.insufficientTickets = false;
			}
		}		
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

		drawBackground(ssbg);

		batcher.enableBlending();

		drawButtons();
		drawTickets();
		drawPrice();
		drawBuyButtons();
		drawTransaction();
		batcher.end();
	}
}
