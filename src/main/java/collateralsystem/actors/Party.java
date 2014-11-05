package collateralsystem.actors;

import collateralsystem.domainobjects.CollateralHolding;
import collateralsystem.domainobjects.CreditSupportAnnex;
import collateralsystem.domainobjects.RiskFactor;
import collateralsystem.domainobjects.trading.Trade;

public class Party {
    private CreditSupportAnnex csa;
    private Trade[] trades;
    private CollateralHolding[] collateralHoldings;
    private RiskFactor[] riskFactors;

    public Party(final String name) {

    }

    public CreditSupportAnnex getCSA() {
        return csa;
    }

    public Trade[] getTrades() {
        return trades;
    }

    public CollateralHolding[] getCollateralHoldings() {
        return collateralHoldings;
    }

    public RiskFactor[] getRiskFactors() {
        return riskFactors;
    }
}
