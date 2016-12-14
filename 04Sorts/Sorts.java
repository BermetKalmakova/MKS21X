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
	    int min = data[i];
	    for (int j = i; j < data.length; j++){
		if (data[j] < min){
		    min = data[j];
		    data[j] = data[i];
		    data[i] = min;
		}
	    }
	}
    }
    public static void insertionSort(int[] data){
	if (data.length > 1){
	    for(int i = 1; i < data.length; i++){
		int num = data[i];
		if(i != 0 && data[i-1]>data[i]){
		    data[i] = data[i-1];
		    data[i-1] = num;
		    i-=2;
		}
	    }
	}	    
    }

    public static void main(String args[]){
	int[] x = {6,3,5,1,4,2,5};
	for(int i = 0; i < x.length;i++){
	    System.out.println(x[i]);
	}
	selectionSort(x);
	for(int i = 0; i < x.length;i++){
	    System.out.println(x[i]);
	}
    }

}

