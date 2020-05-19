package lab;
import java.util.Arrays;
import java.util.List;

public class SystemCall {
	private String Name;
    private List<ArgType> Arguments;
    private int argumentsSize;

    public SystemCall(ArgType... args) {
        Arguments = Arrays.asList(args);
        argumentsSize = Arguments.size();
    }

    public String getName(){
        return Name;
    }

    public List<ArgType> getArgs(){
        return Arguments;
    }
    
    public int getArgumentsSize() {
        return argumentsSize;
    }
}
