public abstract Class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;

    public LibraryBook(String titl, String auth, String isbnum, String callNum){
	title = titl;
	author = auth;
	isbn = isbnum;
	callNumber = callNum;
    }
    
    public String getCallNum(){
	return callNumber;
    }
    public void setCallNum(String callNum){
	callNumber = callNum;
    }
    
    public abstract void checkout(String patron, String due){
    }
    public abstract void returned(){
    }
    public abstract String cirulationStatus(){
    }
    public int compareTo(LibraryBook o){
	return callNumber.compareTo(o.getCallNum());
    }
    public String toString(){
	return super.toString() + "\nCirculation Status: " + circulationStatus() + "\nCall Number: " + callNumber;
    }
}
