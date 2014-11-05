package collateralsystem.components;


import collateralsystem.domainobjects.CollateralHolding;
import collateralsystem.domainobjects.CreditSupportAnnex;
import collateralsystem.actors.Party;
import collateralsystem.domainobjects.RiskFactor;
import collateralsystem.domainobjects.trading.Trade;
import collateralsystem.domainobjects.TradeBucket;

import java.util.HashMap;
import java.util.Map;

public class DataIngestion {
    private final TriOptima triOptima = new TriOptima();
    private final Map<Party, CreditSupportAnnex> csaMap = new HashMap<Party, CreditSupportAnnex>();

    public void addTrades(final Party party, final Trade[] trades) {
        triOptima.send(trades);

        bucketTradesbyCSA(trades).splitBucketsByTerms();
    }

    private TradeBucket bucketTradesbyCSA(final Trade[] trades) {
        return new TradeBucket(trades);
    }

    public void addCSA(final Party party, final CreditSupportAnnex csa) {
        csaMap.put(party, csa);
    }

    public void addRiskFactors(final Party party, final RiskFactor[] riskFactors) {

    }

    public void addCollateralHoldings(final Party party, final CollateralHolding[] collateralHoldings) {

    }
}
