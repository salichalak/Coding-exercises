import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException, IOException {

        Class<Reflection> clazz = Reflection.class;
        System.out.println(clazz);

        Class<? super Reflection> superClass = clazz.getSuperclass();
        System.out.println(superClass);

        Class[] interfaces = clazz.getInterfaces();
        Arrays.stream(interfaces).forEach(System.out::println);

        Object reflection = clazz.getDeclaredConstructor().newInstance();
        System.out.println(reflection);
    }
}