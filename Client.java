import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client{
    public static void main(String[] args) {
        int a;
        Scanner scan = new Scanner(System.in);

        try{
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9200);

            ProductInterface p1 = (ProductInterface) registry.lookup("laptop");
            ProductInterface p2 = (ProductInterface) registry.lookup("mobilePhone");
            ProductInterface p3 = (ProductInterface) registry.lookup("charger");
            ProductInterface p4 = (ProductInterface) registry.lookup("powerBank");
            CartInterface c1 = (CartInterface) registry.lookup("myCart");
        
            while (true) {
                System.out.print("Enter user Admin/Customer: ");
                String user = scan.nextLine().toLowerCase().trim();

                switch (user) {
                    case "admin":
                        while (true) {
                            
                            System.out.println("\n1. View Products\n2. View Summary\n3. Exit\n");
							System.out.print("Enter choice: ");
                            a = scan.nextInt();

                            switch (a) {

                                case 1:
                                    System.out.println("\nProduct Code: " + p1.getProductCode() + "\nProduct Name: " + p1.getName() + "\nDescription: " + p1.getDescription() + "\nManufacturer:" + p1.getManufacturer() +"\nRetail Price: " + p1.getRetailPrice() + "\nStore Price: " + p1.getStorePrice() + "\nQuantity: " + p1.getQuantity());
                                    System.out.println("\nProduct Code: " + p2.getProductCode() + "\nProduct Name: " + p2.getName() + "\nDescription: " + p2.getDescription() + "\nManufacturer:" + p2.getManufacturer() +"\nRetail Price: " + p2.getRetailPrice() + "\nStore Price: " + p2.getStorePrice() + "\nQuantity: " + p2.getQuantity());
                                    System.out.println("\nProduct Code: " + p3.getProductCode() + "\nProduct Name: " + p3.getName() + "\nDescription: " + p3.getDescription() + "\nManufacturer:" + p3.getManufacturer() +"\nRetail Price: " + p3.getRetailPrice() + "\nStore Price: " + p3.getStorePrice() + "\nQuantity: " + p3.getQuantity());
                                    System.out.println("\nProduct Code: " + p4.getProductCode() + "\nProduct Name: " + p4.getName() + "\nDescription: " + p4.getDescription() + "\nManufacturer:" + p4.getManufacturer() +"\nRetail Price: " + p4.getRetailPrice() + "\nStore Price: " + p4.getStorePrice() + "\nQuantity: " + p4.getQuantity());
                                    break;

                                case 2:
                                    System.out.println("Next Activity!");
                                    break;
                                    
                                case 3:
                                    System.exit(0);
                                    break;
                  
                                default:
                                    System.out.println("Please choose from the choices only.");
                            }
                        }

                    case "customer":
                        while (true) {
                            System.out.println("\n1. View Products\n2. View Cart\n3. Add to Cart\n4. Exit\n");
                            System.out.print("Enter choice: ");
                            a = scan.nextInt();

                            switch (a) {
                                
                                case 1:
									System.out.println("\nProduct Code: " + p1.getProductCode() +
											"\nName: " + p1.getName() +
											"\nDescription: " + p1.getDescription() +
											"\nManufacturer: " + p1.getManufacturer() +
											"\nRetail Price: " + p1.getRetailPrice() +
											"\nStore Price: " + p1.getStorePrice() +
											"\nQuantity: " + p1.getQuantity());

									System.out.println("\nProduct Code: " + p2.getProductCode() +
											"\nName: " + p2.getName() +
											"\nDescription: " + p2.getDescription() +
											"\nManufacturer: " + p2.getManufacturer() +
											"\nRetail Price: " + p2.getRetailPrice() +
											"\nStore Price: " + p2.getStorePrice() +
											"\nQuantity: " + p2.getQuantity());

									System.out.println("\nProduct Code: " + p3.getProductCode() +
											"\nName: " + p3.getName() +
											"\nDescription: " + p3.getDescription() +
											"\nManufacturer: " + p3.getManufacturer() +
											"\nRetail Price: " + p3.getRetailPrice() +
											"\nStore Price: " + p3.getStorePrice() +
											"\nQuantity: " + p3.getQuantity());

									System.out.println("\nProduct Code: " + p4.getProductCode() +
											"\nName: " + p4.getName() +
											"\nDescription: " + p4.getDescription() +
											"\nManufacturer: " + p4.getManufacturer() +
											"\nRetail Price: " + p4.getRetailPrice() +
											"\nStore Price: " + p4.getStorePrice() +
											"\nQuantity: " + p4.getQuantity());
									break;

                                case 2:
                                    String[] cart = c1.viewAddedProducts();
                                    System.out.println("\nProducts in Cart: ");
                                    for (String productName : cart) {
                                        System.out.println(productName);
                                    }
                                    break;
                                    
                                case 3:
                                    System.out.print("Enter Product code: ");
                                    int pCode = scan.nextInt();

                                    ProductInterface selectedProduct = null;

                                    if (p1.getProductCode() == pCode) {
                                        selectedProduct = p1;
                                    } else if (p2.getProductCode() == pCode) {
                                        selectedProduct = p2;
                                    } else if (p3.getProductCode() == pCode) {
                                        selectedProduct = p3;
                                    } else if (p4.getProductCode() == pCode) {
                                        selectedProduct = p4;
                                    }

                                    if (selectedProduct != null) {
                                        c1.addProducts(selectedProduct);
                                        System.out.println("Product added to cart!");
                                    } else {
                                        System.out.println("Product not found!");
                                    }
                                    break;

                                case 4:
                                    System.exit(0);
                                    break;

                                default:
                                    System.out.println("Please choose from the choices only.");
                            }
                        }
                    default:
                        System.out.println("User does not exist!");
                }
            }

        }catch(Exception e){
            System.out.println("Client Side Error!" + e);
        }
        scan.close();
    }
}
