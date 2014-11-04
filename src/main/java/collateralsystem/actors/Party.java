package collateralsystem.actors;

import collateralsystem.domainobjects.CreditSupportAnnex;
import collateralsystem.domainobjects.trading.Trade;

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
