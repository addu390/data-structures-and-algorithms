package dataStructures;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import java.util.*;

/**
 * Yes, Hashing is a technique.
 * Search, Insert and Delete in O(1).
 * No duplicates allowed.
 * Binary search tree: Takes O(log n) for Search, Insert and Delete.
 *
 * When to not use hashing:
 * 1. Finding closest values.
 * 2. Keeping data in Sorted order.
 * 3. Prefix searching - TRIE data structure.
 * 1 and 2 - Use case for a self balancing B search tree.
 *
 * Probably the most used data-structure - Hash tables.
 * Commonly used: Used as Dictionaries and for indexing (Or a B tree).
 */
public class Hashing {

    public static void main(String[] args) {

        hastSet();
        hastMap();

        int[] ints = new int[]{2, 1, 2, 3, 1, 10};
        System.out.println("Distinct elemets count is: " + countDistinctElements(ints));
        findFrequency(ints);
        findFrequencyWithOrder(ints);

        int[] intsA = new int[]{10, 15, 20, 15, 30, 30, 5};
        int[] intsB = new int[]{30, 5, 30, 80};
        System.out.println("Intersection count: " + intersection(intsA, intsB));
        System.out.println("Distinct Intersection count: " + distinctIntersection(intsA, intsB));
        System.out.println("Union count: " + union(intsA, intsB));

        int[] sum = new int[]{2, 4, 6, 3};
        System.out.println("Is Sum pair present: " + sumPair(sum, 10));

        int[] zero = new int[]{2, 4, -6, 3};
        System.out.println("Is SUB ZERO present: " + subZero(zero));

        System.out.println("Is given sum sub-array sum present: " + subSumArray(sum, 10));

        int[] longest = new int[]{2, 2, 4, 2, 2, 4, -6, 3};
        System.out.println("Is given sum longest sub-array sum present: " + longestSubSumArray(longest, 10));

        int[] ones = new int[]{0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Is given sum longest sub-array (1s and 0s) sum present: " + longestSubArray(ones));

        int[] one = new int[]{0, 0, 1, 0, 1, 1, 0, 0};
        int[] two = new int[]{1, 1, 1, 0, 1, 1, 0, 1};
        System.out.println("Longest binary sub-array sum: " + longestSubArray(one, two));

        int[] consecutive = new int[]{1, 2, 9, 3, 4};
        System.out.println("Longest Consecutive array: " + longestConsecutiveElements(consecutive));

        int[] distinct = new int[]{10, 20, 10, 10, 30, 40};
        distinctElementsWindow(distinct, 4);

        int[] nByK = new int[]{30, 10, 20, 20, 20, 10, 40, 30, 30};
        nByKOccurrence(nByK, 4);
    }

    /**
     * A typical direct address table would be an array where keys are indexes.
     * But other keys cannot be big values or float (a 20 digit number for instance) or other objects such as Strings.
     * Hence the need for hashing.

     * The idea of hashing is that, it is still backed by an array.
     * Where an key is the input to a hashing function which returns an Index of the array.
     * (Universe of keys) -> (Hash function) -> Array - Hash table.
     * The major concern
     * 1. is to ensure that collision does not occur
       (Hash function returning the same value for two or more different keys).
     * 2. The size of the hashtable is proportional to the number of entries
       (Example: When number of entries is 3, size of hashtable cannot be a lakh!).
     * Example hash function for a string, str[] = "abcd"
     * (str[0]*(x^0) + str[1]*(x^1) + str[2]*(x^2) + str[3]*(x^3)) % m, (modulo division) where m is the table size.
       Modulo division to ensure number of entries and size of the hash-table is not too far apart.

     * Universal Hashing:
     * Set of hash function, randomly pick one among them.

     * Collision handling: When 2 large keys produce the same small key (of hash-table).
     * Birthday Paradox: Among 23, probability that 2 of them have birthday on the same day is 50%
       and for 70, probability is 99.9%.
     * Collision are bound to happen! Unless the keys are known before (Perfect hashing).
     * To prevent collision:
     * 1. Chaining: Hashtable is array of linked list headers, when every collision occur,
        you add an other node to the linked list.
        Load factor = (Number of keys to be inserted/ number of slots in hash table).
        Can be specified, to specify how big the hash-table is.
        Smaller the value, smaller is the size of hash table.
     * Expected chain length = load factor (Assuming they are equally distributed among all the linked-lists.)
        Hence, expected time to search/Insert/Delete now is O(1 + Load factor).
     * Other data structures for chaining:
        1. Linked list.
        2. Dynamic sized Arrays (Array-list).
        3. Self balancing BST (AVL, Red-black tree) - Used in Java 8 for hashing.

     * 2. Open addressing.
     * Use single array, hence size of the hash table should be a minimum of number of keys.
     * Collision handling techniques:
        a. Linear probing: Linearly search for next empty spot when there is a collision.
           If last slot is occupied, start from first (Circular manner).
           Search until a key is found/ next empty slot/ all elements are traversed.
           For delete: Marking it as empty will hamper the search, hence mark it as "DELETED" and search is not stopped
            when "DELETED", but insert use "DELETED" slots.
           As the cluster size increases, the complexity increases, hence impacting performance.
           (Hash(key) + i) % m
            Primary clustering.
        b. Quadratic probing: (Hash(key) + i^2) % m - Instead going to the next slot, go to the i^2 slot.
            Secondary clusters.
            Possibility of not finding empty slots.
            Load factor = 0.5 (Hash table is double) and m is prime, then Quadratic probing is guaranteed to work.
        c. Double hashing: Hash(key, i) = (h1(key) + i*h2(key)) % m
            i*h2(key) is the offset, for linear probing - offset is 1.
            example: h1 = key % 7 and h2 = 6 - (key % 6), where size of the hashtable is 6.
            When ever a collision happens, i is incremented.
            Uses two hash functions.
            No clustering.
            If h2(key) and m are relatively prime, we will mostly find a new slot.
     *
     */
    public static void hash() {

    }

    /**
     * Hashset in JAVA.
     * Datatype cannot be primitive.
     * Order is not defined while printing contents.
     * Complexity: O(1) on an average.
     * Can only store keys.
     */
    public static void hastSet() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("test1");
        hashSet.add("test2");
        boolean isPresent = hashSet.contains("test1");
        hashSet.remove("test1");

        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (String s: hashSet) {
            System.out.println(s);
        }
        hashSet.clear();
        System.out.println(hashSet.size());
    }

