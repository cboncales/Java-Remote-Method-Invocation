import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProductInterface extends Remote{
    public int getProductCode() throws RemoteException;
    public String getName() throws RemoteException;
    public String getDescription() throws RemoteException;
    public String getManufacturer() throws RemoteException;
    public double getRetailPrice() throws RemoteException;
    public double getStorePrice() throws RemoteException;
    public int getQuantity() throws RemoteException;
    public void changeProductName(String newName) throws RemoteException;
    public void viewProducts() throws RemoteException;
}
