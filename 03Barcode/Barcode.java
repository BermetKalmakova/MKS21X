public class Barcode implements Comparable<Barcode>{
    private String _zip;
    private static String[] bars = {"||:::", ":::||", "::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"}

    public Barcode(String zip) {
	if (zip.length() != 5){
	    throw new IllegalArgumentException();
	}
	for (int i = 0;i<5;i++){
	    if (zip.charAt(i) < '0' || zip.charAt(i) > '9'){
		throw new IllegalArgumentException();
	    }

	}
	_zip = zip;
    }


    // postcondition: computes and returns the check sum for _zip
    private int checkSum(String a){
	int sum = 0;
	for(int i = 0;i<5;i++){
	    sum+=(int)a.charAt(i);
	}
	return sum%10;
    }

    private static String toCode(String zip){
	String ans = "";
	String x = zip + checkSum(zip);
	for(int i = 0;i<6;i++){
	    ans += bars.get((int)x.charAt(i));
	}
	return ans;
    }
      
    public String toString(){
	return _zip + checkSum(_zip) + " |" + toCode() + "|";
    }

    public static String toZip(String code){
	
    }

    public int compareTo(Barcode other){
	return toString().substring(0,6).compareTo(other.toString().substring(0,6));
    }
    
}
