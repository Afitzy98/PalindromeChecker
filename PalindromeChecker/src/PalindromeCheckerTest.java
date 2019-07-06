
public class PalindromeCheckerTest {
	public static void main (String[] args)
	{	
		//Declare any variables used (e.g. for timing etc.)
		long startT = System.currentTimeMillis();
		int count = 0;
		int index = 0;
		//Test each method (looping over the binary/decimal numbers for each)
		//by calling your defined methods below
		for(int j = 50000; j <= 1000000; j += 50000) {
			count = 0;
			PalindromeChecker.opCount1 = 0;
			PalindromeChecker.opCount2 = 0;
			PalindromeChecker.opCount3 = 0;
			startT = System.currentTimeMillis();
			// Reverse check 
			for(int i = 0; i < j; i++) {
				if(PalindromeChecker.reverseCheck(Integer.toString(i)) && PalindromeChecker.reverseCheck(PalindromeChecker.decimalToBinary(Integer.toString(i)))) {
					count++;
				}
			}	
			long t = System.currentTimeMillis() - startT;
			String s = "(" + j + ")" + "Reverse Check Algorithm \nNumber of palindromes: " + count + "\nNumber of Operations: " + PalindromeChecker.opCount1 + "\nTime: " + t + "ms";
			PalindromeChecker.results.add(index, s);
			index++;
			
			// Compare check
			startT = System.currentTimeMillis();
			count = 0;
			for(int i = 0; i < j; i++) {
				if(PalindromeChecker.compareCheck(Integer.toString(i)) && PalindromeChecker.compareCheck(PalindromeChecker.decimalToBinary(Integer.toString(i)))) {
					count++;
				}
			}	
			t = System.currentTimeMillis() - startT;
			s = "(" + j + ") Compare Check Algorithm \nNumber of palindromes: " + count + "\nNumber of Operations: " + PalindromeChecker.opCount2 + "\nTime: " + t + "ms";
			PalindromeChecker.results.add(index, s);
			index++;
			
			// Stack & Queue 
			startT = System.currentTimeMillis();
			count = 0;
			for(int i = 0; i < j; i++) {
				if(PalindromeChecker.stackQueueCheck(Integer.toString(i)) && PalindromeChecker.stackQueueCheck(PalindromeChecker.decimalToBinary(Integer.toString(i)))) {
					count++;
				}
			}	
			t = System.currentTimeMillis() - startT;
			s =  "(" + j + ") Stack/Queue Check Algorithm \nNumber of palindromes: " + count + "\nNumber of Operations: " + PalindromeChecker.opCount3 + "\nTime: " + t + "ms";
			PalindromeChecker.results.add(index, s);
			index++; 
		}		
		//Display results for each method
		for(int i = 0; i < PalindromeChecker.results.size(); i++) {
			System.out.println(PalindromeChecker.results.get(i));
		}
	}
}
