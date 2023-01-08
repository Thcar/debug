package tmc;

public class Town {

	private String name;
	private int distance;

	public Town(String name, int distance) {
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
		return String.format("%s (%d km)", name, distance);
	}
}
