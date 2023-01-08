package tim;

public class Place {

	private String name;
	private int distance;

	public Place(String name, int distance) {
		this.name = name;
		this.distance = distance;
	}

	public int getDistance() {
		return distance;
	}

	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return String.format("%s (%d)" ,name, distance);
	}
}
