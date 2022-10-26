package com.test.commercetoolpoc.catalog.product;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.product.Product;
import com.commercetools.api.models.product.ProductDraft;
import com.commercetools.api.models.product.ProductUpdate;
import com.commercetools.api.models.product_type.ProductType;
import com.commercetools.api.models.product_type.ProductTypeDraft;
import com.test.commercetoolpoc.catalog.client.Client;

public class ProductService {
	ProjectApiRoot apiRoot;
	
	public ProductService(ProjectApiRoot apiRoot) {
		this.apiRoot=apiRoot;
	}
	
	public String createProductType(String name, String description){
		// Create ProductType
		ProductTypeDraft newProductTypeDetails = ProductTypeDraft.builder()
		  .name(name)
		  .description(description)
		  .build();
		

		// Post the ProductTypeDraft and get the new ProductType
		ProductType productType = apiRoot
		  .productTypes()
		  .post(newProductTypeDetails)
		  .executeBlocking()
		  .getBody();

		// Output the ProductType ID
		String productTypeID = productType.getId();
		System.out.println(productTypeID);
		return productTypeID;
		
	}
	
	public String createProduct(String productTypeId) {
		ProductDraft newProductDetails = ProductDraft.builder()
		        .name(stringBuilder -> stringBuilder
		                .addValue("en", "English name for your Product3")
		                .addValue("de", "German name for your Product3")
		        )
		        .productType(typeBuilder -> typeBuilder
		                      .id(productTypeId)
		        )
		        .slug(stringBuilder -> stringBuilder
		                .addValue("en", "human-readable-url-for-english-product3")
		                .addValue("de", "human-readable-url-for-german-product3")
		        )
		        .build();
		
		
		// Post the ProductDraft and get the new Product
		Product product = apiRoot
		        .products()
		        .post(newProductDetails)
		        .executeBlocking()
		        .getBody();

		// Output the Product ID
		String productID = product.getId();
		System.out.println(productID);
		
		return productID;
	}
	
	public Product getProduct(String productId) {
		Product product = apiRoot
				  .products()
				  .withId(productId)
				  .get()
				  .executeBlocking()
				  .getBody();

				// Output the Product's version
				System.out.println(product.getVersion());
				
			return product;
	}
	
	
	public String addProductKey(String productId,String productKey) {
		Product productToUpdate=getProduct(productId);
		// Create the ProductUpdate with the current version of the Product and the update actions
		ProductUpdate productUpdate = ProductUpdate.builder()
		        .version(productToUpdate.getVersion())
		        .plusActions(actionBuilder -> actionBuilder.setKeyBuilder()
		                .key(productKey))
		        .build();
		

		// Post the ProductUpdate and return the updated Product
		Product updatedProduct = apiRoot
		  .products()
		  .withId(productToUpdate.getId())
		  .post(productUpdate)
		  .executeBlocking()
		  .getBody();

		// Output the updated Product's key
		String updatedProductKey = updatedProduct.getKey();
		System.out.println(updatedProductKey);	
		
		return updatedProductKey;
		
	}
	
	public Product findProductByKey(String productKey) {
		
		Product product = apiRoot
				  .products()
				  .withKey(productKey)
				  .get()
				  .executeBlocking()
				  .getBody();

				String productID = product.getId();
				System.out.println(productID);
				
		return product;
	}
	
	
}
