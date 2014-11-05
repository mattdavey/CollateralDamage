package collateralsystem.actors;

import collateralsystem.components.DataIngestion;
import collateralsystem.domainobjects.CollateralHolding;
import collateralsystem.domainobjects.CreditSupportAnnex;
import collateralsystem.domainobjects.RiskFactor;
import collateralsystem.domainobjects.trading.Trade;

public class CollateralCloud {
    private final DataIngestion ingestion = new DataIngestion();

    public void addCSA(final Party party, final CreditSupportAnnex csa) {
        ingestion.addCSA(party, csa);
    }

    public void addCollateralHoldings(final Party party, final CollateralHolding[] collateralHoldings) {
        ingestion.addCollateralHoldings(party, collateralHoldings);
    }

    public void addTrades(final Party party, final Trade[] trades) {
        ingestion.addTrades(party, trades);
    }

    public void addRiskFactors(final Party party, final RiskFactor[] riskFactors) {
        ingestion.addRiskFactors(party, riskFactors);
    }
}
