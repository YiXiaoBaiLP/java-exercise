package buzz.yixiaobai.lambda.lambdaboolean;

import java.util.function.BiFunction;

/**
 * Lambda演算
 */
public class LambdaBoolean {
    public static BiFunction TRUE = (left, right) -> left;
    public static BiFunction FALSE = (left, right) -> right;

    public static BiFunction and(BiFunction bool1, BiFunction bool2){
            return (BiFunction) bool1.apply(bool2, FALSE); // bool2(bool2, FALSE)
    }

    public  static BiFunction or(BiFunction  bool1, BiFunction bool2){
        return (BiFunction) bool1.apply(TRUE, bool2);
    }

    public static BiFunction not(BiFunction  bool){
        return (BiFunction) bool.apply(TRUE, FALSE);
    }

    public static void main(String[] args){
        System.out.println(and(TRUE, FALSE).apply("true", "false"));
        System.out.println(and(TRUE, TRUE).apply("true","false"));
        System.out.println(and(FALSE, FALSE).apply("true","false"));

        System.out.println(or(TRUE, FALSE).apply("true", "false"));
        System.out.println(or(FALSE, FALSE).apply("true", "false"));
        System.out.println(or(FALSE, TRUE).apply("true", "false"));

        System.out.println(not(TRUE).apply("true", "false"));
        System.out.println(not(FALSE).apply("true", "false"));

    }
}
