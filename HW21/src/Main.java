import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {


    public static List<Integer> doubling(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> number * 2)
                .collect(Collectors.toList());
    }


    public static List<Integer> square(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> number * number)
                .collect(Collectors.toList());
    }

    public static List<String>  moreY(List<String> strings){
        return strings.stream()
                .map(str -> "y" + str + "y")
                .collect(Collectors.toList());
    }

    public static List<Integer>  noNeg(List<Integer> numbers){
        return numbers.stream()
                .filter(number -> number >= 0)
                .collect(Collectors.toList());
    }

    public static List<Integer> no9(List<Integer> numbers){
        return numbers.stream()
                .filter(number -> number % 10 != 9)
                .collect(Collectors.toList());
    }

    public static List<String>  noZ(List<String> strings){
        return strings.stream()
                .filter(str -> !str.contains("z") )
                .collect(Collectors.toList());
    }

    public static List<String> refinedStrings (List<String> strings){
        return strings.stream().distinct()
                .collect(Collectors.toList());
    }

    public static List<String> flatten (List<String> strings){
        return strings.stream().flatMap(str-> Arrays.stream(str.split(" ")))
                .collect(Collectors.toList());
    }




    public static void main(String[] args) {
        List<Integer> input1 = List.of(1, 2, 3);
        List<Integer> input2 = List.of(6, 8, 6, 8, -1);
        List<Integer> input3 = List.of();


        System.out.println(doubling(input1));
        System.out.println(doubling(input2));
        System.out.println(doubling(input3));


        System.out.println(square(input1));
        System.out.println(square(input2));
        System.out.println(square(input3));

        List<String> input4 = List.of("a", "b", "c");
        List<String> input5 = List.of("hello", "there");
        List<String> input6 = List.of("yay");


        System.out.println(moreY(input4));
        System.out.println(moreY(input5));
        System.out.println(moreY(input6));

        List<Integer> input7 = List.of(1, -2, 3, -4, 5);
        List<Integer> input8 = List.of(-10, -20, 30, 40, -50);
        List<Integer> input9 = List.of();


        System.out.println(noNeg(input7));
        System.out.println(noNeg(input8));
        System.out.println(noNeg(input9));

        List<Integer> input10 = List.of(1, 2, 19);
        List<Integer> input11 = List.of(9, 19, 29, 3);
        List<Integer> input12 = List.of(1, 2, 3);


        System.out.println(no9(input10));
        System.out.println(no9(input11));
        System.out.println(no9(input12));

        List<String> input13 = List.of( "aaa", "aza");
        List<String> input14 = List.of("hziz", "hzello", "hi");
        List<String> input15 = List.of("hello", "howz", " are", "youz");


        System.out.println(noZ(input13));
        System.out.println(noZ(input14));
        System.out.println(noZ(input15));
    }

    }

