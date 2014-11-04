package collateralsystem.components;


import collateralsystem.domainobjects.CreditSupportAnnex;
import collateralsystem.actors.Party;
import collateralsystem.domainobjects.trading.Trade;
import collateralsystem.domainobjects.TradeBucket;

import java.util.HashMap;
import java.util.Map;

public class DataIngestion {
    private final TriOptima triOptima = new TriOptima();
    private final Map<Party, CreditSupportAnnex> csaMap = new HashMap<Party, CreditSupportAnnex>();

    public void newTrades(final Trade[] trades) {
        triOptima.send(trades);

        bucketTradesbyCSA(trades).splitBucketsByTerms();
    }

    private TradeBucket bucketTradesbyCSA(final Trade[] trades) {
        return new TradeBucket(trades);
    }

    public void newCSA(final CreditSupportAnnex csa, final Party party) {
        csaMap.put(party, csa);
    }
}
