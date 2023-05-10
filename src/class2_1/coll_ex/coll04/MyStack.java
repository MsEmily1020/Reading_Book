package class2_1.coll_ex.coll04;

public class MyStack {
	public static void main(String[] args) {
		GStack<String> stringStack = new GStack<String>();
		stringStack.push("seoul");
		stringStack.push("busan");
		stringStack.push("LA");
		
		for (int i = 0; i < 3; i++)
			System.out.println(stringStack.pop());
		
		GStack<Integer> intStack = new GStack<Integer>();
		intStack.push(1);
		intStack.push(2);
		intStack.push(5);
		
		for (int i = 0; i < 3; i++)
			System.out.println(intStack.pop());
		
	}
}
