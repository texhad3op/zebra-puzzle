package lt.swedbank.zebrapuzzle.engine;

import lt.swedbank.zebrapuzzle.data.ZebraPuzzleData;
import lt.swedbank.zebrapuzzle.engine.impl.ZebraPuzzleBruteForceEngine;
import lt.swedbank.zebrapuzzle.engine.impl.ZebraPuzzleSmartEngine;

public class ZebraPuzzleEngineFactory {
	ZebraPuzzleData zebraPuzzleData;

	public ZebraPuzzleEngineFactory(ZebraPuzzleData zebraPuzzleData) {
		this.zebraPuzzleData = zebraPuzzleData;
	}

	public ZebraPuzzleEngine getEngine() {
		if (7 >= zebraPuzzleData.getHousesQty())
			return new ZebraPuzzleBruteForceEngine(zebraPuzzleData);
		if (8 <= zebraPuzzleData.getHousesQty())
			return new ZebraPuzzleSmartEngine(zebraPuzzleData);
		throw new RuntimeException(
				"Can't find appropriate engine to resolve Zebra Puzzle");
	}
}
