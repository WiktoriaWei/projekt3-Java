package zad3_249609;

public class Bąbelkowe implements Sortable {
    int step = 0;
    public int[] sort(int[] tab) {
        for(int i = 0; i < tab.length-1; i++)
        {
            step++; //w sortowaniu babęlkowym liczba porównań jest o 1 mniejsza od wielkości tablicy(ilości elementów)
            for(int j = 0; j < tab.length-i-1; j++) //porównuje ze sobą kolejne elementy tablicy i je zamienia
            {
                if(tab[j] > tab[j+1])
                {
                    int temp = tab[j];
                    tab[j] = tab[j+1];
                    tab[j+1] = temp;
                }
            }
        }

        for(int i=0; i<tab.length; i++)
        {
            System.out.print(tab[i]+" ");
        }
        System.out.println("Koniec");
        return new int[0];
    }

    @Override
    public double step_counting() {
        System.out.println("Liczba porównań:" + step);
        return 0;
    }
}
