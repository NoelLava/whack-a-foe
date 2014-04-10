package com.bulalo.CustomizeWorld;

import java.util.List;
import java.util.Scanner;

import com.badlogic.gdx.InputProcessor;
import com.bulalo.FileUpload.Upload;
import com.bulalo.Helpers.AssetLoader;
import com.bulalo.UI.Button;

public class CustomInputHandler implements InputProcessor{
	Scanner input = new Scanner(System.in);
	CustomWorld customWorld;
	Upload upload = new Upload();
	private static String source;
	private static boolean woodTrue,steelTrue,carbonTrue,
							bossTrue,farmerTrue,boyTrue,customDummy;

	private static List<Button> customButtons,useButton;

	float scaleFactorX,scaleFactorY;
	
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
		source = "";
	}
	
	public boolean checkTable(){
		return woodTrue;
	}
	
	public boolean checkTable1(){
		return steelTrue;
	}
	
	public void setCustomDummyFalse(){
		customDummy = false;
	}
	
	public boolean checkCustomDummy(){
		return customDummy;
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
			if(customButtons.get(7).isJustPressed()){
				boyTrue = false;
				bossTrue = false;
				farmerTrue = false;
				customDummy = true;
				System.out.println("Input image source here: ");
				source = input.nextLine();
				upload.getTexture(source);
				AssetLoader.updateUpload();
				break;
			}
			for (Button thisUseButton : useButton){
				thisUseButton.isTouchDown(screenX, screenY);
				
				if(useButton.get(0).isJustPressed()){
					steelTrue = false;
					carbonTrue = false;
					woodTrue = true;
				}
				else if(useButton.get(1).isJustPressed()){
					woodTrue = false;
					carbonTrue = false;
					steelTrue = true;
				}
				else if(useButton.get(2).isJustPressed()){
					woodTrue = false;
					steelTrue = false;
					carbonTrue = true;
				}
				
				if(useButton.get(3).isJustPressed()){
					boyTrue = false;
					farmerTrue = false;
					bossTrue = true;
					customDummy = false;
				}
				else if(useButton.get(4).isJustPressed()){
					boyTrue = false;
					bossTrue = false;
					farmerTrue = true;
					customDummy = false;
				}
				else if(useButton.get(5).isJustPressed()){
					bossTrue = false;
					farmerTrue = false;
					boyTrue = true;
					customDummy = false;
				}
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
