/** JAVA tips ** 

1. Type Conversions
2. Sorting
3. SUB: 
4. binarySearch

*****************/

/** 1. Type Conversions **/
// Character -> Integer
char c = '9';
int num = 9;
int charToNum = c-'0';
System.out.println(num == charToNum);

// Integer -> String
int num = 123;
String str = "123";
String s1 = String.valueOf(num);
String s2 = Integer.toString(num);
System.out.println((s1).equals(str));
System.out.println((s2).equals(str));

// String -> Integer
String str = "123";
int num = 123;
int strToNum = Integer.parseInt(str);
System.out.println(num == strToNum);

// String -> char[]
String str = "aabbcc123";
char[] cs = str.toCharArray();

// Array -> List
String[] arr = new String[]{"1", "a", "1234"};
List<String> list = Arrays.asList(arr);
List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);

// // List -> Array
List<String> list1 = new ArrayList<>();
// ... add element into list1 ...  
String[] arr1 = list1.toArray(new String[list1.size()]);
List<Integer> list2 = new ArrayList<>();
// ... add element into list2 ...  
Integer[] arr2 = list2.toArray(new Integer[list2.size()]); // NOT "primitive type" int

// List -> Hash Set
List<Integer> list = new ArrayList<>();
Set<Integer> set = new HashSet<>(list);

// Arrays -> String
int[] arr = new int[]{1, 2, 3, 4, 5};
String str = Arrays.toString(arr);

// if ( List == Array ) ?
List<Integer> list = new ArrayList<>();
Integer[] arr = new Integer[]{1,2,3}; // NOT int, object Integer
System.out.println(list.equals(Arrays.asList(arr)));


/** 2. Sorting **/
// Array Sort
int[] arr = new int[]{1,5,4,6,2,3,4};
Arrays.sort(arr); // ascending order => {1,2,3,4,4,5,6}
Arrays.sort(); // desecneding order => {6,5,4,4,3,2,1}

// Collection Sort
List<Integer> list = Arrays.asList(5, 4, 1, 2, 8);
Collections.sort(list); // ascending order
/* class Score {
	int player_id;
	int score;
	Score(int id, int score) {
		player_id = id;
		this.score = score;
	}
} */
List<Score> list2 = new ArrayList<>();
// .... add element into list2 .... 
Collections.sort(list2, (a,b) -> a.score - b.score); // ascending order by score
Collections.sort(list2, (a,b) -> b.score - a.score); // descending order by score
/* If type of score is Double ? */
/* class Score {
	int player_id;
	double score;
	Score(int id, double score) {
		player_id = id;
		this.score = score;
	}
} */
Collections.sort(list2, (a,b) -> Double.compare(a.score, b.score)); // ascending order by score
Collections.sort(list2, (a,b) -> Double.compare(b.score, a.score)); // descending order by score

// Heap Sort
PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a - b); // ascending order by element
PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a); // descending order by element
/* If elements are sorted by values in the map */
Map<Integer, Integer> map = new HashMap<>();
PriorityQueue<Integer> pq = new PriorityQueue<>( // ascending order by values in map
	(a,b) -> map.get(a) - map.get(b)
);
/* If tyep of value in the map is Double, */
Map<Integer, Double> map = new HashMap<>();
PriorityQueue<Integer> pq = new PriorityQueue<>(
	(a,b) -> Double.compare(map.get(a), map.get(b))
);
/* If tyep of value in the map is String, */
Map<Integer, String> map = new HashMap<>();
PriorityQueue<Integer> pq = new PriorityQueue<>(
	(a,b) -> map.get(a).compareTo(map.get(b))
);


/** 3. SUB: **/
// substring
str.substring(i, j); // [i:j)
str.substring(start); // [start:)
list.subList(start, end); //[start:end)


/** 4. binarySearch **/
// return the idx which is eqaul to or greater than (int) x 
int idx = Collections.binarySearch(list, x);
if(idx<0) {
	idx =- (idx + 1);
}
// if exact x value is not in the list, idx will be negative and it will add -1 too
// SO, returned idx should be +1 and then put minus on it "idx=-(idx+1)"


