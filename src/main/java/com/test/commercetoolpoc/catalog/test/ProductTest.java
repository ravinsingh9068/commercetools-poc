package com.test.commercetoolpoc.catalog.test;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.product.Product;
import com.test.commercetoolpoc.catalog.client.Client;
import com.test.commercetoolpoc.catalog.product.ProductService;

public class ProductTest {
	public static void main(String[] args) {
		ProjectApiRoot apiRoot = Client.createApiClient();

		ProductService productService= new ProductService(apiRoot);
		
		String productTypeId = productService.createProductType("Sample ProductType3", "Sample ProductType Desc3");
		String productId=productService.createProduct(productTypeId);
		Product product = productService.getProduct(productId);
		
		System.out.println("productTypeId+++++++++++++++++++++++++++++++++++++"+productTypeId);
		System.out.println("productId+++++++++++++++++++++++++++++++++++++"+productId);
		System.out.println(product.getVersion());
		
		String updatedProductKey = productService.addProductKey(productId,"new-product-key3");
		
		System.out.println(updatedProductKey);
		
		Product updatedProduct=productService.findProductByKey("new-product-key3");
		
		System.out.println("Updated product version++++++++++++++++++++++++++++++++++++++++"+updatedProduct.getVersion());
		
	}
}
