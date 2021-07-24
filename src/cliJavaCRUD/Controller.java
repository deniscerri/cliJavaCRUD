package cliJavaCRUD;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Controller{
     Connection conn = DatabaseConnection.getConnection();
    //CREATE READ UPDATE Punonjes Komisioni-------------------------------------
    public boolean krijoPunonjesKomisioni(PunonjesKomisioni p){
        String query = "INSERT INTO punonjesKomisioni(pk_emri,pk_mbiemri,pk_vitiLindjes,pk_pervoja,pk_shitjet,pk_komisioni)"
                       + "VALUES('"+p.merrEmrin()
                       +"','"+p.merrMbiemrin()+"',"+p.merrVitinELindjes()+","+p.merrPervojen()
                       +","+p.merrShitjet()+","+p.merrKomisionin()+")";
        return executeInput(query);
    }
    
    public PunonjesKomisioni merrNjePunonjesKomisioni(int id){
        String query = "SELECT * FROM punonjesKomisioni WHERE pk_id="+id;
        PunonjesKomisioni p = null;
        try{
            ResultSet res = executeQuery(query);
            
            while(res.next()){
                p = new PunonjesKomisioni(res.getString("pk_id"), res.getString("pk_emri")
                , res.getString("pk_mbiemri"), res.getInt("pk_vitiLindjes")
                , res.getInt("pk_pervoja"), res.getDouble("pk_shitjet"), res.getDouble("pk_komisioni"));
            }
        }catch(SQLException e){
        }
        
        
        return p;
    }
    
    public List<PunonjesKomisioni> merrPunonjesKomisioni(){
        String query = "SELECT * FROM punonjesKomisioni";
        List<PunonjesKomisioni> punonjesit = new ArrayList<>();
        try{
            ResultSet res = executeQuery(query);
            while(res.next()){
                PunonjesKomisioni p = new PunonjesKomisioni(res.getString("pk_id"), res.getString("pk_emri")
                , res.getString("pk_mbiemri"), res.getInt("pk_vitiLindjes")
                , res.getInt("pk_pervoja"), res.getDouble("pk_shitjet"), res.getDouble("pk_komisioni"));
                punonjesit.add(p);
            }
            
        }catch(SQLException e){
            return null;
        }
        
        return punonjesit;
    }
    
    public boolean modifikoPunonjesKomisioni(PunonjesKomisioni p){
        String query = "UPDATE punonjesKomisioni SET pk_emri='"+p.merrEmrin()+"',"
                        +"pk_mbiemri='"+p.merrMbiemrin()+"',"
                        +"pk_vitiLindjes="+p.merrVitinELindjes()+","
                        +"pk_pervoja="+p.merrPervojen()+","
                        +"pk_shitjet="+p.merrShitjet()+","
                        +"pk_komisioni="+p.merrKomisionin()+" WHERE pk_id="+p.merrId();
        return executeInput(query);
    }
    
    //CREATE READ UPDATE Punonjes Komisioni Me Page Baze------------------------
    public boolean krijoPunonjesKomisioniMePageBaze(PunonjesKomisioniMePageBaze p){
        String query = "INSERT INTO punonjesKomisioniMePageBaze(pkpb_emri,pkpb_mbiemri,pkpb_vitiLindjes,pkpb_pervoja,pkpb_shitjet,pkpb_komisioni,pkpb_pagaBaze)"
                       + "VALUES('"+p.merrEmrin()
                       +"','"+p.merrMbiemrin()+"',"+p.merrVitinELindjes()+","+p.merrPervojen()
                       +","+p.merrShitjet()+","+p.merrKomisionin()+","+p.merrPageBaze()+")";
        
        return executeInput(query);
    }
    
    public PunonjesKomisioniMePageBaze merrNjePunonjesKomisioniMePageBaze(int id){
        String query = "SELECT * FROM punonjesKomisioniMePageBaze WHERE pkpb_id="+id;
        PunonjesKomisioniMePageBaze p = null;
        try{
            ResultSet res = executeQuery(query);
            while(res.next()){
                p = new PunonjesKomisioniMePageBaze(res.getString("pkpb_id"), res.getString("pkpb_emri")
                , res.getString("pkpb_mbiemri"), res.getInt("pkpb_vitiLindjes")
                , res.getInt("pkpb_pervoja"), res.getDouble("pkpb_shitjet"), res.getDouble("pkpb_komisioni")
                , res.getDouble("pkpb_pagaBaze"));
            }
            
        }catch(SQLException e){
            return null;
        }
        
        return p;
    }
    
    public List<PunonjesKomisioniMePageBaze> merrPunonjesKomisioniMePageBaze(){
        String query = "SELECT * FROM punonjesKomisioniMePageBaze";
        List<PunonjesKomisioniMePageBaze> punonjesit = new ArrayList<>();
        try{
            ResultSet res = executeQuery(query);
            while(res.next()){
                PunonjesKomisioniMePageBaze p = new PunonjesKomisioniMePageBaze(res.getString("pkpb_id"), res.getString("pkpb_emri")
                , res.getString("pkpb_mbiemri"), res.getInt("pkpb_vitiLindjes")
                , res.getInt("pkpb_pervoja"), res.getDouble("pkpb_shitjet"), res.getDouble("pkpb_komisioni")
                , res.getDouble("pkpb_pagaBaze"));
                punonjesit.add(p);
            }
            
        }catch(SQLException e){
            return null;
        }
        
        return punonjesit;
    }
    
    public boolean modifikoPunonjesKomisioniMePageBaze(PunonjesKomisioniMePageBaze p){
        String query = "UPDATE punonjesKomisioniMePageBaze SET pkpb_emri='"+p.merrEmrin()+"',"
                        +"pkpb_mbiemri='"+p.merrMbiemrin()+"',"
                        +"pkpb_vitiLindjes="+p.merrVitinELindjes()+","
                        +"pkpb_pervoja="+p.merrPervojen()+","
                        +"pkpb_shitjet="+p.merrShitjet()+","
                        +"pkpb_komisioni="+p.merrKomisionin()+","
                        +"pkpb_pagaBaze="+p.merrPageBaze()+" WHERE pkpb_id="+p.merrId();
        return executeInput(query);
    }
    
    //CREATE READ UPDATE Punonjes Me Ore----------------------------------------
    public boolean krijoPunonjesMeOre(PunonjesMeOre p){
        String query = "INSERT INTO punonjesMeOre(po_emri,po_mbiemri,po_vitiLindjes,po_pervoja,po_pagaPerOre,po_oret)"
                       + "VALUES('"+p.merrEmrin()
                       +"','"+p.merrMbiemrin()+"',"+p.merrVitinELindjes()+","+p.merrPervojen()
                       +","+p.merrPagePerOre()+","+p.merrOret()+")";
        return executeInput(query);
    }
    
    public PunonjesMeOre merrNjePunonjesMeOre(int id){
        String query = "SELECT * FROM punonjesMeOre WHERE po_id="+id;
        PunonjesMeOre p = null;
        try{
            ResultSet res = executeQuery(query);
            while(res.next()){
                p = new PunonjesMeOre(res.getString("po_id"), res.getString("po_emri")
                , res.getString("po_mbiemri"), res.getInt("po_vitiLindjes")
                , res.getInt("po_pervoja"), res.getDouble("po_pagaPerOre"), res.getInt("po_oret"));
            }
            
        }catch(SQLException e){
            return null;
        }
        
        return p;
    }
    
    public List<PunonjesMeOre> merrPunonjesMeOre(){
        String query = "SELECT * FROM punonjesMeOre";
        List<PunonjesMeOre> punonjesit = new ArrayList<>();
        try{
            ResultSet res = executeQuery(query);
            while(res.next()){
                PunonjesMeOre p = new PunonjesMeOre(res.getString("po_id"), res.getString("po_emri")
                , res.getString("po_mbiemri"), res.getInt("po_vitiLindjes")
                , res.getInt("po_pervoja"), res.getDouble("po_pagaPerOre"), res.getInt("po_oret"));
                punonjesit.add(p);
            }
            
        }catch(SQLException e){
            return null;
        }
        
        return punonjesit;
    }
    
    public boolean modifikoPunonjesMeOre(PunonjesMeOre p){
        String query = "UPDATE punonjesMeOre SET po_emri='"+p.merrEmrin()+"',"
                        +"po_mbiemri='"+p.merrMbiemrin()+"',"
                        +"po_vitiLindjes="+p.merrVitinELindjes()+","
                        +"po_pervoja="+p.merrPervojen()+","
                        +"po_pagaPerOre="+p.merrPagePerOre()+","
                        +"po_oret="+p.merrPagePerOre()+" WHERE po_id="+p.merrId();
        return executeInput(query);                 
    }
    
    //CREATE READ UPDATE Punonjes Me Page Baze----------------------------------
    public boolean krijoPunonjesMePageBaze(PunonjesMePageBaze p){
        String query = "INSERT INTO punonjesMePageBaze(pb_emri,pb_mbiemri,pb_vitiLindjes,pb_pervoja,pb_pagaBaze)"
                       + "VALUES('"+p.merrEmrin()
                       +"','"+p.merrMbiemrin()+"',"+p.merrVitinELindjes()+","+p.merrPervojen()
                       +","+p.merrPageBaze() + ")";
        return executeInput(query);
    }
    
     public PunonjesMePageBaze merrNjePunonjesMePageBaze(int id){
        String query = "SELECT * FROM punonjesMePageBaze WHERE pb_id="+id;
        PunonjesMePageBaze p = null;
        try{
            ResultSet res = executeQuery(query);
            while(res.next()){
                p = new PunonjesMePageBaze(res.getString("pb_id"), res.getString("pb_emri")
                , res.getString("pb_mbiemri"), res.getInt("pb_vitiLindjes")
                , res.getInt("pb_pervoja"),res.getInt("pb_pagaBaze"));
                
            }
            
        }catch(SQLException e){
            return null;
        }
        
        return p;
    }
    
    public List<PunonjesMePageBaze> merrPunonjesMePageBaze(){
        String query = "SELECT * FROM punonjesMePageBaze";
        List<PunonjesMePageBaze> punonjesit = new ArrayList<>();
        try{
            ResultSet res = executeQuery(query);
            while(res.next()){
                PunonjesMePageBaze p = new PunonjesMePageBaze(res.getString("pb_id"), res.getString("pb_emri")
                , res.getString("pb_mbiemri"), res.getInt("pb_vitiLindjes")
                , res.getInt("pb_pervoja"),res.getInt("pb_pagaBaze"));
                punonjesit.add(p);
            }
            
        }catch(SQLException e){
            return null;
        }
        
        return punonjesit;
    }
    
    public boolean modifikoPunonjesMePageBaze(PunonjesMePageBaze p){
        String query = "UPDATE punonjesMePageBaze SET po_emri='"+p.merrEmrin()+"',"
                        +"po_mbiemri='"+p.merrMbiemrin()+"',"
                        +"po_vitiLindjes="+p.merrVitinELindjes()+","
                        +"po_pervoja="+p.merrPervojen()+","
                        +"po_pagaBaze="+p.merrPageBaze()+"WHERE po_id="+p.merrId();
        ResultSet res =  executeQuery(query);               
        return checkResult(res);                             
    }
   
    
    //FSHIRJA
    public boolean fshi(String id, String tabela, String llojiID){
        String query = "DELETE FROM "+tabela+" WHERE "+llojiID+"="+id;
        return executeInput(query);
    }
    
    
    //Ekzekutimi i kerkeses
    public ResultSet executeQuery(String query){
        Statement st;
        try{
            st = conn.createStatement();
            ResultSet res = st.executeQuery(query);
            return res;
        }catch(SQLException e){
            return null;
        }
    }
    //Ekzekutim input pa marre dicka nga databaza
    public boolean executeInput(String query) {
        int i = 0;
        try{
            PreparedStatement pst = conn.prepareStatement(query);
            i = pst.executeUpdate();
        }catch(SQLException e){
        }
        return (i>0);
    }
    
    public boolean checkResult(ResultSet res){
        try{
            while(res.next()){
                return true;
            }
        }catch(SQLException e){
            return false;
        }
        return false;
    }

}

