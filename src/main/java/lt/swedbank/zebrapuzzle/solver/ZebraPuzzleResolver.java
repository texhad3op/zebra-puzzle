package lt.swedbank.zebrapuzzle.solver;

import java.util.List;

import lt.swedbank.zebrapuzzle.data.House;
import lt.swedbank.zebrapuzzle.data.ZebraPuzzleData;
import lt.swedbank.zebrapuzzle.engine.ZebraPuzzleEngine;
import lt.swedbank.zebrapuzzle.engine.ZebraPuzzleEngineFactory;
import lt.swedbank.zebrapuzzle.reader.ZebraPuzzleDataReader;
import lt.swedbank.zebrapuzzle.reader.ZebraPuzzleDataReaderFactory;
import lt.swedbank.zebrapuzzle.utils.FormatDescriber;
import lt.swedbank.zebrapuzzle.writer.ZebraPuzzleDataWriter;
import lt.swedbank.zebrapuzzle.writer.ZebraPuzzleDataWriterFactory;

public class ZebraPuzzleResolver {
	private FormatDescriber inData;
	private FormatDescriber outData;
	private ZebraPuzzleData zebraPuzzleData;
	private List<House[]> solution;

	public ZebraPuzzleResolver(FormatDescriber inData, FormatDescriber outData) {
		this.inData = inData;
		this.outData = outData;
	}

	public void readInput() {
		ZebraPuzzleDataReader reader = new ZebraPuzzleDataReaderFactory(inData)
				.getDataReader();
		zebraPuzzleData = reader.readData();
	}

	public void solve() {
		ZebraPuzzleEngine engine = new ZebraPuzzleEngineFactory(zebraPuzzleData)
				.getEngine();
		solution = engine.resolve();

	}

	public void writeOutput() {
		ZebraPuzzleDataWriter writer = new ZebraPuzzleDataWriterFactory(outData)
				.getDataWriter();
		writer.writeData(solution);
	}
}
