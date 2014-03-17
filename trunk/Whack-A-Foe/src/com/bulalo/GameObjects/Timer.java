package com.bulalo.GameObjects;

import com.badlogic.gdx.utils.TimeUtils;

public class Timer {
	private long start;
	private long secsToWait;

	public Timer(long secsToWait) {
		this.secsToWait = secsToWait;
	}

	public void start() {
		start = TimeUtils.millis() / 1000;
	}

	public boolean hasCompleted() {
		return TimeUtils.millis() / 1000 - start >= secsToWait;
	}
}
