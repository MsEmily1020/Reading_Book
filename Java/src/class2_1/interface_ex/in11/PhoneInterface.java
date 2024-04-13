package class2_1.interface_ex.in11;

interface PhoneInterface {
	int TIMEOUT = 10000;
	void sendCall();
	void receiveCall();
	
	default void printLogo() {
		System.out.println("** Phone **");
	}
}
