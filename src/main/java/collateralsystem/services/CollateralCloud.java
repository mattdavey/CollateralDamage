package collateralsystem.services;

import collateralsystem.components.DataIngestion;
import collateralsystem.components.FileUpload;
import collateralsystem.domainobjects.Party;

import java.util.HashMap;
import java.util.Map;

public class CollateralCloud {
    private final Map<Party, FileUpload> fileUploaders = new HashMap<Party, FileUpload>();
    private final DataIngestion ingestion = new DataIngestion();

    public FileUpload getFileUploader(final Party party) {
        FileUpload uploader = fileUploaders.get(party);
        if (uploader == null) {
            uploader = new FileUpload(ingestion, party);
            fileUploaders.put(party, uploader);
        }

        return uploader;
    }
}
