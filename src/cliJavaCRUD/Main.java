/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliJavaCRUD;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author denis
 */
public class Main {
    //me krijimin e kontrollerit, krijohet dhe Connection automatikisht
    static Controller con = new Controller();
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args){
        int i = -1;
        while(i != 0){
            
            System.out.println("1.Admin Menu\n2.Perdorues Menu\n0.Dil");
            try{
                i = sc.nextInt();
                switch(i){
                case 1:
                    adminMenu();
                    break;
                case 2:
                    perdoruesMenu();
                    break;
                }
            }catch(Exception e){
                i = -1;
            }
        }
        
    }
    
    public static void adminMenu(){
        
        int i = -1;
        while(i != 0){
            
            System.out.println("1.Listo Punonjesit\n2.Krijo Punonjes\n3.Modifiko Punonjes\n4.Fshi Punonjes\n0.Dil");
            try{
                i = sc.nextInt();
                switch(i){
                    case 1:
                        listoPunonjesitMenu();
                        break;
                    case 2:
                        krijoPunonjesMenu();
                        break;
                    case 3:
                        modifikoPunonjesMenu();
                        break;
                    case 4:
                        fshiPunonjesMenu();
                        break;
                }
            }catch(Exception e){
                i=-1;
            }
        }
    }
    
    public static void perdoruesMenu(){
        int i = -1;
        while(i != 0){
            
            System.out.println("1.Listo Te dhenat\n0.Dil");
            try{
                i = sc.nextInt();
                switch(i){
                    case 1:
                        listoPunonjesitMenu();
                        break;
                }
            }catch(Exception e){
                i=-1;
            }
        }
    }
    

    public static void listoPunonjesitMenu() {
        int i = -1;
        while(i != 0){
            System.out.println("1.Listo Punonjes Komisioni\n2.Listo Punonjes Komisioni me Page Baze\n3.Listo Punonjes me Ore\n4.Listo Punonjes me Page Baze\n0.Dil");
            i = sc.nextInt();
            switch(i){
                case 1:
                    List<PunonjesKomisioni> pk = con.merrPunonjesKomisioni();
                    if(pk.isEmpty()){
                        System.out.println("Asnje punonjes ne kete kategori");
                        continue;
                    }
                    System.out.printf("%-12s %-12s %-12s %-15s %-12s %-12s %-12s %-12s \n", "ID", "Emri", "Mbiemri", "Viti I Lindjes", "Pervoja", "Shitjet", "Komisioni", "Paga" );
                    System.out.println("---------------------------------------------------------------------------------------------------");
                    pk.forEach((p) -> {
                        System.out.printf("%-12s %-12s %-12s %-15s %-12s %-12s %-12s %-10.2f\n", p.merrId(), p.merrEmrin(), p.merrMbiemrin(), p.merrVitinELindjes(), p.merrPervojen(), p.merrShitjet(), p.merrKomisionin(), p.paga());
            });
                    break;
                case 2:
                    List<PunonjesKomisioniMePageBaze> pkpb = con.merrPunonjesKomisioniMePageBaze();
                    if(pkpb.isEmpty()){
                        System.out.println("Asnje punonjes ne kete kategori");
                        continue;
                    }
                    System.out.printf("%-12s %-12s %-12s %-15s %-12s %-12s %-12s %-12s %-12s \n","ID", "Emri", "Mbiemri", "Viti I Lindjes", "Pervoja", "Shitjet", "Komisioni", "Paga", "Paga Baze" );
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");
                    pkpb.forEach((p) -> {
                        System.out.printf("%-12s %-12s %-12s %-15s %-12s %-12s %-12s %-12s %-10.2f\n", p.merrId(), p.merrEmrin(), p.merrMbiemrin(), p.merrVitinELindjes(), p.merrPervojen(), p.merrShitjet(), p.merrKomisionin(), p.paga(), p.merrPageBaze());
            });
                    break;
                case 3:
                    List<PunonjesMeOre> po = con.merrPunonjesMeOre();
                    if(po.isEmpty()){
                        System.out.println("Asnje punonjes ne kete kategori");
                        continue;
                    }
                    System.out.printf("%-12s %-12s %-12s %-15s %-12s %-12s %-12s %-12s \n","ID", "Emri", "Mbiemri", "Viti I Lindjes", "Pervoja", "Paga per Ore", "Oret", "Paga" );
                    System.out.println("---------------------------------------------------------------------------------------------------");
                    po.forEach((p) -> {
                        System.out.printf("%-12s %-12s %-12s %-15s %-12s %-12s %-12s %-10.2f\n", p.merrId(), p.merrEmrin(), p.merrMbiemrin(), p.merrVitinELindjes(), p.merrPervojen(), p.merrPagePerOre(), p.merrOret(), p.paga());
            });
                    break;
                case 4:
                    List<PunonjesMePageBaze> pb = con.merrPunonjesMePageBaze();
                    if(pb.isEmpty()){
                        System.out.println("Asnje punonjes ne kete kategori");
                        continue;
                    }
                    System.out.printf("%-12s %-12s %-12s %-15s %-12s %-12s \n","ID", "Emri", "Mbiemri", "Viti I Lindjes", "Pervoja", "Paga" );
                    System.out.println("------------------------------------------------------------------------");
                    pb.forEach((p) -> {
                        System.out.printf("%-12s %-12s %-12s %-15s %-12s %-10.2f\n",p.merrId(), p.merrEmrin(), p.merrMbiemrin(), p.merrVitinELindjes(), p.merrPervojen(), p.paga());
            });
                    break;
            }
        }
    }

    public static void krijoPunonjesMenu() {
        int i = -1;
        String emri, mbiemri;
        int pervoja,vitiLindjes,oret;
        double kom,sh,pagaPerOre,pagaBaze;
        while(i != 0){
            System.out.println("1.Krijo Punonjes Komisioni\n2.Krijo Punonjes Komisioni me Page Baze\n3.Krijo Punonjes me Ore\n4.Krijo Punonjes me Page Baze\n0.Dil");
            i = sc.nextInt();
            sc.nextLine();
            if(i == 0){
                continue;
            }
            //Keto te dhena jane te perbashketa pavaresisht llojit
            System.out.print("Shkruani emrin e punonjesit:");
            emri = sc.nextLine();
            System.out.print("Shkruani mbiemrin e punonjesit:");
            mbiemri = sc.nextLine();
            System.out.print("Shkruani vitin e lindjes e punonjesit:");
            vitiLindjes = sc.nextInt();
            System.out.print("Shkruani pervojen e punonjesit:");
            pervoja = sc.nextInt();
            switch(i){
                    case 1:
                        System.out.print("Shkruani komisionin e punonjesit:");
                        kom = sc.nextDouble();
                        System.out.print("Shkruani shitjet e punonjesit:");
                        sh = sc.nextDouble();
                        PunonjesKomisioni pk = new PunonjesKomisioni("pk",emri,mbiemri,vitiLindjes,pervoja,kom,sh);
                        if(con.krijoPunonjesKomisioni(pk)){
                            System.out.println("Punonjesi i Komisionit "+pk.merrEmrin()+" "+pk.merrMbiemrin()+" u krijua me sukses");
                        }else{
                            System.out.println("Error. Punonjesi nuk u krijua me sukses!");
                        }
                        break;
                    case 2:
                        System.out.print("Shkruani komisionin e punonjesit:");
                        kom = sc.nextDouble();
                        System.out.print("Shkruani shitjet e punonjesit:");
                        sh = sc.nextDouble();
                        System.out.print("Shkruani pagen baze te punonjesit:");
                        pagaBaze = sc.nextDouble();
                        PunonjesKomisioniMePageBaze pkpb = new PunonjesKomisioniMePageBaze("pkpb",emri,mbiemri,vitiLindjes,pervoja,kom,sh,pagaBaze);
                        if(con.krijoPunonjesKomisioniMePageBaze(pkpb)){
                            System.out.println("Punonjesi i Komisionit me Page Baze "+pkpb.merrEmrin()+" "+pkpb.merrMbiemrin()+" u krijua me sukses");
                        }else{
                            System.out.println("Error. Punonjesi nuk u krijua me sukses!");
                        }
                        break;
                    case 3:
                        System.out.print("Shkruani pagen per ore te punonjesit:");
                        pagaPerOre = sc.nextDouble();
                        System.out.print("Shkruani oret e punonjesit:");
                        oret = sc.nextInt();
                        PunonjesMeOre po = new PunonjesMeOre("po",emri,mbiemri,pervoja,vitiLindjes,pagaPerOre,oret);
                        if(con.krijoPunonjesMeOre(po)){
                            System.out.println("Punonjesi me ore "+po.merrEmrin()+" "+po.merrMbiemrin()+" u krijua me sukses");
                        }else{
                            System.out.println("Error. Punonjesi nuk u krijua me sukses!");
                        }
                        break;
                    case 4:
                        System.out.print("Shkruani pagen baze te punonjesit:");
                        pagaBaze = sc.nextDouble();
                        PunonjesMePageBaze pb = new PunonjesMePageBaze("pb",emri,mbiemri,vitiLindjes,pervoja,pagaBaze);
                        if(con.krijoPunonjesMePageBaze(pb)){
                            System.out.println("Punonjesi me page baze "+pb.merrEmrin()+" "+pb.merrMbiemrin()+" u krijua me sukses");
                        }else{
                            System.out.println("Error. Punonjesi nuk u krijua me sukses!");
                        }
                        break;
                }
        }
    }
    
    public static void modifikoPunonjesMenu() {
        int i = -1;
        int zgjedhja = -1;
        int oret;
        double kom,sh,pagaPerOre,pagaBaze;
        while(i != 0){
            System.out.println("1.Modifiko Punonjes Komisioni\n2.Modifiko Punonjes Komisioni me Page Baze\n3.Modifiko Punonjes me Ore\n4.Modifiko Punonjes me Page Baze\n0.Dil");
            i = sc.nextInt();
            /*Ne vend qe te kerkojme id cdo here, e kerkojme ne fillim para
            switch. Por nese inputi eshte i daljes atehere kerkimi i punonjesit
            nuk duhet te akivizohet keshtu qe kontrollojme perseri perpara switch.
            */
            if(i == 0){
                continue;
            }
            System.out.println("Shkruani ID e punonjesit:");
            int id = sc.nextInt();
            /*Pjeset e perbashketa qe mund te modifikohen mund te vendoseshin ne
            te njejtin vend me ID por duhet te kontrollojme nese punonjesi
            ekziston apo jo ne fillim.*/
            switch(i){
                    case 1:
                        PunonjesKomisioni pk = con.merrNjePunonjesKomisioni(id);
                        if(pk == null){
                            System.out.println("Punonjesi nuk ekziton");
                            continue;
                        }
                        //Pjeset e perbashketa qe mund te modifikohen
                        System.out.println("1.Modifiko Emrin\n2.Modifiko Mbiemrin\n3.Modifiko Pervojen\n4.Modifiko Vitin e Lindjes");
                        System.out.println("5.Modifiko Komisionin\n6.Modifiko Shitjet\n");
                        zgjedhja = sc.nextInt();
                        
                        if(zgjedhja < 5){
                            pk = modifikoPunonjesinGeneral(zgjedhja,pk);
                        }
                        switch(zgjedhja){
                            case 5:
                                System.out.println("Shkruani Komisionin e ri:");
                                kom = sc.nextDouble();
                                pk.caktoKomisionin(kom);
                                break;
                            case 6:
                                System.out.println("Shkruani Shitjet e reja:");
                                sh = sc.nextInt();
                                pk.caktoShitjet(sh);
                                break;
                        }
                        
                        if(con.modifikoPunonjesKomisioni(pk)){
                            System.out.println("Punetori u modifikua me sukses");
                        }else{
                            System.out.println("Error. Punetori nuk u modifikua me sukses");
                        }
                        break;
                    case 2:
                        PunonjesKomisioniMePageBaze pkpb = con.merrNjePunonjesKomisioniMePageBaze(id);
                        if(pkpb == null){
                            System.out.println("Punonjesi nuk ekziton");
                            continue;
                        }
                        //Pjeset e perbashketa qe mund te modifikohen
                        System.out.println("1.Modifiko Emrin\n2.Modifiko Mbiemrin\n3.Modifiko Pervojen\n4.Modifiko Vitin e Lindjes");
                        System.out.println("5.Modifiko Komisionin\n6.Modifiko Shitjet\n7.Modifiko Pagen Baze");
                        zgjedhja = sc.nextInt();
                        if(zgjedhja < 5){
                            pkpb = modifikoPunonjesinGeneral(zgjedhja,pkpb);
                        }
                        switch(zgjedhja){
                            case 5:
                                System.out.println("Shkruani Komisionin e ri:");
                                kom = sc.nextDouble();
                                pkpb.caktoKomisionin(kom);
                                break;
                            case 6:
                                System.out.println("Shkruani Shitjet e reja:");
                                sh = sc.nextInt();
                                pkpb.caktoShitjet(sh);
                                break;
                            case 7:
                                System.out.println("Shkruani Pagen e re baze:");
                                pagaBaze = sc.nextDouble();
                                pkpb.caktoPageBaze(pagaBaze);
                                break;
                        }
                        
                        
                        if(con.modifikoPunonjesKomisioniMePageBaze(pkpb)){
                            System.out.println("Punetori u modifikua me sukses");
                        }else{
                            System.out.println("Error. Punetori nuk u modifikua me sukses");
                        }
                        break;
                    case 3:
                        PunonjesMeOre po = con.merrNjePunonjesMeOre(id);
                        if(po == null){
                            System.out.println("Punonjesi nuk ekziton");
                            continue;
                        }
                        //Pjeset e perbashketa qe mund te modifikohen
                        System.out.println("1.Modifiko Emrin\n2.Modifiko Mbiemrin\n3.Modifiko Pervojen\n4.Modifiko Vitin e Lindjes");
                        System.out.println("5.Modifiko Komisionin\n6.Modifiko Komisionin\n");
                        zgjedhja = sc.nextInt();
                        if(zgjedhja < 5){
                            po = modifikoPunonjesinGeneral(zgjedhja,po);
                        }
                        switch(zgjedhja){
                            case 5:
                                System.out.println("Shkruani Oret e reja:");
                                oret = sc.nextInt();
                                po.caktoOret(oret);
                                break;
                            case 6:
                                System.out.println("Shkruani Pagen per ore:");
                                pagaPerOre = sc.nextDouble();
                                po.caktoPagaPerOre(pagaPerOre);
                                break;
                            
                        }
                        
                        
                        if(con.modifikoPunonjesMeOre(po)){
                            System.out.println("Punetori u modifikua me sukses");
                        }else{
                            System.out.println("Error. Punetori nuk u modifikua me sukses");
                        }
                        break;
                    case 4:
                        PunonjesMePageBaze pb = con.merrNjePunonjesMePageBaze(id);
                        if(pb == null){
                            System.out.println("Punonjesi nuk ekziton");
                            continue;
                        }
                        //Pjeset e perbashketa qe mund te modifikohen
                        System.out.println("1.Modifiko Emrin\n2.Modifiko Mbiemrin\n3.Modifiko Pervojen\n4.Modifiko Vitin e Lindjes");
                        System.out.println("5.Modifiko Pagen Baze");
                        zgjedhja = sc.nextInt();
                        if(zgjedhja<5){
                            pb = modifikoPunonjesinGeneral(zgjedhja, pb);
                        }else if(zgjedhja == 5){
                            System.out.println("Shkruani Pagen e re baze:");
                            pagaBaze = sc.nextDouble();
                            pb.caktoPageBaze(pagaBaze);
                        }
                        
                        
                        if(con.modifikoPunonjesMePageBaze(pb)){
                            System.out.println("Punetori u modifikua me sukses");
                        }else{
                            System.out.println("Error. Punetori nuk u modifikua me sukses");
                        }
                        break;
                }
        }
    }
    //metode e pergjithshme per modifikimin e te dhenave te perbashketa per te gjithe punonjesit
    public static <T extends Punonjes> T modifikoPunonjesinGeneral(int zgjedhja, T p) {
        String emri, mbiemri;
        int pervoja,vitiLindjes;
        sc.nextLine();
        switch(zgjedhja){
            case 1:
                System.out.println("Shkruani emrin e ri:");
                emri = sc.nextLine();
                p.caktoEmrin(emri);
                break;
            case 2:   
                System.out.println("Shkruani mbiemrin e ri:");
                mbiemri = sc.nextLine();
                p.caktoMbiemrin(mbiemri);
                break;
            case 3:   
                System.out.println("Shkruani pervojen e re:");
                pervoja = sc.nextInt();
                p.caktoPervojen(pervoja);
                break;
            case 4:   
                System.out.println("Shkruani vitin e ri te lindjes:");
                vitiLindjes = sc.nextInt();
                p.caktoVitinELindjes(vitiLindjes);
                break;
        }   
        
        return p;
    }

    public static void fshiPunonjesMenu() {
        int i = -1;
        while(i != 0){
            System.out.println("1.Fshi Punonjes Komisioni\n2.Fshi Punonjes Komisioni me Page Baze\n3.Fshi Punonjes me Ore\n4.Fshi Punonjes me Page Baze\n0.Dil");
            i = sc.nextInt();
            if(i == 0){
                continue;
            }
            sc.nextLine();
            System.out.println("Shkruani ID e punonjesit:");
            String id = sc.nextLine();
            switch(i){
                    case 1:
                        checkDeletion(con.fshi(id, "PunonjesKomisioni", "pk_id"));
                        break;
                    case 2:
                        checkDeletion(con.fshi(id, "PunonjesKomisioniMePageBaze", "pkpb_id"));
                        break;
                    case 3:
                        checkDeletion(con.fshi(id, "PunonjesMeOre", "po_id"));
                        break;
                    case 4:
                        checkDeletion(con.fshi(id, "PunonjesMePageBaze", "pb_id"));
                        break;
                }
        }
    }
    
    public static void checkDeletion(boolean response){
        if(response){
            System.out.println("Perdoruesi u fshi me sukses");
        }else{
            System.out.println("Error. Perdoruesi nuk u fshi me sukses ose nuk ekziston ne databaze.");
        }
    }
    
}


