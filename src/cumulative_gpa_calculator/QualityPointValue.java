package cumulative_gpa_calculator;

/**
 *
 * @author bbugieda
 */
public enum QualityPointValue 
{
    A(4.00),
    A_MINUS(3.667),
    B_PLUS(3.333),
    B(3.000),
    B_MINUS(2.667),
    C_PLUS(2.333),
    C(2.000),
    C_MINUS(1.667),
    D_PLUS(1.333),
    D(1.000),
    D_MINUS(0.667),
    F(0.00);
    
    private double qualityPoints = 0.00;
    
    private QualityPointValue(double qualityPoints) {
        this.qualityPoints = qualityPoints;
    }
    
    public double getPoints() {
        return this.qualityPoints;
    }
}
