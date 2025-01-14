import java.util.*;
public class getByte{
	public static void main(String args[]){
	int number =500;
	System.out.println(getBytes(number));
}
public static int getBytes(int number){
	if(number<=127&&number>=(-128)){
	return number;
}
	else if(number>127){
		while(number>127){
		number=number-256;
		}

		return number;
	}
	else{
	while(number<-128){
	number=number+256;
}
     return number;
}
}
}
