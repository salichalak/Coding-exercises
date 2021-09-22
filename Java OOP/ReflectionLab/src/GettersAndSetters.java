import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Comparator;

public class GettersAndSetters {
    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;

        Method[] declaredMethods = clazz.getDeclaredMethods();

        declaredMethods = Arrays.stream(declaredMethods)
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        for (Method method : declaredMethods) {
            String name = method.getName();

            if (name.contains("get")) {
                System.out.printf("%s will return class %s%n", name, method.getReturnType().getName());
            }
        }

        for (Method method : declaredMethods) {
            String name = method.getName();

            if (name.contains("set")) {
                System.out.printf("%s and will set field of class ", name);

                Parameter[] parameterTypes = method.getParameters();

                for (Parameter parameterType : parameterTypes) {
                    System.out.println(parameterType.getType().getName() + " ");
                }
            }
        }
    }
}