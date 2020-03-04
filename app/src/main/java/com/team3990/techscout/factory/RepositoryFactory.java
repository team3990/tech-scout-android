package com.team3990.techscout.factory;

import com.team3990.techscout.service.DataSheetService;
import com.team3990.techscout.repository.DataSheetRepository;

public final class RepositoryFactory {

    public DataSheetRepository providerDataSheetRepository(DataSheetService dataSheetService) {
        return new DataSheetRepository(dataSheetService);
    }

}
