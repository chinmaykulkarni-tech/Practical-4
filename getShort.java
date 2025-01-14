public class getShort{
	public static void main(String args[]){
	int number=400000;
	System.out.print(getShorts(number));
}
public static int getShorts(int number){
	if(number<=32767&&number>=(-32768)){
	return number;
}
	else if(number>32767){
		while(number>32767){
		number=number-65535;
}
	return number;
}
	else{
		while(number<(-32768)){
			number=number+65535;
}
	return number;
}
}
}
