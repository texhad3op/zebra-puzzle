package lt.swedbank.zebrapuzzle.engine.impl;

import java.util.List;

import lt.swedbank.zebrapuzzle.data.House;
import lt.swedbank.zebrapuzzle.data.ZebraPuzzleData;
import lt.swedbank.zebrapuzzle.engine.ZebraPuzzleEngine;

public class ZebraPuzzleSmartEngine extends ZebraPuzzleEngine {
	public ZebraPuzzleSmartEngine(ZebraPuzzleData zebraPuzzleData) {
		super(zebraPuzzleData);
	}

	public List<House[]> resolve() {
		throw new RuntimeException(
				"ZebraPuzzleSmartEngine is not implemented yet");
	}

}
