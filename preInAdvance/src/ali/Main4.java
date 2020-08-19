package ali;

public class Main4 {
    /**
     * 抽象工厂模式；；
     */
}

class Phone{

}
class IPhone extends Phone{

}
class  MiPhone extends Phone{

}
class Computer{

}

class Mac extends Computer{

}

class MiMac extends Computer{

}

interface AbstractFactory{

    abstract Phone producePhone();

    abstract Computer produceComputer();
}

class AppleFactory implements AbstractFactory{

    @Override
    public Phone producePhone() {
        return new IPhone();
    }

    @Override
    public Computer produceComputer() {
        return new Mac();
    }
}
class MiFactory implements AbstractFactory{

    @Override
    public Phone producePhone() {
        return new MiPhone();
    }

    @Override
    public Computer produceComputer() {
        return new MiMac();
    }
}

