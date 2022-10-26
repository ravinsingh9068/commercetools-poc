package com.test.commercetoolpoc.catalog.client;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.defaultconfig.ApiRootBuilder;
import com.commercetools.api.defaultconfig.ServiceRegion;
import io.vrap.rmf.base.client.oauth2.*;

public class Client {

  public static ProjectApiRoot createApiClient() {
        final ProjectApiRoot apiRoot = ApiRootBuilder.of()
        .defaultClient(ClientCredentials.of()
                .withClientId("dLljzkyoeKV2l2gdZOzo9_E0")
                .withClientSecret("PCnJ3zdfQDIkJ1rTyCmctG1f8ZfC8Xf5")
                .build(),
        ServiceRegion.GCP_US_CENTRAL1)
        .build("medline-pune-2022");

        return apiRoot;
    }
}