    /**
     * Used to store key-value pairs.
     * HashMap extends the MAP (key value) interface.
     * Order cannot be defined.
     * Put, contains, get etc have a time complexity of O(1) on Average.
     */
    public static void hastMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value3");
        map.remove("key2");
        System.out.println(map.size());

        for (Map.Entry<String, String> s: map.entrySet()) {
            System.out.println(s.getKey() + s.getValue());
        }
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public static int countDistinctElements(int[] ints) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i: ints) {
            hashSet.add(i);
        }
        return hashSet.size();
    }

    public static HashMap<Integer, Integer> findFrequency(int[] ints) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i: ints) {
            if (map.containsKey(i)) {
                int count = map.get(i);
                map.replace(i, count + 1);
            } else {
                map.put(i, 1);
            }
        }
        for (Map.Entry<Integer, Integer> s: map.entrySet()) {
            System.out.println(s.getKey() + " --> " + s.getValue());
        }
        return map;
    }

    public static LinkedHashMap<Integer, Integer> findFrequencyWithOrder(int[] ints) {

        /**
         * A linkedHashMap maintains the order, what is inserted first into the hashmap,
         * will be present at the first in the LinkedHashMap.
         */
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i: ints) {
            if (map.containsKey(i)) {
                int count = map.get(i);
                map.replace(i, count + 1);
            } else {
                map.put(i, 1);
            }
        }
        for (Map.Entry<Integer, Integer> s: map.entrySet()) {
            System.out.println(s.getKey() + " --> " + s.getValue());
        }
        return map;
    }

    public static int intersection(int[] intsA, int[] intsB) {
        int counter = 0;
        LinkedHashMap<Integer, Integer> hashMap = findFrequencyWithOrder(intsA);
        for (Integer i : intsB) {
            if (hashMap.containsKey(i)) {
                counter = counter + 1;
            }
        }
        return counter;
    }

    /**
     * In this solution to get distinct intersection we maintain a count,
     * alternatively, we can remove it from the map (without count - SET can be used).
     * But, count is better as data is not mutated!
     */
    public static int distinctIntersection(int[] intsA, int[] intsB) {
        int counter = 0;
        LinkedHashMap<Integer, Integer> hashMap = new LinkedHashMap<>();
        for (int i: intsA) {
            hashMap.put(i, 0);
        }

        for (Integer i : intsB) {
            if (hashMap.containsKey(i) && hashMap.get(i) == 0) {
                counter = counter + 1;
                hashMap.replace(i, hashMap.get(i) + 1);
            }
        }
        return counter;
    }

    /**
     * Return the count of the union set.
     *
     */
    public static int union(int[] intsA, int[] intsB) {
        HashSet<Integer> set = new HashSet<>();

        for (Integer i: intsA) {
            set.add(i);
        }

        for (Integer k: intsB) {
            set.add(k);
        }

        return set.size();
    }

    // 2, 4, 6, 3 - 9
    public static boolean sumPair(int[] intsA, int sum) {
        HashSet<Integer> set = new HashSet<>();

        for (Integer i: intsA) {
            if (set.contains(sum - i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }


    /**
     * Return True if the array has a sub array who sum is Zero.
     * If the prefix SUM array contains duplicates, it means that there is a subarray with SUM ZERO
     * Or if ZERO is present in the prefix SUM array.
     */
    public static boolean subZero(int[] intsA) {

        int[] sumArray = new int[10];
        HashSet<Integer> set = new HashSet<>();

        sumArray[0] = intsA[0];
        set.add(sumArray[0]);

        for (int i = 1; i < intsA.length; i++) {
            sumArray[i] = sumArray[i - 1] + intsA[i];
            if (set.contains(sumArray[i]) || sumArray[i] == 0) {
                return true;
            }
            set.add(sumArray[i]);
        }
        return false;
    }

    /**
     * Find if a sub-array is present with the given SUM.
     * Similar to the prior problem (SUM is ZERO for prior problem)
     */
    public static boolean subSumArray(int[] intsA, int sum) {
        int sumValue = 0;
        HashSet<Integer> set = new HashSet<>();

        sumValue = intsA[0];
        set.add(sumValue);

        for (int i = 1; i < intsA.length; i++) {
            sumValue = sumValue + intsA[i];
            if (set.contains(sumValue - sum) || sumValue == sum) {
                return true;
            }
            set.add(sumValue);
        }
        return false;
    }

    /**
     * Hint: Use a hashmap and also store the index (first occurrence) of each element.
     */
    public static int longestSubSumArray(int[] intsA, int sum) {
        int sumValue = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;

        sumValue = intsA[0];
        map.put(sumValue, 0);

        for (int i = 1; i < intsA.length; i++) {
            sumValue = sumValue + intsA[i];
            if (map.containsKey(sumValue - sum)) {
                max = Math.max(i - map.get(sumValue - sum), max);
            } else {
                map.put(sumValue, i);
            }

            if (sumValue == sum) {
                max = Math.max(max, i + 1);
            }
        }
        return max;
    }

    /**
     * Longest subarray with equal number of 1s and 0s.
     * With 1s nd 0s replaced with -1, the problem reduces to finding the longest sub-array with SUM = 0
     */
    public static int longestSubArray(int[] intsA) {

        for (int i = 0; i < intsA.length; i++) {
            if (intsA[i] == 0) {
                intsA[i] = -1;
            }
        }

        return longestSubSumArray(intsA, 0);
    }

    /**
     * Longest span of sub-srray with the same sum.
     * Both the sub-array should be of the same start and end index.
     * But 1s and 0s can be ordered in a different way.
     * Note: Length of both the binary arrays are same.
     *
     * Solution: intsA - intsB, then the result is intsC,
     * Find the longest sub-array with sum as ZERO
     */
    public static int longestSubArray(int[] intsA, int[] intsB) {
        int[] intsC = new int[intsA.length];
        for (int i = 0; i < intsA.length; i++) {
            intsC[i] = intsA[i] - intsB[i];
        }
        return longestSubSumArray(intsC, 0);

    }

    /**
     * To find if an array contains consecutive numbers in any order.
     * If yes, which is the longest one.
     */
    public static int longestConsecutiveElements(int[] intsA) {
        HashSet<Integer> set = new HashSet<>();
        int max = 0;

        for (int i = 0; i < intsA.length; i++) {
            set.add(intsA[i]);
        }

        for (int i = 0; i < intsA.length; i++) {
            if (!set.contains(intsA[i] - 1)) {
                int current = 1;
                while (set.contains(intsA[i] + current)) {
                    current++;
                    max = Math.max(current, max);
                }
            }
        }
        return max;
    }

    /**
     * Count the number of distinct elements in each window.
     * Number of windows : Total number of elements - window size + 1;
     * The idea is to add all the elements in the first window to the hashmap with the count.
     * in the next window, remove the first first element and add the next element of the window.
     * And then add the size of the hashmap to the new array folder the number of distinct elements.
     */
    public static void distinctElementsWindow(int[] intsA, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] distinct = new int[intsA.length - k + 1];
        int current = 0;

        for (int i = 0; i < k - 1; i++) {
            if (map.containsKey(intsA[i])) {
                map.put(intsA[i], map.get(intsA[i]) + 1);
            } else {
                map.put(intsA[i], 1);
            }
        }
        distinct[current] = map.size();

        for (int i = k; i < intsA.length; i++) {

            if (map.containsKey(intsA[current]) && map.get(intsA[current]) == 1) {
                map.remove(intsA[current]);
            } else if (map.containsKey(intsA[current]) && map.get(intsA[current]) > 1) {
                map.put(intsA[current], map.get(intsA[current] - 1));
            }

            if (map.containsKey(intsA[i])) {
                map.put(intsA[i], map.get(intsA[i] + 1));
            } else {
                map.put(intsA[i], 1);
            }
            current++;
            distinct[current] = map.size();
        }

        for (Integer i: distinct) {
            System.out.println(i);
        }
    }

    /**
     * Extension of moores's voting algorithm.
     * to find the number of elements which are repeated more than n/k times.
     * Number of such elements cannot be more than (k-1).
     * Time complexity: O(n * k).
     * The rejection: When a new element occurs and the map is full, we reduce the count and even the new element is not considered.
     * This is valid because the maximum number of occurrences is k or more for a given term.
     */
    public static void nByKOccurrence(int[] intsA, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < intsA.length; i++) {
            if (map.containsKey(intsA[i])) {
                map.put(intsA[i], map.get(intsA[i]) + 1);
            }

            if (map.size() < k && !map.containsKey(intsA[i])) {
                map.put(intsA[i], 1);
            }

            if (!map.containsKey(intsA[i]) && map.size() >= k) {
                for (Map.Entry<Integer, Integer> m: map.entrySet()) {
                    if (m.getValue() == 1) {
                        map.remove(m.getKey());
                    } else {
                        map.replace(m.getKey(), m.getValue() - 1);
                    }
                }
            }
        }

        int nByK = 0;
        for (Map.Entry<Integer, Integer> m: map.entrySet()) {
            for (int i = 0; i < intsA.length; i++) {
                if (intsA[i] == m.getKey()) {
                    nByK++;
                }
            }
            if (nByK > (intsA.length / k)) {
                System.out.println(m.getKey());
            }
            nByK = 0;
        }
    }




}
