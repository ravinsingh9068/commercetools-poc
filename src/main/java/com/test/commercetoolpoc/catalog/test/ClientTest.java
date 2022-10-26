package com.test.commercetoolpoc.catalog.test;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.project.Project;
import com.test.commercetoolpoc.catalog.client.Client;

public class ClientTest {
	public static void main(String[] args) {
		ProjectApiRoot apiRoot = Client.createApiClient();

		Project myProject = apiRoot
		  .get()
		  .executeBlocking()
		  .getBody();

		// Output the Project name
		System.out.println(myProject.getName());
	}
}
