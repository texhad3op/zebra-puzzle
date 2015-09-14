package lt.swedbank.zebrapuzzle.writer;

import java.util.List;

import lt.swedbank.zebrapuzzle.data.House;
import lt.swedbank.zebrapuzzle.utils.FormatDescriber;

public abstract class ZebraPuzzleDataWriter {
	protected FormatDescriber formatDescriber;

	public ZebraPuzzleDataWriter(FormatDescriber formatDescriber) {
		this.formatDescriber = formatDescriber;
	}

	public abstract void writeData(List<House[]> solution);
}