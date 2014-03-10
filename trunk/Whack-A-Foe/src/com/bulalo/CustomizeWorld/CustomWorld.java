package com.bulalo.CustomizeWorld;

import com.badlogic.gdx.math.Vector2;
import com.bulalo.GameObjects.Cdummy1;
import com.bulalo.GameObjects.Cdummy2;
import com.bulalo.GameObjects.Cdummy3;
import com.bulalo.GameObjects.Tables;
import com.bulalo.GameObjects.Tables1;
import com.bulalo.GameObjects.Tables2;

public class CustomWorld {
	private Tables table;
	private Tables1 table1;
	private Tables2 table2;
	
	private Cdummy1 cdummy1;
	private Cdummy2 cdummy2;
	private Cdummy3 cdummy3;
	
	private Vector2 position;
	private float x,y;
	
	public CustomWorld(){
		
		cdummy1 = new Cdummy1(20, 150, 22, 42);	
		cdummy1.setX(20);
		cdummy1.setY(150);
		position = new Vector2(20,150);
		
		cdummy2 = new Cdummy2(60, 150, 22, 42);	
		cdummy2.setX(60);
		cdummy2.setY(150);
		position = new Vector2(60,150);
		
		cdummy3 = new Cdummy3(100, 150, 22, 42);	
		cdummy3.setX(100);
		cdummy3.setY(150);
		position = new Vector2(100,150);
		
		table = new Tables(20, 50, 22, 42);	
		table.setX(20);
		table.setY(50);
		position = new Vector2(20,50);
		
		table1 = new Tables1(60, 50, 22, 42);	
		table1.setX(60);
		table1.setY(50);
		position = new Vector2(60,50);
		
		table2 = new Tables2(100, 50, 22, 42);	
		table2.setX(100);
		table2.setY(50);
		position = new Vector2(100,50);
	}
	
	public void update(float delta){	
		table.update(delta);
		
	}
	
	public Tables getTable(){
		return table;
	}
	
	public Tables1 getTable1(){
		return table1;
	}
	
	public Tables2 getTable2(){
		return table2;
	}
	
	public Cdummy1 getCdummy1(){
		return cdummy1;
	}
	
	public Cdummy2 getCdummy2(){
		return cdummy2;
	}
	
	public Cdummy3 getCdummy3(){
		return cdummy3;
	}
	
}
