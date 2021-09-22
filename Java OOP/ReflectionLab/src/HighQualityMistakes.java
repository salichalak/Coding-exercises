import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class HighQualityMistakes {
    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;

        Field[] declaredFields = clazz.getDeclaredFields();

        Arrays.stream(declaredFields).filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(f-> System.out.printf("%s must be private!%n",f.getName()));

        Method[] declaredMethods = clazz.getDeclaredMethods();

        Arrays.stream(declaredMethods).filter(method -> method.getName().contains("get"))
                .filter(method -> !Modifier.isPublic(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m-> System.out.printf("%s have to be public!%n",m.getName()));

        Arrays.stream(declaredMethods).filter(method -> method.getName().contains("set"))
                .filter(method -> !Modifier.isPrivate(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m-> System.out.printf("%s have to be private!%n",m.getName()));
    }
}