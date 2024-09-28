import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

    public static void main(String[] args) {

        try{
            Registry startRMI = LocateRegistry.createRegistry(9200);
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            System.out.println("Server has started!");

            Product Laptop = new Product(101, "Laptop", "Predator", "Acer", 75999.00, 84999.00, 10);
            Product MobilePhone = new Product(102,"Mobile Phone", "iPhone 15", "Apple", 54999.00, 64999.00, 20);
            Product Charger = new Product(103, "Charger", "Ultra-X","Yone", 2599.00, 2999.00, 10);
            Product PowerBank = new Product( 104,"Power Bank", "Power II", "Anker", 3299.00, 3999.00, 19);
            Cart MyCart = new Cart(100);

            ProductInterface stub_laptop = (ProductInterface) UnicastRemoteObject.exportObject(Laptop, 0);
            ProductInterface stub_mobilePhone = (ProductInterface) UnicastRemoteObject.exportObject(MobilePhone, 0);
            ProductInterface stub_charger = (ProductInterface) UnicastRemoteObject.exportObject(Charger, 0);
            ProductInterface stub_powerBank = (ProductInterface) UnicastRemoteObject.exportObject(PowerBank, 0);
            CartInterface stub_myCart = (CartInterface) UnicastRemoteObject.exportObject(MyCart, 0);

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9200);

            registry.rebind("laptop", stub_laptop);
            registry.rebind("mobilePhone", stub_mobilePhone);
            registry.rebind("charger", stub_charger);
            registry.rebind("powerBank", stub_powerBank);
            registry.rebind("myCart", stub_myCart);

            System.out.println("Exporting and Biding of Objects has been completed!");

            Laptop.viewProducts();
            MobilePhone.viewProducts();
            Charger.viewProducts();
            PowerBank.viewProducts();

        }catch(Exception e){
            System.out.println("Server Error!" + e);
        }
    }
     
}