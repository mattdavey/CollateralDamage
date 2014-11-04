package collateralsystem.components;

import collateralsystem.domainobjects.CreditSupportAnnex;
import collateralsystem.domainobjects.Party;
import collateralsystem.domainobjects.trading.Trade;

public class FileUpload {
    private DataIngestion ingestion;
    private Party party;

    public FileUpload(final DataIngestion ingestion, final Party party) {
        this.ingestion = ingestion;
        this.party = party;
    }

    public void upload(final CreditSupportAnnex csa) {
        ingestion.newCSA(csa, party);
    }

    public void upload(final Trade[] trades) {
        ingestion.newTrades(trades);
    }
}
