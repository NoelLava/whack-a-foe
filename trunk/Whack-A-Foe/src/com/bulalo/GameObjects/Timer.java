package com.bulalo.GameObjects;

import com.badlogic.gdx.utils.TimeUtils;

public class Timer {
	private long start;
	private long secsToWait;
	public boolean isRunning;

	public Timer(long secsToWait) {
		this.secsToWait = secsToWait;
	}

	public void start() {
		start = TimeUtils.millis() / 1000;
		isRunning = true;
	}
	
	public void pause(){
		System.out.println("timer paused");
	}
	
	public void resume(){
		System.out.println("resume timer");
	}

	public boolean hasCompleted() {
		if( TimeUtils.millis() / 1000 - start >= secsToWait){
			isRunning = false;
			return true;
		}else{
			return false;
		}
	}
}
