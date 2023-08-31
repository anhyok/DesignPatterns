package ex02;

public class MiniDuckSumulator {

	public static void main(String[] args) {
		Duck mallaDuck = new MallardDuck();
		mallaDuck.performQuack();
		mallaDuck.performFly();
		
		Duck model = new ModelDuck();
		model.performFly();
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();
		

		model.performQuack();
		model.setQuackBehavior(new MuteQuack());
		model.performQuack();
	}

}
