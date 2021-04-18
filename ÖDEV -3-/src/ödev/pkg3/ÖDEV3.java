/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ödev.pkg3;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Hilal
 */
public class ÖDEV3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("Lütfen Satır Büyüklüğünü Giriniz : ");
        int satir;
        Scanner deger = new Scanner(System.in);
        satir = deger.nextInt();
        System.out.print("Lütfen Sütun Büyüklüğünü Giriniz : ");
        int sutun;
        sutun = deger.nextInt();
        System.out.println();
        
        int [][] tarlabüyüklüğü = new int [satir][sutun];
        for (int i = 0; i < satir; i++) 
        {
            for (int j = 0; j < sutun; j++) 
            {
                System.out.print(" * ");
            }
            System.out.println();
        }
        System.out.println();
        
        int zorlukderecesi, mayinsatir, mayinsutun, mayinsayisi;
        int [][] mayinliyerler = new int [satir][sutun];
        
        System.out.print("Lütfen 20 İle 80 Arasında Olacak Şekilde Oyunun Zorluk Derecesini Giriniz : ");
        
        while(true)
        {
            zorlukderecesi = deger.nextInt();
            if(!(zorlukderecesi >= 20 && zorlukderecesi <= 80))
            {
                System.out.println("Lütfen Sizden İstenilen Aralıkta Bir Zorluk Derecesi Giriniz !");
                System.out.print("Şimdi Tekrardan 20 İle 80 Arasında Olacak Şekilde Oyunun Zorluk Derecesini Giriniz : ");
                continue;
            }
            else
            {
                double z = zorlukderecesi * 0.01;
                mayinsayisi = (int) (satir * sutun * z);
            }
            break;
        }
        
        Random uret = new Random();
        for (int i = 0; i < mayinsayisi; i++) 
        {
            mayinsatir = uret.nextInt(satir);
            mayinsutun = uret.nextInt(sutun);
            if(mayinliyerler[mayinsatir][mayinsutun] == 1)
            {
                try
                {
                    mayinliyerler[mayinsatir - 1][mayinsutun - 1] = 1;
                }
                catch(Exception e)
                {
                    System.out.print("Hata = " + e + "  ");
                }
            }
            
            else
            {
                mayinliyerler[mayinsatir][mayinsutun] = 1;
            }
        }
        
        for (int i = 0; i < satir; i++) 
        {
            for (int j = 0; j < sutun; j++) 
            {
                if(mayinliyerler[i][j] != 1)
                {
                    mayinliyerler[i][j] = 0;
                }
            }
        }
        System.out.println("Mayınlar Yerleştirildi ");
        System.out.println();
        
        for (int i = 0; i < satir; i++) 
        {
            for (int j = 0; j < sutun; j++) 
            {
                System.out.print(mayinliyerler[i][j] + "  ");               
            }
            System.out.println("  ");
        }
        
        System.out.println();
        System.out.println("BAŞLAYABİLİRSİNİZ");
        int puan = 0;
        String [][] mayinlibölge = new String[satir][sutun];
        for (int i = 0; i < satir; i++) 
        {
            for (int j = 0; j < sutun; j++) 
            {
                mayinlibölge [i][j] = " * ";
            }
        }
        
            while(true)
            {
                System.out.println();
                System.out.print("Lütfen Oyunun Satır Değerini Giriniz : ");
                int sa = deger.nextInt();
                if(sa == satir || sa > satir)
                {
                    System.out.println("Girmiş Olduğunuz Değer Satır Boyutu İle Eşdeğer Ya Da Büyük Olduğundan Bu Değeri Giremezsiniz Lütfen Farklı Bir Değer Giriniz.");
                    continue;
                }
                
                System.out.print("Lütfen Oyunun Sütun Değerini Giriniz : " );
                int su = deger.nextInt();
                if(su == sutun || su > sutun)
                {
                    System.out.println("Girmiş Olduğunuz Değer Sütun Boyutu İle Eşdeğer Ya Da Büyük Olduğundan Bu Değeri Giremezsiniz Lütfen Farklı Bir Değer Giriniz.");
                    continue;
                }
                System.out.println();
                
                if(mayinliyerler[sa][su] == 1)
                {
                    System.out.println("OYUNUNUZ SONA ERDİ");
                    System.out.println("Kazanmış Olduğunuz Toplam Puanınız : " + puan + "\n");
                 
                    for (int i = 0; i < satir; i++) 
                    {
                        for (int j = 0; j < sutun; j++) 
                        {
                            System.out.print(mayinliyerler[i][j] + "  ");
                        }
                        System.out.println("  ");
                    }
                    break;
                }
                else
                {
                    mayinlibölge [sa][su] = " 0 ";
                    puan += 5;
                    for (int i = 0; i < satir; i++) 
                    {
                        for (int j = 0; j < sutun; j++) 
                        {
                            System.out.print(mayinlibölge [i][j] + "");
                        }
                        System.out.println("  ");
                    }
                }
            }
    }
    
}
