package utils;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	
	@DataProvider(name="bookNamesDataProivder")
	public Object[][] bookNamesDataProivder(){
		
		Object[][] data = new Object[2][2];
		
		data[0][0] = "The forest";
		data[0][1] = "book2.jpg";
		
		
		data[1][0] = "Life in the garden";
		data[1][1] = "book4.jpg";
		
		
		return data;
	}
	
	@DataProvider(name="foodNamesDataProivder")
	public Object[][] foodNamesDataProivder(){
		
		Object[][] data = new Object[12][2];
		
		data[0][0] = "Fresh Organic Broccoli Crowns";
		data[0][1] = "product-image-57.jpg";
		
		data[1][0] = "Fresh Brown Coconut";
		data[1][1] = "product-image-56.jpg";
		
		data[2][0] = "Fresh Produce Melons Each";
		data[2][1] = "product-image-53.jpg";
		
		data[3][0] = "Fresh Cavendish Bananas";
		data[3][1] = "product-image-52.jpg";
		
		data[4][0] = "Fresh Organic Kiwi";
		data[4][1] = "product-image-44.jpg";
		
		data[5][0] = "Fresh Organic Garlic";
		data[5][1] = "product-image-42.jpg";
		
		data[6][0] = "Organic Green Grapes";
		data[6][1] = "product-image-39.jpg";
		
		data[7][0] = "Texas Rio Red Grapefruit";
		data[7][1] = "product-image-19.jpg";
		
		data[8][0] = "Fresh Organic Strawberry";
		data[8][1] = "product-image-12.jpg";
		
		data[9][0] = "Organic Sweet Lime";
		data[9][1] = "product-image-11.jpg";
		
		data[10][0] = "Tomatoes on the Vine";
		data[10][1] = "product-image-10.jpg";
		
		data[11][0] = "Yellow Onions";
		data[11][1] = "product-image-1.jpg";
		
		return data;
	}

	

}