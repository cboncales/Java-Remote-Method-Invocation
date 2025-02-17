import java.rmi.RemoteException;

public class Cart implements CartInterface{
    
    private ProductInterface[] addedProducts;
    public int cap;
    public int index;

    public Cart(int cap) throws RemoteException {
        this.cap = cap;
        this.index = 0;
        this.addedProducts = new ProductInterface[cap];
    }

    public void addProducts(ProductInterface product) throws RemoteException {
        if (index < cap) {
            addedProducts[index] = product;
            index++;
        } else {
            System.out.println("Cannot add more products! The cart is full.");
        }
    }

    public String[] viewAddedProducts() throws RemoteException {
        String[] result = new String[index];
        for (int i = 0; i < index; i++) {
            result[i] = addedProducts[i].getName();
        }
        return result;
    }

}