package collateralsystem.domainobjects;

public class Party {
    private CreditSupportAnnex csa;
    private Trade[] trades;

    public Party(final String name) {

    }

    public CreditSupportAnnex getCSA() {
        return csa;
    }

    public Trade[] getTrades() {
        return trades;
    }
}
