package com.bulalo.CustomizeWorld;

import java.util.List;

import com.badlogic.gdx.InputProcessor;
import com.bulalo.GameObjects.CustomDummy;
import com.bulalo.GameObjects.Tables;
import com.bulalo.UI.Button;

public class CustomInputHandler implements InputProcessor{
	private CustomWorld customWorld;
	
	
	private static boolean woodTrue;
	private static boolean steelTrue;
	private static boolean carbonTrue;
	
	private static boolean bossTrue;
	private static boolean farmerTrue;
	private static boolean boyTrue;
	
	private static List<Button> customButtons;
	private static List<Button> useButton;

	float scaleFactorX;
	float scaleFactorY;
	
	public CustomInputHandler(CustomWorld customWorld, float scaleFactorX,
			float scaleFactorY){
		this.customWorld = customWorld;
		
		customButtons = CustomWorld.getCustomButtons();
		useButton = CustomWorld.getUseButton();
		
		this.scaleFactorX = scaleFactorX;
        this.scaleFactorY = scaleFactorY;
	
	}
	
	public CustomInputHandler(){
		System.out.println("initialized");
	}
	
	public boolean checkTable(){
		return woodTrue;
	}
	
	public boolean checkTable1(){
		return steelTrue;
	}
	
	public boolean checkTable2(){
		return carbonTrue;
	}
	
	public boolean checkDummy2(){
		return boyTrue;
	}
	
	public boolean checkDummy1(){
		return farmerTrue;
	}
	
	public boolean checkDummy(){
		return bossTrue;
	}
	
	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		screenX = scaleX(screenX);
		screenY = scaleY(screenY);
		
		for (Button thisButton : customButtons) {
			thisButton.isTouchDown(screenX, screenY);
		
		}

		for (Button thisButton : useButton){
			thisButton.isTouchDown(screenX, screenY);
			
			if(useButton.get(0).isJustPressed()){
				woodTrue = true;
			}
			else if(useButton.get(1).isJustPressed()){
				steelTrue = true;
			}
			else if(useButton.get(2).isJustPressed()){
				carbonTrue = true;
			}
			
			if(useButton.get(3).isJustPressed()){
				bossTrue = true;
			}
			else if(useButton.get(4).isJustPressed()){
				farmerTrue = true;
			}
			else if(useButton.get(5).isJustPressed()){
				boyTrue = true;
			}
		}
		
		return false;
	}
	
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		screenX = scaleX(screenX);
		screenY = scaleY(screenY);
		
	
		for (Button thisButton : customButtons) {
			if (thisButton.isTouchUp(screenX, screenY)) {
				return true;
			}
		}
		
		for (Button thisButton : useButton) {
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
	
	public boolean falseCheck(){
		return woodTrue = false;
	}
	
	public boolean falseCheck1(){
		return steelTrue = false;
	}

	public boolean falseCheck2(){
		return carbonTrue = false;
	}
	
	public boolean falseDummy2(){
		return boyTrue = false;
	}

	public boolean falseDummy1(){
		return farmerTrue = false;
	}

	public boolean falseDummy(){
		return bossTrue = false;
	}

		
}
