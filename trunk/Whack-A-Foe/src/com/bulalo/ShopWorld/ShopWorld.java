package com.bulalo.ShopWorld;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.bulalo.GameObjects.Hammers;
import com.bulalo.Helpers.AssetLoader;
import com.bulalo.UI.Button;

public class ShopWorld {
	private static List<Button> shopButtons;
	private Button backButton;

	private Hammers hammer;
	private Hammers hammer1;
	private Hammers hammer2;
	private Rectangle rect = new Rectangle(0, 0, 17, 12);

	float runTime = 0;

	public ShopWorld() {
		shopButtons = new ArrayList<Button>();

//		backButton = new Button(Gdx.graphics.getWidth() / 2 - 30.1f,
//				Gdx.graphics.getHeight() / 2 - 252.15f, 28.67f, 27.33f,
//				AssetLoader.backButton, AssetLoader.backPressed);
		backButton = new Button(137.85f, 1.85f, 21.5f, 20.5f,
				AssetLoader.backButton, AssetLoader.backPressed);

		shopButtons.add(backButton);
	}

	public void update(float delta) {
		// runTime += delta;

		rect.x++;
		if (rect.x > 137) {
			rect.x = 0;
		}
	}

	public Rectangle getRect() {
		return rect;
	}

	public Hammers getHammer() {
		return hammer;
	}

	public Hammers getHammer1() {
		return hammer1;
	}

	public Hammers getHammer2() {
		return hammer2;
	}

	public static List<Button> getShopButtons() {
		return shopButtons;
	}

}
