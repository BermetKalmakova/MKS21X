public class Book{
    private String author;
    private String title;
    private String isbn;

    public Book(){
	author = "";
	title = "";
	isbn = "";
    }

    public Book(String auth, String titl, String isbnum){
	author = auth;
	title = titl;
	isbn = isbnum;
    }

    public String getTitle(){
	return title;
    }
    public String getAuthor(){
	return author;
    }
    public String getIsbn(){
	return isbn;
    }
    public void setTitle(String x){
	title = x;
    }
    public void setAuthor(String x){
	author = x;
    }
    public void setIsbn(String x){
	isbn = x;
    }

    public String toString(){
	return "Title: " + title + "\nAuthor: " + author + "\nISBN: " + isbn;
    }
}
	
