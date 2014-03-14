package com.bulalo.CustomizeWorld;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.InputProcessor;
import com.bulalo.GameObjects.Tables;
import com.bulalo.UI.Button;

public class CustomInputHandler implements InputProcessor{
	private CustomWorld customWorld;
	
	private Tables table;
	private Tables table1;
	private Tables table2;
	
	private static boolean tableTrue = false;
	private static boolean table1True = false;
	private static boolean table2True = false;
	
	private static List<Button> customButtons;

	float scaleFactorX;
	float scaleFactorY;
	
	public CustomInputHandler(CustomWorld customWorld, float scaleFactorX,
			float scaleFactorY){
		this.customWorld = customWorld;
		
		customButtons = CustomWorld.getCustomButtons();

		table = customWorld.getTable();
		table1 = customWorld.getTable1();
		table2 = customWorld.getTable2();
		this.scaleFactorX = scaleFactorX;
        this.scaleFactorY = scaleFactorY;
	
	}
	
	public CustomInputHandler(){
		System.out.println("initialized");
	}
	
	public boolean checkTable(){
		return tableTrue;
	}
	
	public boolean checkTable1(){
		return table1True;
	}
	
	public boolean checkTable2(){
		return table2True;
	}
	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		screenX = scaleX(screenX);
		screenY = scaleY(screenY);
		
		if(table.isTouchDown(screenX, screenY)){
			tableTrue = true;
			System.out.println("table touched");
		}
		else if(table1.isTouchDown(screenX, screenY)){
			table1True = true;
			System.out.println("table1 touched");
		}
		else if(table2.isTouchDown(screenX, screenY)){
			table2True = true;
			System.out.println("table2 touched");
		}
		
		for (Button thisButton : customButtons) {
			thisButton.isTouchDown(screenX, screenY);
		}

		return false;
	}
	
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		screenX = scaleX(screenX);
		screenY = scaleY(screenY);
		
		if(table.isTouchUp(screenX, screenY) || table1.isTouchUp(screenX, screenY) ||
					table2.isTouchUp(screenX, screenY)){
			return true;
		}
			
		
		for (Button thisButton : customButtons) {
			if (thisButton.isTouchUp(screenX, screenY)) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {

		return false;
	}

	@Override
	public boolean keyTyped(char character) {

		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {

		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {

		return false;
	}

	@Override
	public boolean scrolled(int amount) {

		return false;
	}
	
	private int scaleX(int screenX) {
		return (int) (screenX / scaleFactorX);
	}

	private int scaleY(int screenY) {
		return (int) (screenY / scaleFactorY);
	}

}
