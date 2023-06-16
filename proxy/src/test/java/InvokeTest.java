import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/6/7 9:32
 **/
public class InvokeTest {
    public static void main(String[] args) throws NoSuchMethodException {
        Animal dog = new Dog();
        Method talk = dog.getClass().getDeclaredMethod("talk", String.class);
        talk.setAccessible(true);
        Constructor constructor = dog.getClass().getConstructor();
        Do
    }
}
