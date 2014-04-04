package com.bulalo.FileUpload;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

public class Upload {
	private static Texture image;
	
	
	
	public void getTexture(){
		
		//FileHandle img = Gdx.files.absolute("storage/sdcard0/DCIM/try.jpg");
		//load from desktop
		FileHandle img = Gdx.files.external("try.jpg");
		
		image = new Texture(img); 
		
	}
	
	public void populateFiles(){
		FileHandle[] files = Gdx.files.external("").list();
		for(FileHandle file : files){
			System.out.println(file.toString());
		}
	}
	
	public Texture getImage(){
		return image;
	}
}
