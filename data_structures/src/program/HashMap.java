package program;

import java.util.Objects;

public class HashMap {

	//store all value in the form of node
	class HashNode{
		String key;
		String value;
		HashNode next;//to handle collision detection while inserting data in map in the same position
		public HashNode(String key, String value) {
			this.key = key;
			this.value = value;
		}
	}
	
	//all datas are stored similar to arrays
	private HashNode[] hashTable = null;
	
	//default size of hash table
	private int bucketSize = 16;
	
	private int size = 0;
	
	public HashMap() {
		this.hashTable = new HashNode[bucketSize];
	}
	
	public void put(String key, String value) {
		int position = getHashPosition(key);
		System.out.println("position : "+position + " ,key : "+key);
		HashNode curr = hashTable[position];
		if( Objects.isNull(curr) ) {
			hashTable[position] = new HashNode(key, value);
			size++;
		} else {
			while( Objects.nonNull(curr.next) && !(curr.key).equals(key) ) {
				curr = curr.next;
			}
			if( (curr.key).equals(key) ) {
				curr.value = value;
			} else {
				curr.next = new HashNode(key, value);
				size++;
			}
		}
	}
	
	private int getHashPosition(String key) {
		return Math.abs( key.hashCode() )% bucketSize;
	}

	public boolean containsKey(String key) {
		HashNode target = findNode(key);
		return target != null;
	}
	
	private HashNode findNode(String key) {
		int position = getHashPosition(key);
		HashNode targetNode = hashTable[position];
		if( targetNode == null) return null;
		else {
			while( targetNode.next != null && targetNode.key != key) {
				targetNode = targetNode.next;
			}
		}
		return targetNode;
	}

	public String get(String key) {
		HashNode target = findNode(key);
		if(target == null) return null;
		return target.value;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		size = 0;
		this.hashTable = new HashNode[bucketSize];
	}
	
	public boolean remove(String key) {
		int position = getHashPosition(key);
		if(hashTable[position] != null) {
			HashNode prev = null;
			HashNode curr = hashTable[position];
			while( curr != null && curr.key != key) {
				prev = curr;
				curr = curr.next;
			}
			if(curr == null) return false;
			if(prev == null && curr != null) {
				hashTable[position] = curr.next;
			} else {
				prev.next = curr.next;
				curr = null;
			}
			size--;
			return true;
		} else
			return false;
	}
	
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("{");
		for(int counter = 0; counter < bucketSize; counter++) {
			HashNode curr = hashTable[counter];
			if( Objects.nonNull(curr) ) {
				while( Objects.nonNull(curr) ) {
					buf.append(curr.key).append(" = ").append(curr.value)
					.append(", ");
					curr = curr.next;
				}
			}
		}
		if(buf.length() > 1) {
			buf.deleteCharAt(buf.length() - 2);
			buf.deleteCharAt(buf.length() - 1);
		}
		buf.append("}");
		return buf.toString();
	}
	
	public static void main(String[] args) {
		HashMap map = new HashMap();
		newValueInsertion(map);
		
//		addDuplicateValue(map);
		
		System.out.println(map);
		
//		checkContains(map);
		
//		getFromMap(map);
		
		System.out.println("isEmpty :" + map.isEmpty());
		map.clear();
		System.out.println("after clear isEmpty check :" + map.isEmpty());
//		removalFromMap(map);
		
		System.out.println(map);
	}

	private static void removalFromMap(HashMap map) {
//		System.out.println("remove key:one" + map.remove("one") );
		System.out.println("remove key:four" + map.remove("four") );
		System.out.println("remove key:five" + map.remove("five") );
		
	}

	private static void getFromMap(HashMap map) {
		System.out.println("get value of key one :"+map.get("one"));
		System.out.println("get value of key four :"+map.get("four"));
		System.out.println("get value of key five :"+map.get("five"));
	}

	private static void checkContains(HashMap map) {
		System.out.println( "is key one exists :"+map.containsKey("one") );
		System.out.println( "is key five exists :"+map.containsKey("five") );
		
	}

	private static void addDuplicateValue(HashMap map) {
		//Adding duplicate key in the map
		map.put("one", "modified");
		map.put("four", "newValue");
		
	}

	private static void newValueInsertion(HashMap map) {
		map.put("one", "ONE");
		map.put("two", "TWO");
		map.put("three", "THREE");
		map.put("four", "FOUR");//data collision occurred, to avoid this seperate chaining or address pointer should be used
		//In seperate chaining when the data collision occurs then next node is mapped for that data
//		map.put("six", "SIX");
//		map.put("seven", "SEVEN");
//		map.put("eight", "EIGHT");
//		map.put("nine", "NINE");
//		map.put("ten", "TEN");
//		map.put("eleven", "ELEVEN");
		
	}

}
