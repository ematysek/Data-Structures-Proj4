import java.util.LinkedList;


public class HashTable {

	private LinkedList<String>[] table;
	private double size;
	
	private static final double invGRatio = 0.618033;
	private static final int primeNum = 31;
	
	
	public HashTable(int size){
		this.table = new LinkedList[size];
		this.size = size;
	}
	
	public int getHashValue(String s){
		int hash = 1;
		for(int i = 0; i < s.length(); i++){
			hash = hash*primeNum+s.charAt(s.length()-1-i);
		}
		return hash;
	}
	
	public int hash(int hashValue){
		double hash = hashValue;
		return (int) Math.floor(size*(hash*invGRatio-Math.floor(hash*invGRatio)));
	}
	
	public int getIndex(String s){
		int hashValue = getHashValue(s);
		int index = hash(hashValue);
		if(index > (size-1)){
			System.out.println(s+ " could not be inserted because the index > table size\n");
			return 0;
		}
		return index;
	}
	
	public void insert(String s){
		int index = getIndex(s);
		if(table[index] == null){
			table[index] = new LinkedList<String>();
		}
		table[index].addFirst(s);
	}
	
	public boolean contains(String s){
		int index = getIndex(s);
		if(table[index] == null){
			return false;
		}
		if(table[index].contains(s)){
			Hasher.probes += table[index].size() - table[index].indexOf(s);
			return true;
		}
		return false;
	}
	
	public boolean delete(String s){
		int index = getIndex(s);
		if(table[index] == null){
			return false;
		}
		return table[index].remove(s);
	}
}
