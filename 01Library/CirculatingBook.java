public class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;
    public CirculatingBook(String auth, String titl, String isbnum, String callNum){
	super(titl,auth,isbnum,callNum);
    }
    public String getHolder(){
	return currentHolder;
    }
    public String getDueDate(){
	return dueDate;
    }
    public void setHolder(String x){
	currentHolder = x;
    }
    public void setDueDate(String x){
	dueDate = x;
    }
    public void checkout(String patron, String due){
	currentHolder = patron;
	dueDate = due;
    }
    public void returned(){
	currentHolder = null;
	dueDate = null;
    }
    public String circulationStatus(){
	if (currentHolder == null && dueDate == null){
	    return "book available on shelves";
	}
	return "checked out by: " + currentHolder + "; due on: " + dueDate;
    }
    public String toString(){
	if (currentHolder == null){
	    return super.toString();
	}
	return super.toString() + "\nCurrent Holder: " + currentHolder + "\nDue Date: " + dueDate;
    }	    
}
