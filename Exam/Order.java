import java.io.Serializable;
import java.util.Random;


public class Order{

  private String topping;
  private int orderNumber;
  private boolean received = false;
  private static String[] toppings = {"Raspberry","White Chocolate","Marshmallow"};

  public Order(String topping){
    this.topping = topping;
    this.orderNumber = new Random().nextInt(99999);
  }

  public Order(){
    this.topping =  toppings[new Random().nextInt(toppings.length)];
    this.orderNumber = new Random().nextInt(99999);
  }

  public static String [] getToppings(){
    return toppings;
  }

  public void receiveOrder(){
    received = true;
  }

  public String toString(){
    String s="";
    if(received){s = "[RECEIVED] ";} else s = "[WAITING] ";
    return s+"Order n "+ orderNumber + " topping: " + topping;
  }


}
