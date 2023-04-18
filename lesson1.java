/**
 * lesson1
 */
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;
import java.time.LocalTime;
public class lesson1 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);
        String encoding = System.getProperty("console.encoding", "cp866"); //Позволяет пользоваться русским языком
        Scanner iScanner = new Scanner(System.in, encoding); //encoding в конце для русского языка
        System.out.print("Введите имя: ");
        String name = iScanner.nextLine();
        System.out.println(name);
        iScanner.close();
        System.out.println(vremy(name));
        maxCount();
        System.out.println();
        int []nums = fillArray();
        printArray(nums);
        System.out.println();
        printArray(endElement(3, nums));

        
    }
    public static String vremy(String name) {
        LocalTime time = LocalTime.now();
        if (time.isAfter(LocalTime.of(5, 0)) && time.isBefore(LocalTime.of(11, 59)))
            System.out.println("Доброе утро, " + name +"!");
        else if (time.isAfter(LocalTime.of(12, 0)) && time.isBefore(LocalTime.of(17, 59)))
            System.out.println("Добрый день, "+ name +"!");
        else if (time.isAfter(LocalTime.of(18, 0)) && time.isBefore(LocalTime.of(22, 59)))
            System.out.println("Добрый вечер, "+ name +"!");
        else //(time.isAfter(LocalTime.of(23, 0)) && time.isBefore(LocalTime.of(4, 59)))
            System.out.println("Доброй ночи, " + name + "!");

        return " ";
    }

        /*Дан массив двоичных чисел, например [1,1,0,1,1,1,1], вывести
максимальное количество подряд идущих 1.
Найти максимальное количество подряд идущих одинаковых
элементов массива. (постараться сделать с одним циклом)*/

    public static void maxCount() {
        int []array1 = fillArray();
        int count = 0;
        int maxCount = count;
        for (int i= 0; i<array1.length; i++)
        {
            if (array1[i] == 1)
            {
                count++;
                if (maxCount<count)
                {
                    maxCount=count;
                }
            }
            else
            {
                count = 0;
            }
        }
        System.out.println(maxCount);
        printArray(array1);

    }
    public static int[] fillArray () {
        int []array = new int [10];
        Random rand = new Random();
        for (int i=0; i<10; i++)
        {
            array[i] = rand.nextInt(5);
        }
        return array;

}
   public static void printArray(int []array) {
        for (int i =0; i<array.length; i++)
        {
            System.out.print(array[i] + ", ");
        }

   }

   /*
    Дан массив nums = [3,2,1,2,3] и число val = 3.
Если в массиве есть числа, равные заданному, нужно перенести
эти элементы в конец массива.
Таким образом, первые несколько (или все) элементов массива
должны быть отличны от заданного, а остальные - равны ему.
[2,2,1,3,3]
[2,1,2,3,3]
    */
    public static int[] endElement(int val, int[]array)
    {
        //int []nums = fillArray();
        int []newNums = new int[array.length];
        int count = 0;
        int count1 = 0;
        for (int i=0; i<array.length; i++) 
        {
            if (array[i] == val)
            {
                newNums[array.length-1-count] = array[i];
                count++;
            }
            else 
            {
                newNums[count1] = array[i];
                count1++;
            }
        }

        
        return newNums;
    }

}