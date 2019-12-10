package cumulative_gpa_calculator;

/**
 *
 * @author bbugieda
 */
public enum CreditHours 
{
    ONE(1.00),
    TWO(2.00),
    THREE(3.00),
    FOUR(4.00);
    
    private double creditHours = 0.00;
    
    private CreditHours(double creditHours) {
        this.creditHours = creditHours;
    }
    
    public double getCreditHours() {
        return this.creditHours;
    }
}
