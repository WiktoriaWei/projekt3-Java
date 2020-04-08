package zad3_249609;

import java.util.Random;
import java.util.Scanner;

public class Start {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int Tab[] = new int[200];
        System.out.println("Zawartość tablicy:");
        for (int i=0; i<Tab.length; i++) //losowe liczby(o zadeklarowanej maksymalnej wartości w 200 elementowej tablicy)
        {
            Random liczba = new Random();
            Tab[i] = liczba.nextInt(400);
            System.out.print(Tab[i]+ " ");
        }
        System.out.println("Koniec");

        int a;
        System.out.println("Jeśli chcesz użyć sortowania bąbelkowego wpisz 1, jeśli kubełkowego wypisz 2:");
            a = scan.nextInt();
        switch (a)
        {
            case 1:
                Sortable b = new Bąbelkowe();
                Sortable c = b;
                b.sort(Tab); //wywołuje sort i step_counting z klasy Bąbelkowe
                b.step_counting();
                break;
            case 2:
                Kubełkowe k = new Kubełkowe();
                Sortable s = k;
                k.sort(Tab); //wywołuje sort i step_counting z klasy Kubełkowe
                k.step_counting();
                break;
            default:
                System.out.println("Nie wybrałeś żadnego sposobu sortowania.");
        }
    }
}
