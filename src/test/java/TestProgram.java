import collateralsystem.actors.Party;
import collateralsystem.actors.CollateralCloud;

public class TestProgram {

    public static void main(String[] args) {
        new TestProgram().run();
    }

    private void run() {
        final Party partyA = new Party("A");
        final Party partyB = new Party("B");

        final CollateralCloud cloud = new CollateralCloud();
        cloud.getFileUploader(partyA).upload(partyA.getCSA());
        cloud.getFileUploader(partyA).upload(partyA.getTrades());
    }
}