import java.util.HashMap;
import java.util.Stack;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String test = "()[]{}{{}}](((({}())))";
		HashMap<Character, Character> map = new HashMap<>();
		
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i =0; i < test.length(); i++)
		{
			System.out.println("Value of first char" + test.charAt(i));

			//Check if the characters are closing tags
			if(test.charAt(i) == ')' || test.charAt(i) == ']' || test.charAt(i) =='}')
			{
				if(!stack.isEmpty())
				{
					System.out.println("Stack peek " + stack.peek());
					//if its equal to the corresponding tag in the map, pop it
					if(stack.peek() == map.get(test.charAt(i)))
						stack.pop();
				}	
			}
			else	//add to the stack to check later if it is not completed
			{
				
				stack.add(test.charAt(i));
			}		
		} 
		//non empty stack means there is atleast one tag that is not 
		if(stack.isEmpty())
			System.out.println("Valid");
		else
			System.out.println("Invalid");
	}

}
