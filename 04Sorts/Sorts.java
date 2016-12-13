public class Sorts{
    /**EDIT THIS METHOD TO MATCH YOUR NAME 
     */
    public static String name(){
	return "06.Kalmakova.Bermet"; 
    }

    /**Selection sort of an int array. 
     *Upon completion, the elements of the array will be in increasing order.
     *@param data  the elements to be sorted.
     */
    public static void selectionSort(int[] data){
	for(int i = 0; i < data.length; i++){
	    int min = i;
	    for (int j = i; j < data.length; j++){
		if (data[j] < min){
		    min = data[j];
		    data[j] = data[i];
		    data[i] = min;
		}
	    }
	}
    }
    public static void main(args String[]){
	int[] x = [6,3,5,1,4,2,5];
	System.out.println(x);
	selectionSort(X);
	System.out.println(X);
    }

}

