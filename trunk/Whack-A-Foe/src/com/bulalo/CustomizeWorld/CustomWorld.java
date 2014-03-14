package com.bulalo.CustomizeWorld;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.bulalo.GameObjects.Cdummy1;
import com.bulalo.GameObjects.Cdummy2;
import com.bulalo.GameObjects.Cdummy3;
import com.bulalo.GameObjects.Tables;
import com.bulalo.Helpers.AssetLoader;
import com.bulalo.UI.Button;

public class CustomWorld {
	private static List<Button> customButtons;
	private Button backButton;
	
	private Tables table;
	private Tables table1;
	private Tables table2;
	
	private Cdummy1 cdummy1;
	private Cdummy2 cdummy2;
	private Cdummy3 cdummy3;
	
	private Vector2 position;
	private float x,y;
	
	public CustomWorld(){
		customButtons = new ArrayList<Button>();

		backButton = new Button(Gdx.graphics.getWidth() / 2 - 30.1f,
				Gdx.graphics.getHeight() / 2 - 252.15f, 28.67f, 27.33f,
				AssetLoader.backButton, AssetLoader.backPressed);

		customButtons.add(backButton);
		
		table = new Tables(20, 50, 22, 42);	
		
		table1 = new Tables(60, 50, 22, 42);	
		
		table2 = new Tables(100, 50, 22, 42);	
	}
	
	public void update(float delta){	
		table.update(delta);
		table1.update(delta);
		table2.update(delta);
	}
	
	public Tables getTable(){
		return table;
	}
	
	public Tables getTable1(){
		return table1;
	}
	
	public Tables getTable2(){
		return table2;
	}
	
	public static List<Button> getCustomButtons() {
		return customButtons;
	}
	
}
