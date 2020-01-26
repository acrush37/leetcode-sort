package medium;

import java.util.*;

/*
    Given the array restaurants where  restaurants[i] = [idi, ratingi, veganFriendlyi, pricei, distancei].
    You have to filter the restaurants using three filters.

    The veganFriendly filter will be either true (meaning you should only include restaurants
    with veganFriendlyi set to true) or false (meaning you can include any restaurant).

    In addition, you have the filters maxPrice and maxDistance which are the maximum
    value for price and distance of restaurants you should consider respectively.

    Return the array of restaurant IDs after filtering, ordered by rating from highest to lowest.
    For restaurants with the same rating, order them by id from highest to lowest. For simplicity veganFriendlyi and veganFriendly take value 1 when it is true, and 0 when it is false.
 */
public class FilterRestaurants {

    public static void main(String... args) {

        int[][] restaurants = {{1,4,1,40,10}, {2,8,0,50,5}, {3,8,1,30,4}, {4,10,0,10,3}, {5,1,1,15,1}};
        FilterRestaurants filterRestaurants = new FilterRestaurants();
        System.out.println(filterRestaurants.filterRestaurants(restaurants, 0, 30, 3));
    }

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {

        Map<Integer, Set<Integer>> t = new TreeMap<>(Comparator.reverseOrder());

        for (int[] x : restaurants)
            if (x[2] >= veganFriendly && x[3] <= maxPrice && x[4] <= maxDistance) {
                t.putIfAbsent(x[1], new TreeSet<>(Comparator.reverseOrder()));
                t.get(x[1]).add(x[0]);
            }

        List<Integer> result = new ArrayList<>();
        Collection<Set<Integer>> values = t.values();
        for (Set<Integer> set : values) result.addAll(set);
        return result;
    }

}
