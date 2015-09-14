package lt.swedbank.zebrapuzzle.writer;

import lt.swedbank.zebrapuzzle.utils.FormatDescriber;
import lt.swedbank.zebrapuzzle.utils.ZebraPuzzleConstants;
import lt.swedbank.zebrapuzzle.writer.impl.ZebraPuzzleXMLDataWriter;

public class ZebraPuzzleDataWriterFactory {
	FormatDescriber formatDescriber;

	public ZebraPuzzleDataWriterFactory(FormatDescriber formatDescriber) {
		this.formatDescriber = formatDescriber;
	}

	public ZebraPuzzleDataWriter getDataWriter() {
		if (ZebraPuzzleConstants.XML_FORMAT.equalsIgnoreCase(formatDescriber
				.getFormat()))
			return new ZebraPuzzleXMLDataWriter(formatDescriber);
		throw new RuntimeException("ZebraPuzzleDataReader for format "
				+ formatDescriber.getFormat() + " is not implemented yet.");
	}
}
