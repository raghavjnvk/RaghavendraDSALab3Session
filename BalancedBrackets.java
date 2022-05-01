package com.greatlearning.lab3;

import java.util.Stack;

public class BalancedBrackets {

	public static void main(String[] args) {

		String inputString = "( [ [ { } ] ] )"; // Balance Brackets
		// String inputString = "( [ [ { } ] ] ) )"; //Not Balance Brackets
		if (checkBalance(inputString)) {
			System.out.println("The entered String has Balanced Brackets");
		} else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}
	}

	static boolean checkBalance(String bracketExpression) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < bracketExpression.length(); i++) {
			char character = bracketExpression.charAt(i);
			if (character == '(' || character == '[' || character == '{') {
				stack.push(character);
				continue;
			}
			if (stack.isEmpty()) {
				return false;
			}
			char c;
			switch (character) {

			case '}':
				c = stack.pop();
				if (c == '(' || c == '[') {
					return false;
				}
				break;
			case ')':
				c = stack.pop();
				if (c == '{' || c == '[') {
					return false;
				}
				break;
			case ']':
				c = stack.pop();
				if (c == '(' || c == '{') {
					return false;
				}
				break;
			default:
				break;
			}
		}
		return stack.isEmpty();
	}
}
