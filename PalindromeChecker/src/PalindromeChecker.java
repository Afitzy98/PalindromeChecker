import java.util.ArrayList;
public class PalindromeChecker
{
	//Declare any global variables required (e.g. operation counts for each method)
	protected static int opCount1 = 0;
	protected static int opCount2 = 0;
	protected static int opCount3 = 0;
	protected static ArrayList<String> results = new ArrayList<String>();
	
	//Static method for: Palindrome Method 1 (give it a names based on how it works)
	//Takes a String as a parameter and return a Boolean value
	public static boolean reverseCheck(String p) {
		// Declare two arrays one for the characters of the string one for the reverse
		String revString = "";
		opCount1++; // Assigning variable
		// Loop through string mapping characters to two different arrays
		for(int i = 0; i < p.length(); i++) {
			revString += p.charAt(p.length()-1-i);
			// if characters dont match return false
			if(p.charAt(i) != revString.charAt(i)) {
				return false;
			}
			opCount1 += 3; // Comparison + Iteration + Addition
		}
		return true;
	}
	//Static method for: Palindrome Method 2 (give it a names based on how it works)
	//Takes a String as a parameter and return a Boolean value
	public static boolean compareCheck(String p) {
		// Loop through string
		for(int i = 0; i < p.length(); i++) {
			// check if characters in opposite positions in string match
			if(p.charAt(i) != p.charAt(p.length()-1-i)) {
				return false;
			}
			opCount2 += 2; // Comparison + Iteration
		}
		return true;
	}
	
	//Static method for: Palindrome Method 3 (give it a names based on how it works)
	//Takes a String as a parameter and return a Boolean value
	public static boolean stackQueueCheck(String p) {
		// Declare stack and queue 
		ArrayStack s = new ArrayStack();
		ArrayQueue q = new ArrayQueue();
		String[] str = p.split("");
		opCount3 += 3;
		// Loop through string & push/enqueue each char in the stack/queue
		for(int i = 0; i < p.length(); i++) {
			q.enqueue(str[i]);
			s.push(str[i]);
			opCount3 += 2;
		}
		while(!(s.isEmpty()) || !(q.isEmpty())) {
			String sChar = (String) s.pop();
			String qChar = (String) q.dequeue();
			// check if the characters in opposite places match
			if(sChar.charAt(0) != qChar.charAt(0)) {
				return false;
			}
			opCount3 += 3;
		}
		return true;
	}
	
	//Static method for: Converting a decimal number into its equivalent binary representation
	//Takes a String representation of a number as a parameter and return a String value
	public static String decimalToBinary(String d) {
		// Declare vars
		String output = "";
		ArrayStack s = new ArrayStack();
		double current = Integer.parseInt(d);
		double temp = 0;
		int bit;
		// While the number is greater than 0
		while(current != 0) {
			// Divide the number by 2, and push the remainder to the stack (remainder will always be 1 or 0)
			// first result will be least significant bit (reason for pushing to stack rather than appending straight away)
			current = current/2;
			temp = Math.round(current);
			current = Math.floor(current);
			bit = (int) (temp - current);
			s.push(Integer.toString(bit));
		}
		// Loop through the stack appending to output
		while(!(s.isEmpty())) {
			output += (String) s.pop();
		}
	
		return output;
	}
	
}