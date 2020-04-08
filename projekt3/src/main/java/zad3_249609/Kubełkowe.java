package zad3_249609;

import java.util.LinkedList;
import java.util.List;

public class Kubełkowe implements Sortable {
    int step = 0;
    private void sortBucket(List<Integer> kubełek) //sortuje elementy w kubełku sortowaniem bąbelkowym
    {
        for(int i = 0; i < kubełek.size()-1; i++)
        {
            step++; // liczba porównań zależy od ilości kubełków oraz sposobu sortowania użytego do posortowania elementów w kubełku
            for(int j = 0; j < kubełek.size()-i-1; j++) //w tym przypadku liczba porównań będzie równa sumie porównań z każdego kubełka
            {//która przypadku sortowania bąbelkowego tu wykorzystanego jest równa liczbie elementów kubełka minus 1
                if(kubełek.get(j) > kubełek.get(j+1))
                {
                    int temp = kubełek.get(j);
                    kubełek.set(j, kubełek.get(j+1));
                    kubełek.set(j+1, temp);
                }
            }
        }
    }

    @Override
    public int[] sort(int[] tab)
    {
        int liczbakubełków = 100; //im więcej kubełków tym mniejsza liczba porównań
        int max = tab[0];
        for(int i = 0; i < tab.length; i++) //szukam maksymalnej wartości z tablicy
        {
            if(max < tab[i])
            {
                max = tab[i];
            }
        }

        List<Integer>[] kubełki = new List[liczbakubełków]; //tworze liste przechowującą kubełki

        for(int i = 0; i < liczbakubełków; i++)
        {
            kubełki[i] = new LinkedList<>(); //tworzę listę dla kązdego kubełka
        }
        for(int num : tab) //rozdziela elementy na kubełki
        {
            int indeks=(num/(max/liczbakubełków + 1));
            kubełki[indeks].add(num);
        }

        int a = 0;
        for(List<Integer> kubełek : kubełki)
        {
            sortBucket(kubełek);
            for(int num : kubełek) //zbiera pojedyńcze elementy i wstawia do oryginalnej tablicy
            {
                tab[a++] = num;
            }
        }

        for (int i = 0; i < tab.length; i++)
        {
            System.out.print(tab[i] + " ");
        }
        System.out.println("Koniec");
        return new int[0];
    }

    @Override
    public double step_counting()
    {
        System.out.println("Liczba porównań:" + step);
        return 0;
    }

}
