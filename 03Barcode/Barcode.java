public class Barcode implements Comparable<Barcode>{
    // instance variables
    private String _zip;
    private int _checkDigit;

    // constructors
    //precondtion: _zip.length() = 5 and zip contains only digits.
    //postcondition: throws a runtime exception zip is not the correct length
    //               or zip contains a non digit
    //               _zip and _checkDigit are initialized.
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
	_checkDigit = checkSum();
    }

    // postcondition: Creates a copy of a bar code.
    public Barcode clone(){
        Barcode x = new Barcode(_zip);
	return x;
    }


    // postcondition: computes and returns the check sum for _zip
    private int checkSum(){
	int sum = 0;
	for(int i = 0;i<5;i++){
	    sum+=(int)_zip.charAt(i);
	}
	return sum%10;
    }

    private String toBarcode(){
	String ans = "";
	String x = _zip + _checkDigit;
	ans = x.replace("1", ":::||");
	ans = x.replace("2", "::|:|");
	ans = x.replace("3", "::||:");
	ans = x.replace("4", ":|::|");
	ans = x.replace("5", ":|:|:");
	ans = x.replace("6", ":||::");
	ans = x.replace("7", "|:::|");
	ans = x.replace("8", "|::|:");
	ans = x.replace("9", "|:|::");
	ans = x.replace("0", "||:::");
	return ans;
    }
    
    //postcondition: format zip + check digit + Barcode 
    //ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
    public String toString(){
	return _zip + _checkDigit + " |" + toBarcode() + "|";
    }


    // postcondition: compares the zip + checkdigit, in numerical order. 
    public int compareTo(Barcode other){
	return toString().substring(0,6).compareTo(other.toString().substring(0,6));
    }
    
}
