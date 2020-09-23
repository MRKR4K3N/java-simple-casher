import java.util.Scanner;
import javax.swing.JOptionPane;

public class casher{

  public static String[] items;
  public static int[] quantity;
  public static float[] price;

  private static float calculation(){
    float overall_price = 0;
    for (int i = 0; i < items.length; i++){
      overall_price += price[i]*quantity[i];
    }
    return overall_price;
  }

  private static void msgBox(String msg){
    JOptionPane.showMessageDialog(null,msg);
  }

  public static void main(String[] args){
    String[] temp_items = new String[10];
    int[] temp_quantity = new int[10];
    float[] temp_price = new float[10];
    int count = 0;
    while(count < 10){
      Scanner userDone = new Scanner(System.in);
      Scanner userItName = new Scanner(System.in);
      Scanner userItQuantity = new Scanner(System.in);
      Scanner userItPrice = new Scanner(System.in);
      System.out.print("item name: ");
      String ItName = userItName.nextLine();
      System.out.print("quantity: ");
      int ItQuantity = userItQuantity.nextInt();
      System.out.print("price: ");
      float ItPrice = userItPrice.nextFloat();

      temp_items[count] = ItName;
      temp_quantity[count] = ItQuantity;
      temp_price[count] = ItPrice;
      count++;

      System.out.print("\n\ntype 'yes' if done, enter to continue: ");
      if (userDone.nextLine().equals("yes")){
        items = new String[count];
        quantity = new int[count];
        price = new float[count];
        for (int i = 0; i < count; i++){
          items[i] = temp_items[i];
          quantity[i] = temp_quantity[i];
          price[i] = temp_price[i];
        }
        break;
      }

    }

    System.out.println("\n+=======+===================+=======================+========================+===================+");
    System.out.println("| id no | items name        | items quantity        | price per quantity     | total price       |");
    System.out.println("+=======+===================+=======================+========================+===================+");
    for (int i = 0; i < items.length; i++){
      int id_length = Integer.toString(i).length();
      String ttprice = String.format("%.2f",price[i]*quantity[i]);
      String output = "| "+i+" ".repeat(6-id_length)+"| "+items[i]+" ".repeat(18-items[i].length())+"| "+quantity[i]+" ".repeat(22-Integer.toString(quantity[i]).length())+"| "+price[i]+" ".repeat(23-String.valueOf(price[i]).length())+"| "+ttprice+" ".repeat(18-ttprice.length())+"|";
      System.out.println(output);
    }
    String quantity = String.format("%.2f",calculation());
    System.out.println("+=======+===================+=======================+========================+===================+");
    System.out.println("|                                                                      total | "+quantity+" ".repeat(18-quantity.length())+"|");
    System.out.println("+============================================================================+===================+");
    String msg = "overall total price: $"+quantity;
    msgBox(msg);
  }

}
