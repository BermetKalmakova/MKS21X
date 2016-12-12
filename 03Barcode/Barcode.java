import java.util.ArrayList;
public class Barcode implements Comparable<Barcode>{
    private String _zip;
    private static ArrayList<String> bars = new ArrayList<String>();
    private static String[] bars1 = {"||:::", ":::||", "::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
    private void copyBar(){
	for(int i = 0; i < 10; i++){
	    bars.add(bars1[i]);
	}
    }

    public Barcode(String zip) {
	copyBar();
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
    private static int checkSum(String a){
	int sum = 0;
	for(int i = 0;i<5;i++){
	    sum+=(int)a.charAt(i);
	}
	return sum%10;
    }
    public static String toCode(String zip){
	if (zip.length() != 5){
	    throw new IllegalArgumentException();
	}
	for (int i = 0;i<5;i++){
	    if (zip.charAt(i) < '0' || zip.charAt(i) > '9'){
		throw new IllegalArgumentException();
	    }
	}
	String ans = "";
	String x = zip + checkSum(zip);
	for(int i = 0;i<x.length();i++){
	    //char num = x.charAt(i);
	    // switch(num){
	    // case '0' :
	    // 	ans += "||:::";
	    // case '1' :
	    // 	ans += ":::||";
	    // case '2' :
	    // 	ans += "::|:|";
	    // case '3' :
	    // 	ans += "::||:";
	    // case '4' :
	    // 	ans += ":|::|";
	    // case '5' :
	    // 	ans += ":|:|:";
	    // case '6' :
	    // 	ans += ":||::";
	    // case '7' :
	    // 	ans += "|:::|";
	    // case '8' :
	    // 	ans += "|::|:";
	    // case '9' :
	    // 	ans += "|:|::";
	    //}
	    ans += bars.get((int)x.charAt(i)-(int)'0');
	}
	return "|" + ans + "|";
    }     
    public String toString(){
	return _zip + checkSum(_zip)+ " " + toCode(_zip);
    }
    public static String toZip(String code){
	if (code.length() != 32 || code.charAt(0) != '|' || code.charAt(31) != '|'){
	    throw new IllegalArgumentException();
	}
	for (int i = 0; i < 32; i++){
	    if (code.charAt(i) != '|' && code.charAt(i) != ':'){
		throw new IllegalArgumentException();
	    }
	}
	String a = code.substring(1,6);
	String b = code.substring(6,11);
	String c = code.substring(11,16);
	String d = code.substring(16,21);
	String e = code.substring(21,26);
	String f = code.substring(26,31);

	
	if (!bars.contains(a) || !bars.contains(b) || !bars.contains(c) || !bars.contains(d) || !bars.contains(e) || !bars.contains(f)){
	    throw new IllegalArgumentException();
	}
	if ((bars.indexOf(a) + bars.indexOf(b)+bars.indexOf(c)+bars.indexOf(d)+bars.indexOf(e))%10 != bars.indexOf(f)){
	    throw new IllegalArgumentException();
	}
	String ans = "";
	ans += bars.indexOf(a)+ "" + bars.indexOf(b)+"" + bars.indexOf(c)+"" + bars.indexOf(d)+"" + bars.indexOf(e);
	return ans;
    }
    public int compareTo(Barcode other){
	return toString().substring(0,6).compareTo(other.toString().substring(0,6));
    }
}
