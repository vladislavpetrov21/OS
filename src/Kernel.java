import java.util.HashMap;
import java.util.List;

public class Kernel {
	ElStack stack;
	public HashMap<Integer, SystemCall> SystemCalls;

	public Kernel(ElStack stack)
	{
		this.stack = stack;
		SystemCalls = new HashMap<>();
		SystemCalls.put(0, new SystemCall("a"));
		SystemCalls.put(1, new SystemCall("a", "b"));
		SystemCalls.put(2, new SystemCall("a", "b", "c"));
		SystemCalls.put(3, new SystemCall("a", "b", "c","d"));
		SystemCalls.put(4, new SystemCall("a", "b", "c","d", "e"));
	}
	public void ExecuteCall(int id){
		if (!SystemCalls.containsKey(id)) {
			System.out.print("неверный id");
			return;
		}
		List<String> arguments = SystemCalls.get(id).getArgs();
		
		for (int i = arguments.size() - 1; i >= 0; i--) {
			if (!stack.pop().equals(arguments.get(i))) {
				System.out.print("Неверные аргументы \n");
				return;
			}
		}
		System.out.print(SystemCalls.get(id).Execute(id));
	}

	public void Calls()
	{
		for (int id : SystemCalls.keySet())
			System.out.print(id + " " + SystemCalls.get(id).List());
	}
}
