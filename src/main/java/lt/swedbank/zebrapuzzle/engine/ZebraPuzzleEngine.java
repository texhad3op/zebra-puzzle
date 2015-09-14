package lt.swedbank.zebrapuzzle.engine;

import java.util.List;

import lt.swedbank.zebrapuzzle.data.House;
import lt.swedbank.zebrapuzzle.data.ZebraPuzzleData;

public abstract class ZebraPuzzleEngine {
	protected ZebraPuzzleData zebraPuzzleData;

	public ZebraPuzzleEngine(ZebraPuzzleData zebraPuzzleData) {
		this.zebraPuzzleData = zebraPuzzleData;
	}

	public abstract List<House[]> resolve();
}