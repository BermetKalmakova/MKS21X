public class ReferenceBook extends LibraryBook{
    private String collection;

    public ReferenceBook(String auth, String titl, String isbnum, String callNum, String collect){
	LibraryBook(titl, auth, isbnum, callNum);
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
}
