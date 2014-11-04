package collateralsystem;

import collateralsystem.domainobjects.Party;
import collateralsystem.services.CollateralCloud;

public class TestRunner {
    public static void main(String[] args) {

        final Party partyA = new Party("A");
        final Party partyB = new Party("B");

        final CollateralCloud cloud = new CollateralCloud();
        cloud.getFileUploader(partyA).upload(partyA.getCSA());
        cloud.getFileUploader(partyA).upload(partyA.getTrades());
    }
}
