public class TestEnum {

	public static void main(String[] args) {
		Vote myVote = Vote.YES;

		switch (myVote) {
		case YES:
			System.out.println("ja");
			break;
		case NO:
			System.out.println("nej");
			break;
		case NEUTRAL:
			System.out.println("vet ej");
			break;
		}
	}

}
