import java.util.*;
public class SuperArrayIterator implements Iterator<String>{
    private SuperArray x;
    private int i;
    public SuperArrayIterator(SuperArray a){
	x = a;
	i = 0;
    }
    public boolean hasNext(){
	return i < x.size();
    }
    public String next(){
	if(hasNext()){
	    i ++;
	    return x.get(i-1);
	}else{
	    throw new NoSuchElementException();
	}
    }

    public void remove(){
	throw new UnsupportedOperationException();
    }
}
