package lt.swedbank.zebrapuzzle.reader;

import lt.swedbank.zebrapuzzle.reader.impl.ZebraPuzzleCSVDataReader;
import lt.swedbank.zebrapuzzle.utils.FormatDescriber;
import lt.swedbank.zebrapuzzle.utils.ZebraPuzzleConstants;

public class ZebraPuzzleDataReaderFactory {
	FormatDescriber formatDescriber;

	public ZebraPuzzleDataReaderFactory(FormatDescriber formatDescriber) {
		this.formatDescriber = formatDescriber;
	}

	public ZebraPuzzleDataReader getDataReader() {
		if (ZebraPuzzleConstants.CSV_FORMAT.equalsIgnoreCase(formatDescriber
				.getFormat()))
			return new ZebraPuzzleCSVDataReader(formatDescriber);
		throw new RuntimeException("ZebraPuzzleDataReader for format "
				+ formatDescriber.getFormat() + " is not implemented yet.");
	}
}
