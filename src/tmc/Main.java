package tmc;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	
	private static Scanner scanner = new Scanner(System.in);
	private static boolean flag = true;

	public static void main(String[] args) {
		
		LinkedList<Town> listOfPlaces = new LinkedList<>();
		
		addPlaces(listOfPlaces, new Town("Sidney", 0));
		addPlaces(listOfPlaces,	new Town("Alice Springs", 2771));
//		addPlaces(listOfPlaces,	new Town("Alice Springs", 2771));
		addPlaces(listOfPlaces, new Town("Brisbane", 917));
		addPlaces(listOfPlaces, new Town("Darwin", 3972));
//		addPlaces(listOfPlaces, new Town("Perth", 3923));
//		addPlaces(listOfPlaces, new Town("Adelaide", 1374));
		
		ListIterator<Town> listIterator = listOfPlaces.listIterator();
		
		printMenu();
		
		while(Main.flag) {
			
			String action = Main.scanner.nextLine().substring(0, 1).toUpperCase();
			
			switch (action) {
			case "F":
				if(listOfPlaces.isEmpty()) {
					System.out.println("the list is empty - load it");
					return;
				} else {
					Town next = listIterator.next();
					System.out.println(next.toString());
//					if(!listIterator.hasNext()) {
//						System.out.println("list is done - reload again");
//						Main.flag = false;
//					}
					break;
				}
				
			case "B":
				if(listOfPlaces.isEmpty()) {
					System.out.println("the list is empty - load it");
					return;
				} else {
//					int previousIndex = listIterator.previousIndex();
//					previousIndex--;
					if(listIterator.hasPrevious()) {
						Town previous = listIterator.previous();
						System.out.println(previous.toString());
					} else {
						System.out.println("this is the first element - reload again");
						Main.flag = false;
					}
					
					break;
				}
				
			case "L":
				printPlaces(listOfPlaces);
				break;
				
			case "M":
				printMenu();
				break;
				
			case "Q":
				Main.flag = false;
				break;

			default:
				break;
			}
		}
	}

	private static void addPlaces(LinkedList<Town> list, Town town) {
		//filter
		for(int index = 0; index < list.size(); index++) {
			if(town.getName().equalsIgnoreCase(list.get(index).getName())) {
				System.out.println("place already at list");
				return;
			}
		}
		
		//sort by distance
		int index = 0;
		for(Town item: list) {
			if(town.getDistance() < item.getDistance()) {
				list.add(index,town);
				return;//pq eu vou adicionar de um em um;
			}
			index++;
		}
		list.add(town);//eu sei que é o último da fila;
	}

	private static void printPlaces(LinkedList<Town> list) {
		if(list.isEmpty()) {
			System.out.println("the list is empty");
			return;
		}
		ListIterator<Town> listIterator = list.listIterator();
		while(listIterator.hasNext()) {
			System.out.println(listIterator.next().toString());
		}
	}

	private static void printMenu() {
		System.out.println("\nAvailable actions (Select word or letter): \n"
				+ "(F)orward \n"
				+ "(B)ackward \n"
				+ "(L)ist Places \n"
				+ "(M)enu \n"
				+ "(Quit)");
	}
}
