package collateralsystem.services;

import collateralsystem.domainobjects.Party;

import java.util.HashMap;
import java.util.Map;

public class CollateralCloud {
    private final Map<Party, FileUpload> fileUploaders = new HashMap<Party, FileUpload>();

    public FileUpload getFileUploader(final Party party) {
        FileUpload uploader = fileUploaders.get(party);
        if (uploader == null) {
            uploader = new FileUpload();
            fileUploaders.put(party, uploader);
        }

        return uploader;
    }
}
