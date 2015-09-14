package lt.swedbank.zebrapuzzle.reader;

import lt.swedbank.zebrapuzzle.data.ZebraPuzzleData;
import lt.swedbank.zebrapuzzle.utils.FormatDescriber;

public abstract class ZebraPuzzleDataReader {
	protected FormatDescriber formatDescriber;

	public ZebraPuzzleDataReader(FormatDescriber formatDescriber) {
		this.formatDescriber = formatDescriber;
	}

	public abstract ZebraPuzzleData readData();
}