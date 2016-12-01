public class ReferenceBook extends LibraryBook{
    private String collection;

    public ReferenceBook(String auth, String titl, String isbnum, String callNum, String collect){
        super(titl,auth,isbnum,callNum);
	collection = collect;
    }
    
    public String getColl(){
	return collection;
    }
    public void setColl(String coll){
	collection = coll;
    }
    public void checkout(String patron, String due){
	System.out.println("Cannot check out a reference book.");
    }
    public void returned(){
	System.out.println("Reference book could not have been checked out -- return impossible");
    }
    public String circulationStatus(){
	return "non-circulating reference book";
    }
    public String toString(){
	return super.toString() + "\nCollection: " + collection;
    }  
}
