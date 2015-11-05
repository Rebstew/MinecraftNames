
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HTTPtransmitter transmitter = new HTTPtransmitter();
		//String uuid = transmitter.requestUUID("Rod_Vadar");
		String uuid = transmitter.requestUUID("Webster");
		transmitter.requestNameHistory(uuid);
		transmitter.requestSkin(uuid);
	}

}
