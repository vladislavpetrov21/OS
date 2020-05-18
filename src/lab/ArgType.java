package lab;

public class ArgType {
	private Object argument;
	
    public ArgType(int value) {
        argument = (int) value;
    }

    public ArgType(double value) {
        argument = (double) value;
    }

    public ArgType(String value) {
        argument = (String) value;
    }

    public Object getArgument() {
        return argument;
    }
}
