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
	private static List<Button> useButton;
	private Button backButton;
	
	private Button table;
	private Button table1;
	private Button table2;
	
	private Button dummy,dummy1,dummy2;
	
	private Button useWood, useSteel, useCarbon, useBoss, useFarmer, useBoy;
	
	private Vector2 position;
	private float x,y;
	
	public CustomWorld(){
		customButtons = new ArrayList<Button>();
		useButton = new ArrayList<Button>();
		
//		backButton = new Button(Gdx.graphics.getWidth() / 2 - 30.1f,
//				Gdx.graphics.getHeight() / 2 - 252.15f, 28.67f, 27.33f,
//				AssetLoader.backButton, AssetLoader.backPressed);
		
		backButton = new Button(137.85f, 1.85f, 21.5f, 20.5f,
				AssetLoader.backButton, AssetLoader.backPressed);

		table = new Button(20, 75, 38, 38, AssetLoader.woodIconUp, AssetLoader.woodIconDown);	
		
		table1 = new Button(60, 75, 38, 38, AssetLoader.steelIconUp, AssetLoader.steelIconDown);	
		
		table2 = new Button(100, 75, 38, 38, AssetLoader.carbonIconUp,AssetLoader.carbonIconDown);	
	
		dummy = new Button(20, 180, 38, 38, AssetLoader.bossIconUp,AssetLoader.bossIconDown);
		dummy1 = new Button(60, 180, 38, 38, AssetLoader.farmerIconUp,AssetLoader.farmerIconDown);
		dummy2 = new Button(100, 180, 38, 38, AssetLoader.boyIconUp,AssetLoader.boyIconDown);
		
		useWood = new Button(30,95,20,15, AssetLoader.useUp, AssetLoader.useDown);
		useSteel = new Button(70,95,20,15, AssetLoader.useUp, AssetLoader.useDown);
		useCarbon = new Button(110,95,20,15, AssetLoader.useUp, AssetLoader.useDown);
		useBoss = new Button(30,200,20,15, AssetLoader.useUp, AssetLoader.useDown);
		useFarmer = new Button(70,200,20,15, AssetLoader.useUp, AssetLoader.useDown);
		useBoy = new Button(110,200,20,15, AssetLoader.useUp, AssetLoader.useDown);
		
		customButtons.add(backButton);
		customButtons.add(table);
		customButtons.add(table1);
		customButtons.add(table2);
		customButtons.add(dummy);
		customButtons.add(dummy1);
		customButtons.add(dummy2);
		useButton.add(useWood);
		useButton.add(useSteel);
		useButton.add(useCarbon);
		useButton.add(useBoss);
		useButton.add(useFarmer);
		useButton.add(useBoy);
		
		
		
	}
	
	public void update(float delta){	
	}
	
		
	public static List<Button> getCustomButtons() {
		return customButtons;
	}
	
	public static List<Button> getUseButton(){
		return useButton;
	}
	
}
