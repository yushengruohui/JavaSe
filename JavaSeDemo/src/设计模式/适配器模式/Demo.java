package 设计模式.适配器模式;

/**
 *测试案例
 */
public class Demo {
    public static void main(String[] args) {
        // 圆钉适应圆孔
        RoundHole hole = new RoundHole(5);
        RoundPeg rpeg = new RoundPeg(5);
        if (hole.fits(rpeg)) {
            System.out.println("圆钉可以钉入圆孔");
        }

        SquarePeg smallSqPeg = new SquarePeg(2);
        SquarePeg largeSqPeg = new SquarePeg(20);
        // hole.fits(smallSqPeg); // 方钉不能钉入圆孔，不适配，编译报错

        // 使用适配器解决这个问题
        SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
        SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);
        if (hole.fits(smallSqPegAdapter)) {
            System.out.println("方钉直径为2，适应半径为5的圆孔.");
        }
        if (!hole.fits(largeSqPegAdapter)) {
            System.out.println("方钉直径为2，不适应半径为5的圆孔.");
        }
    }
}