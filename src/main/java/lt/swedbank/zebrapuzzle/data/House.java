package lt.swedbank.zebrapuzzle.data;

import java.util.HashMap;
import java.util.Map;

public class House {

	private static final String POSITION = "position";
	private Map<String, String> properties = new HashMap<String, String>();

	public House(int position) {
		properties.put("position", Integer.toString(position));
	}

	@Override
	public House clone() {
		House house = new House(Integer.parseInt(getProperties().get(POSITION)));
		house.getProperties().putAll(getProperties());
		return house;
	}

	public Map<String, String> getProperties() {
		return properties;
	}
}