package com.bulalo.CustomizeWorld;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.bulalo.GameObjects.CustomDummy;
import com.bulalo.GameObjects.Tables;
import com.bulalo.Helpers.AssetLoader;
import com.bulalo.UI.Button;

public class CustomWorld {
	private static List<Button> customButtons;
	private Button backButton;
	
	private Tables table;
	private Tables table1;
	private Tables table2;
	
	private CustomDummy dummy,dummy1,dummy2;
	
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
	
		dummy = new CustomDummy(20, 180, 22, 42);
		dummy1 = new CustomDummy(60, 180, 22, 42);
		dummy2 = new CustomDummy(100, 180, 22, 42);
		
	}
	
	public void update(float delta){	
		table.update(delta);
		table1.update(delta);
		table2.update(delta);
	
		dummy.update(delta);
		dummy1.update(delta);
		dummy2.update(delta);
		
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
	
	public CustomDummy getDummy(){
		return dummy;
	}
	
	public CustomDummy getDummy1(){
		return dummy1;
	}
	
	public CustomDummy getDummy2(){
		return dummy2;
	}
	
	public static List<Button> getCustomButtons() {
		return customButtons;
	}
	
}
