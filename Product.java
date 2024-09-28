import java.rmi.RemoteException;

public class Product implements ProductInterface{
    //Attributes of product

    private int productCode;
    private String name;
    private String description;
    private String manufacturer;
    private double retailPrice;
    private double storePrice;
    private int quantity;

    Product(int newProductCode, String newName, String newDescription, String newManufacturer, double newRetailPrice , double newStorePrice, int newQuantity) throws RemoteException{

        this.productCode = newProductCode;
        this.name = newName;
        this.description = newDescription;
        this.manufacturer = newManufacturer;
        this.retailPrice = newRetailPrice;
        this.storePrice = newStorePrice;
        this.quantity = newQuantity;
        
    }

    public int getProductCode() throws RemoteException{
        return this.productCode;
    }
    
    public String getName() throws RemoteException{
        return this.name;
    }

    public String getDescription() throws RemoteException{
        return this.description;
    }

    public String getManufacturer() throws RemoteException{
        return this.manufacturer;
    }
    
    public double getRetailPrice() throws RemoteException{
        return this.retailPrice;
    }

    public double getStorePrice() throws RemoteException{
        return this.storePrice;
    }

    public int getQuantity() throws RemoteException{
        return this.quantity;
    }

    public void changeProductName(String newName) throws RemoteException{
        this.name = newName;
    }

    /*public void viewProducts(int productCode, String name, String description, String manufacturer, Double retailPrice, Double storePrice, int quantity) throws RemoteException{
        System.out.println("Product Code: " + getproductCode() + " Product Name: " + getName() + " Description: " + getDescription() + " Manufacturer:" + getManufacturer() +" Retail Price: " + getRetailPrice() + " Store Price: " + getStorePrice() + " Quantity: " + getQuantity());
    }*/
    public void viewProducts() throws RemoteException{
        System.out.println("\nProduct Code: " + getProductCode() + "\nProduct Name: " + getName() + "\nDescription: " + getDescription() + "\nManufacturer:" + getManufacturer() +"\nRetail Price: " + getRetailPrice() + "\nStore Price: " + getStorePrice() + "\nQuantity: " + getQuantity());
    }
}
