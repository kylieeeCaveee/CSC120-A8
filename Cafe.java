/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements{
    private int nCoffeeOunces; 
    private int nSugarPackets; 
    private int nCreams; 
    private int nCups; 
    /**
     * This is the constructor for the cafe it starts with 800 ounces of coffee, 100 sugar packets, 100 creams, and 100 cups. 
     * @param name the name of the cafe
     * @param address the address of the cafe
     * @param nFloors the number of floors the cafe has
     */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors); 
        this.nCoffeeOunces= 800; 
        this.nSugarPackets=100; 
        this.nCreams=100; 
        this.nCups=100; 
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * This is the constructor for the cafe with all default values. It has one floor and it starts with 800 ounces of coffee, 100 sugar packets, 100 creams, and 100 cups.
     */
    public Cafe(){
        super("Unkown Cafe Name", "Unkown Cafe Address", 1); 
        this.nCoffeeOunces= 800; 
        this.nSugarPackets=100; 
        this.nCreams=100; 
        this.nCups=100; 
        System.out.println("You have built a cafe: ☕");
    }
    /**
     * This method sells a coffee with the respective measurments and decreases those measurments from the stock. It also restocks the coffee if it is out of stock.
     * @param size the size of the coffee they sold 
     * @param nSugarPackets the number of sugar packets the coffee sold uses
     * @param nCreams the number of creams the coffee sold uses
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if(size> this.nCoffeeOunces){
            restock( this.nCups*8, 0,0,0); 
            // System.out.println("restocking coffee");
        }
        this.nCoffeeOunces-= size; 
        if(nSugarPackets> this.nSugarPackets){
            restock(0, this.nCups*2, 0,0); 
            // System.out.println("restocking sugar packets" );
        }
        this.nSugarPackets-=nSugarPackets; 
        if(nCreams>this.nCreams){
            restock(0,0, this.nCreams*2, 0); 
            // System.out.println("restocking creams");
        }
        this.nCreams-= nCreams; 
        if(this.nCups==0){
            restock(0,0,0,20);
            // System.out.println("restocking cups"); 
        }
        this.nCups-= 1; 
    }

    /**
     * This function allows you to order one type of coffee multiple times. The size, sugar, and creams will remain the same for all coffees. 
     * @param size the size of each coffee's ordered
     * @param nSugarPackets the numer of sugars in each coffee ordered
     * @param nCreams the number of creams in each coffee ordered
     * @param nOrders the number of coffee's ordered
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams, int nOrders){
        for (int i=1; i<=nOrders; i++){
            if(size> this.nCoffeeOunces){
                restock( this.nCups*8, 0,0,0); 
                // System.out.println("restocking coffee");
            }
            this.nCoffeeOunces-= size; 
            if(nSugarPackets> this.nSugarPackets){
                restock(0, this.nCups*2, 0,0); 
                // System.out.println("restocking sugar packets" );
            }
            this.nSugarPackets-=nSugarPackets; 
            if(nCreams>this.nCreams){
                restock(0,0, this.nCreams*2, 0); 
                // System.out.println("restocking creams");
            }
            this.nCreams-= nCreams; 
            if(this.nCups==0){
                restock(0,0,0,20);
                // System.out.println("restocking cups"); 
            }
            this.nCups-= 1; 
        }
    }
    /**
     * This restocks the amount of coffee in the cafe to the given amount
     * @param nCoffeeOunces the amount of coffee to be restocked
     * @param nSugarPackets the amount of sugar packets to be restocked
     * @param nCreams the amount of creams to be restocked
     * @param nCups the amount of cups to be restocked
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces+= nCoffeeOunces; 
        this.nSugarPackets+= nSugarPackets; 
        this.nCreams+=nCreams;
        this.nCups+=nCups; 
    }

    /**
     * This method prints out all of the options that users can perform at the cafe
     */
    public void showOptions(){
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit()  \n + showOptions()");
        System.out.println("Cafe Specific Options Include"+ "\n + sellCoffee(int n, int n, int n)");
    }
    /**
     * This method let's players know they aren't welcome past the first floor on cafes.
     */
    public void goToFloor(int floorNum){
        throw new RuntimeException("You are not allowed past the first floor on Cafes.");   
    }
    
    public static void main(String[] args) {
        Cafe testCafe= new Cafe("cc cafe", "made up", 4);
        testCafe.sellCoffee(800, 100,100); 
        testCafe.sellCoffee(8, 2,2); 
        testCafe.showOptions();
        try{
            testCafe.goToFloor(3);  
        }catch (RuntimeException e){
            System.out.println(e.getLocalizedMessage());
        }
        testCafe.sellCoffee(800,100,100,10); 
    }
    
}
