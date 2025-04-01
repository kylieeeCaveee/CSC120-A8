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
    
    public static void main(String[] args) {
        Cafe testCafe= new Cafe("cc cafe", "made up", 1);
        testCafe.sellCoffee(800, 100,100); 
        testCafe.sellCoffee(8, 2,2); 
    }
    
}
