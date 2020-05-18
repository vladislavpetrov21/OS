package lab;
import java.util.HashMap;
import java.util.List;

public class Kernel {
	ElStack stack;
	public HashMap<Integer, SystemCall> SystemCalls;

	public Kernel(ElStack stack)
	{
		this.stack = stack;
		SystemCalls = new HashMap<>();
		SystemCalls.put(0, new SystemCall(new ArgType(1), new ArgType(1.2), new ArgType("first")));
		SystemCalls.put(1, new SystemCall(new ArgType(2), new ArgType(2.3), new ArgType("second")));
		SystemCalls.put(2, new SystemCall(new ArgType(3), new ArgType(3.4), new ArgType("third")));
		SystemCalls.put(3, new SystemCall(new ArgType(4), new ArgType(4.5), new ArgType("fourth")));
		SystemCalls.put(4, new SystemCall(new ArgType(5), new ArgType(5.6), new ArgType("fifth")));
	}
	public void ExecuteCall(int id){
		if (!SystemCalls.containsKey(id)) {
			System.out.print("неверный id");
			return;
		}
		List<ArgType> arguments = SystemCalls.get(id).getArgs();
		
		for (int i = arguments.size() - 1; i >= 0; i--) {
			if (!stack.pop().equals(SystemCalls.get(id).getArgs().get(i).getArgument())) {
				System.out.print("Неверные аргументы \n");
				return;
			}
		}
	}

	public void Calls()
	{
		for (int id : SystemCalls.keySet()) {
			for (int i = 0; i < SystemCalls.get(id).getArgumentsSize(); i++) {
                System.out.print(SystemCalls.get(id).getArgs().get(i).getArgument() + " ");
            }
		}
	}
}
