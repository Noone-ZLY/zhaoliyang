/**
 * @author zhaoliyang9
 * @des
 * @date 2023/6/7 9:32
 **/
public class Dog implements Animal{
    public Dog(){

    }
    @Override
    public void eat() {
        System.out.println("dog can eat");
    }

    public void talk(String msg){
        System.out.println("dog can talk:" + msg);
    }
}
