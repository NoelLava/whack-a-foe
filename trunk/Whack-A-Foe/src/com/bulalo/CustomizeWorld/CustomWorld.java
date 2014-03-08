package com.bulalo.CustomizeWorld;

import com.badlogic.gdx.math.Vector2;
import com.bulalo.GameObjects.Tables;

public class CustomWorld {
	private Tables table;
	private Vector2 position;
	public CustomWorld(){
		
		table = new Tables(0f, 10f, 200, 200);	
		table.setX(0f);
		table.setY(50f);
		position = new Vector2(0,50);
	}
	
	public void update(float delta){	
		table.update(delta);
	
	}
	
	public Tables getTable(){
		return table;
	}
}
