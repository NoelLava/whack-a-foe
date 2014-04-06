package com.bulalo.CustomizeWorld;
 
import java.util.ArrayList;
import java.util.List;

import com.bulalo.Helpers.AssetLoader;
import com.bulalo.UI.Button;

public class CustomWorld {
	private static List<Button> customButtons;
	private static List<Button> useButton;
	private Button backButton;
	private Button upload;
	private Button table,table1,table2;
	private Button dummy,dummy1,dummy2;
	private Button useWood, useSteel, useCarbon, useBoss, useFarmer, useBoy;
	
	public CustomWorld(){
		customButtons = new ArrayList<Button>();
		useButton = new ArrayList<Button>();
		
		backButton = new Button(137.85f, 1.85f, 21.5f, 20.5f,
				AssetLoader.backButton, AssetLoader.backPressed);
		
		upload = new Button(23, 217.5f, 67, 26,
				AssetLoader.uploadUp, AssetLoader.uploadDown);
		
		//icons for the tables
		table = new Button(20, 75, 38, 38, AssetLoader.woodIconUp, AssetLoader.woodIconDown);	
		table1 = new Button(60, 75, 38, 38, AssetLoader.steelIconUp, AssetLoader.steelIconDown);	
		table2 = new Button(100, 75, 38, 38, AssetLoader.carbonIconUp,AssetLoader.carbonIconDown);	
		
		//icons for the dummies
		dummy = new Button(20, 150, 38, 38, AssetLoader.bossIconUp,AssetLoader.bossIconDown);
		dummy1 = new Button(60, 150, 38, 38, AssetLoader.farmerIconUp,AssetLoader.farmerIconDown);
		dummy2 = new Button(100, 150, 38, 38, AssetLoader.boyIconUp,AssetLoader.boyIconDown);
		
		useWood = new Button(22,115,34.5f,13.5f, AssetLoader.useUp, AssetLoader.useDown);
		useSteel = new Button(62,115,34.5f,13.5f, AssetLoader.useUp, AssetLoader.useDown);
		useCarbon = new Button(102,115,34.5f,13.5f, AssetLoader.useUp, AssetLoader.useDown);
		useBoss = new Button(22,190,34.5f,13.5f, AssetLoader.useUp, AssetLoader.useDown);
		useFarmer = new Button(62,190,34.5f,13.5f, AssetLoader.useUp, AssetLoader.useDown);
		useBoy = new Button(102,190,34.5f,13.5f, AssetLoader.useUp, AssetLoader.useDown);
		
		customButtons.add(backButton);
		customButtons.add(table);
		customButtons.add(table1);
		customButtons.add(table2);
		customButtons.add(dummy);
		customButtons.add(dummy1);
		customButtons.add(dummy2);
		customButtons.add(upload);
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
