import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    static void gameInfo(){
        System.out.println("*** Sayı Tahmin Oyununa Hoşgeldiniz! ***");
        System.out.println("Aklımdan 1 ile 100 arasında bir sayı tuttum.\nOyunda 5 tahmin hakkınız vardır!");
        System.out.println("Tahmininiz gizli sayıya yakın ise 'Sıcak Tahmin',değilse 'Soğuk Tahmin'dir.");
        System.out.println("Haydi oynayalım!");

    }
    public static void main(String[] args) {
        Random random = new Random();
        int number = random.nextInt(100);
        
        
        try (Scanner input = new Scanner(System.in)) {
            int right = 0;
            int selected;
            int[] wrong = new int[5];
            boolean isWin = false;
            boolean isWrong = false;

            gameInfo();

            while (right < 5) {
                System.out.print("Lütfen tahmininizi giriniz : ");
                selected = input.nextInt();

                if (selected < 0 || selected > 99) {
                    System.out.println("Lütfen 0-100 arasında bir değer giriniz.");
                    if (isWrong) {
                        right++;
                        System.out.println("Çok fazla hatalı giriş yaptınız. Kalan hak : " + (5 - right));
                    } else {
                        isWrong = true;
                        System.out.println("Bir daha hatalı girişinizde hakkınızdan düşülecektir.");
                    }
                    continue;
                }

                if (selected == number) {
                    System.out.println("Tebrikler, doğru tahmin ! Tahmin ettiğiniz sayı : " + number);
                    isWin = true;
                    break;
                } else {
                    System.out.println("Yanlış Tahmin!");
                    if (selected > number) {
                        if((selected-number)<10){
                            System.out.println(selected + " sayısı, gizli sayıdan büyüktür.Sıcak tahmin!");
                        }else{
                            System.out.println(selected + " sayısı, gizli sayıdan büyüktür.Soğuk tahmin!");
                        }                        
                    } else {
                        if((number-selected)<10){
                            System.out.println(selected + " sayısı, gizli sayıdan küçüktür.Sıcak tahmin!");
                        }else{
                            System.out.println(selected + " sayısı, gizli sayıdan küçüktür.Soğuk tahmin!");
                        }                         
                    }
                    wrong[right++] = selected;
                    System.out.println("Kalan hakkı : " + (5 - right));
                }
            }

            if (!isWin) {
                System.out.println("Kaybettiniz ! " + "\nGizli Sayı : " + number);
                if (!isWrong) {
                    System.out.println("Tahminleriniz : " + Arrays.toString(wrong));
                }
            }
        }

    }
}
