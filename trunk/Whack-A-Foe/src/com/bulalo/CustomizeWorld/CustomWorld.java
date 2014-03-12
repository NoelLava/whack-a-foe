package com.bulalo.CustomizeWorld;

import com.badlogic.gdx.math.Vector2;
import com.bulalo.GameObjects.Cdummy1;
import com.bulalo.GameObjects.Cdummy2;
import com.bulalo.GameObjects.Cdummy3;
import com.bulalo.GameObjects.Tables;

public class CustomWorld {
	private Tables table;
	private Tables table1;
	private Tables table2;
	
	private Cdummy1 cdummy1;
	private Cdummy2 cdummy2;
	private Cdummy3 cdummy3;
	
	private Vector2 position;
	private float x,y;
	
	public CustomWorld(){
		
		
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
	
}
