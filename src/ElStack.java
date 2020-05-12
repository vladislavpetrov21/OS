import java.util.ArrayList;
import java.util.List;

public class ElStack {
	private List stack = new ArrayList();

	public void push(String element) {
		stack.add(element);
	}

	public String pop() {
		String element = (String) stack.get(stack.size() - 1);
		stack.remove(stack.size() - 1);
		return element;
	}
}
