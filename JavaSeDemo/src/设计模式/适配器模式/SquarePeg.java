package 设计模式.适配器模式;

/**
 * 方钉
 */
public class SquarePeg {
    // 钉子直径
    private double width;

    public SquarePeg(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public double getSquare() {
        double result;
        result = Math.pow(this.width, 2);
        return result;
    }
}