package 设计模式.建造者模式;

/**
 * 自定义产品车
 *
 * @author: yusheng
 * @create-date: 2019-12-20 11:53
 **/
public class MyCar implements Car {
    private String myWheel;
    private String myFrame;
    private String myEngine;
    private String myWidget;

    public MyCar() {
    }

    public MyCar(String myWheel, String myFrame, String myEngine, String myWidget) {
        this.myWheel = myWheel;
        this.myFrame = myFrame;
        this.myEngine = myEngine;
        this.myWidget = myWidget;
    }

    public static MyCarBuilder builder() {
        MyCarBuilder myCarBuilder = new MyCarBuilder();
        myCarBuilder.myCar = new MyCar();
        return myCarBuilder;
    }

    public static MyCarBuilder builder(MyCar myCar) {
        MyCarBuilder myCarBuilder = new MyCarBuilder();
        myCarBuilder.myCar = myCar == null ? new MyCar() : myCar;
        return myCarBuilder;
    }

    @Override
    public void setWheel(String wheel) {
        myWheel = wheel;
    }

    @Override
    public void setFrame(String frame) {
        myFrame = frame;
    }

    @Override
    public void setEngine(String engine) {
        myEngine = engine;
    }

    @Override
    public void setWidget(String widget) {
        myWidget = widget;
    }

    @Override
    public String toString() {
        return "MyCar{" +
                "myWheel='" + myWheel + '\'' +
                ", myFrame='" + myFrame + '\'' +
                ", myEngine='" + myEngine + '\'' +
                ", myWidget='" + myWidget + '\'' +
                '}';
    }

    public String getMyWheel() {
        return this.myWheel;
    }

    public void setMyWheel(String myWheel) {
        this.myWheel = myWheel;
    }

    public String getMyFrame() {
        return this.myFrame;
    }

    public void setMyFrame(String myFrame) {
        this.myFrame = myFrame;
    }

    public String getMyEngine() {
        return this.myEngine;
    }

    public void setMyEngine(String myEngine) {
        this.myEngine = myEngine;
    }

    public String getMyWidget() {
        return this.myWidget;
    }

    public void setMyWidget(String myWidget) {
        this.myWidget = myWidget;
    }


    public static class MyCarBuilder {

        private MyCar myCar;

        public MyCarBuilder myWheel(String myWheel) {
            myCar.myWheel = myWheel;
            return this;
        }

        public MyCarBuilder myFrame(String myFrame) {
            myCar.myFrame = myFrame;
            return this;
        }

        public MyCarBuilder myEngine(String myEngine) {
            myCar.myEngine = myEngine;
            return this;
        }

        public MyCarBuilder myWidget(String myWidget) {
            myCar.myWidget = myWidget;
            return this;
        }

        public MyCar build() {
            return this.myCar;
        }

    }

}