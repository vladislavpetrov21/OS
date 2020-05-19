package lab;
import java.util.ArrayList;

public class ElStack {
	private ArrayList stack = new ArrayList();

	public void push(Object element) {
		stack.add(element);
	}

	public String pop() {
		String element = (String) stack.get(stack.size()-1);
		stack.remove(stack.size()-1);
		return element;
	}
}
