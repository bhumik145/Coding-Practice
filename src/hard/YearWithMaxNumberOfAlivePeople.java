package hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class YearWithMaxNumberOfAlivePeople {

	public static int getYearWithMaxNumberOfAlivePeople(int[][] lifespans) {
		Map<Integer, Integer> yearToNumberOfPeopleAliveMapping = new HashMap<>();
		// Keys can be birth year, I don't have to track all the years

		int start;
		int end;

		for (int index = 0; index < lifespans.length; index++) {
			start = lifespans[index][0];
			yearToNumberOfPeopleAliveMapping.put(start, 0);
		}

		for (int index = 0; index < lifespans.length; index++) {
			start = lifespans[index][0];
			end = lifespans[index][1];
			for (int year = start; year <= end; year++) {
				if (yearToNumberOfPeopleAliveMapping.containsKey(year)) {
					yearToNumberOfPeopleAliveMapping.put(year, yearToNumberOfPeopleAliveMapping.get(year) + 1);
				} else {
					yearToNumberOfPeopleAliveMapping.put(year, 1);
				}
			}
		}

		int maxNumberOfPeopleAliveInAGivenYear = Integer.MIN_VALUE;
		int yearWithMaxNumberOfPeopleAlive = -1;
		for (Entry<Integer, Integer> yearToNumberOfPeople : yearToNumberOfPeopleAliveMapping.entrySet()) {
			if (maxNumberOfPeopleAliveInAGivenYear < yearToNumberOfPeople.getValue()) {
				maxNumberOfPeopleAliveInAGivenYear = yearToNumberOfPeople.getValue();
				yearWithMaxNumberOfPeopleAlive = yearToNumberOfPeople.getKey();
			}
		}
		System.out.println("maxNumberOfPeopleAliveInAGivenYear: " + maxNumberOfPeopleAliveInAGivenYear);
		System.out.println("yearWithMaxNumberOfPeopleAlive : " + yearWithMaxNumberOfPeopleAlive);
		return yearWithMaxNumberOfPeopleAlive;
	}

	public static int[] getRange(int[][] lifespans) {

		int start = Integer.MAX_VALUE;
		int end = Integer.MIN_VALUE;
		for (int index = 0; index < lifespans.length; index++) {
			if (start < lifespans[index][0]) {
				start = lifespans[index][0];
			}
			if (end > lifespans[index][1]) {
				end = lifespans[index][1];
			}
		}
		int[] range = { start, end };
		return range;
	}

	public static void main(String[] args) {

		int[][] lifespans = { { 1900, 1990 }, { 1991, 2000 }, { 1985, 2000 }, { 1921, 1990 }, { 1955, 2000 } };

		getYearWithMaxNumberOfAlivePeople(lifespans);
	}
}
