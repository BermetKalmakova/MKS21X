import java.util.*;
public class SuperArray implements Iterable<String>{
    private String[] data;
    private int size;
    public SuperArray(){
	data = new String[10];
	size = 0;
    }
    public SuperArray(int initialCapacity){
	if (initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
	data = new String[initialCapacity];
	size = 0;
    }
    public SuperArray(String[] ary){
	for (int i = 0;i < ary.length;i++){
	    add(ary[i]);
	}
    }
    public Iterator<String> iterator(){
	return new SuperArrayIterator(data);
    }
    public int size(){
	return size;
    }
    public void add(String n){
	if (size < data.length){
	    data[size] = n;
	    size += 1;
	}
	else {
	    grow();
	    add(n);
	}
    }
    private void grow(){
	String[] x = new String[data.length*2];
	for(int i = 0;i < data.length;i++){
	    x[i] = data[i];
	}
	data = x;
    }
    public String toString(){
	String ans = "[";
	for(int i = 0;i < size;i++){
	    ans = ans + data[i];
	    if (i != size - 1){
		ans += ",";
	    }
	}
	ans += "]";
	return ans;
    }
    public String toStringDebug(){
	String ans = "[";
	for(int i = 0;i<data.length;i++){
	    if (i < size){
		ans += data[i];
	    }
	    else {
		ans += "_";
	    }
	    if (i != data.length - 1){
		ans += ",";
	    }
	}
	ans += "]";
	return ans;
    }
    public void clear(){
	size = 0;
    }
    public boolean isEmpty(){
	return size == 0;
    }
    public String get(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	return data[index];
    }
    public String set(int index, String element){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	String ans = data[index];
	data[index] = element;
	return ans;
    }
    public void add(int index, String element){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}
	if (size < data.length){
	    size += 1;
	    for (int i = size;i > index; i--){
		data[i] = data[i-1];
	    }
	    data[index] = element;
	}
	else {
	    grow();
	    add(index, element);
	}
    }
    public String remove(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	String ans = data[index];
	size -= 1;
	for (int i = index;i<size;i++){
	    data[i]=data[i+1];
	}
	return ans;
    }
    public String[] toArray(){
	String[] ans = new String[size];
	for (int i = 0; i < size; i++){
	    ans[i] = data[i];
	}
	return ans;
    }
    public int indexOf(String i){
	int ans = -1;
	for (int j = size-1; j >= 0; j --){
	    if (get(j).equals(i)){
		ans = j;
	    }
	}
	return ans;
    }
    public int lastIndexOf(String i){
	int ans = -1;
	for (int j = 0;j < size;j++){
	    if (get(j).equals(i)){
		ans = j;
	    }
	}
	return ans;
    }
    public void trimToSize(){
	data = toArray();
    }
    public static void main (String args[]){
     	SuperArray x = new SuperArray();
     	for(int i = 0;i < 12;i++){
     	    x.add("a");
     	}	
     	System.out.println(x.toStringDebug());
     	x.add(3,"b");
        System.out.println(x.toStringDebug());
     	System.out.println(x.lastIndexOf("b"));
     	System.out.println(x.indexOf("b"));
	x.trimToSize();
	x.remove(2);
	System.out.println(x.toStringDebug());
     }
}
