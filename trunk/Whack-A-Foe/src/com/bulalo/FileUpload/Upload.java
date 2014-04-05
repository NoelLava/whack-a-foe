package com.bulalo.FileUpload;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

public class Upload {
	private static Texture image;
	private FileHandle img;
	public void getTexture(String texture){
		
		//FileHandle img = Gdx.files.absolute("storage/sdcard0/DCIM/try.jpg");
		//load from desktop
		this.img = Gdx.files.external(texture);
		
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
