package com.bulalo.CustomizeWorld;

import com.bulalo.GameObjects.Dummy;
import com.bulalo.GameObjects.Tables;

public class CustomWorld {
	private Tables table;
	
	public CustomWorld(){
		
		table = new Tables(27f, 65f, 25, 50);	
		table.setX(27f);
		table.setY(65f);
	}
	
	public void update(float delta){	
		table.update(delta);
	
	}
	
	public Tables getTable(){
		return table;
	}
}
