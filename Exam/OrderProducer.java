public class OrderProducer
  {

    public OrderProducer(){}

    public Order newOrder(String flavour){
        return new Order(flavour);
    }

    public Order newRandomOrder(){
        return new Order();
    }


    public String listToppings(){
      return " TODAY'S TOPPINGS: " + String.join(",", Order.getToppings());
    }

}
