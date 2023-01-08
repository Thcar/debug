package tim;

import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		LinkedList<Place> placesToVisit = new LinkedList<>();
		
		Place adelaide = new Place("Adelaide", 1374);
		
		addPlace(placesToVisit, adelaide);
		addPlace(placesToVisit, new Place("Portland", 1343));
		
		System.out.println(placesToVisit);
	}

	private static void addPlace(LinkedList<Place> list, Place place) {
		for(Place p : list) {
			if(p.getName().equalsIgnoreCase(place.getName())) {
				System.out.println("found duplicate: " + place);
				return;
			}
		}
		
		sortList(list,place);
	}

	private static void sortList(LinkedList<Place> list, Place place) {
		int index = 0;
		for(var listPlace: list) {
			if(place.getDistance() < listPlace.getDistance()) {
				list.add(index, place);
				return;
			}
			index ++;
		}
		list.add(place);
	}
}
