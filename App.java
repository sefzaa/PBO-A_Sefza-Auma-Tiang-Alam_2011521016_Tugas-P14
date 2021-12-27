import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;


import javax.xml.catalog.Catalog;

import com.mysql.cj.protocol.Resultset;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class App {
    private static final String Y = null;
    static Connection conn;
    public static void main(String[] args) throws Exception {
        Scanner Input = new Scanner (System.in);
        String pilihan;
        boolean lanjut = true ;
       

        String url= "jdbc:mysql://localhost:3306/db_mahasiswa";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(url, "root", "");
            System.out.println("Class Driver Ditemukan");

            while (lanjut){
                System.out.println("\n====================================");
                System.out.println("Data Penerimaan Gaji Pegawai PT ABC");
                System.out.println("====================================");
                System.out.println("1. View   - Melihat Data Pegawai Penerima Gaji PT ABC");
                System.out.println("2. Save   - Menambahkan Data Pegawai Penerima Gaji PT ABC");
                System.out.println("3. Update - Mengubah Data Pegawai Penerima Gaji PT ABC");
                System.out.println("4. Delete - Menghapus Data Pegawai Penerima Gaji PT ABC");
                System.out.println("5. Search - Mencari Data Pegawai Penerima Gaji PT ABC");

                System.out.println("Inputkan Pilihan Anda [1 / 2 / 3 / 4 / 5] :");
                pilihan = Input.next();

                switch (pilihan){
                    case  "1" :
                        Melihat();
                        break;
                    case  "2" :
                        Menyimpan();
                        break;
                    case  "3" :
                        Mengupdate();
                        break;
                    case  "4" :
                        Menghapus();
                        break;
                    case  "5" :
                        Mencari();
                        break;
                    default:
                    System.err.println("Inputan Anda Salah ");
                }
                System.out.println("\n Apakah Anda Ingin Melanjutkan [Y/N]");
                pilihan = Input.next();
                lanjut = pilihan.equalsIgnoreCase("y" );

            }
            System.out.println("Terima Kasih");
        }
        catch (ClassNotFoundException ex){
            System.err.println("Driver Error");
            System.exit(0);

        }
        catch (SQLException e){
            System.err.println("Tidak Berhasil Koneksi");
        }
    }
//========================================================
//========================================================

    public static void Melihat() throws SQLException{
        String text1 = "\n== 1. View - Melihat Data Pegawai Penerima Gaji PT ABC ==";
        System.out.println(text1.toUpperCase());

        String sql = "SELECT * FROM gaji";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()){
            System.out.print("ID Pegawai");
            System.out.print(result.getString("id_pegawai"));
            System.out.print("Nama Pegawai");
            System.out.print(result.getString("nama"));
            System.out.print("Jabatan Pegawai");
            System.out.print(result.getString("jabatan"));        
            System.out.print("Jumlah Hari Masuk");
            System.out.print(result.getInt("hari_masuk"));
            System.out.print("Gaji Pokok Pegawai");
            System.out.print(result.getInt("gaji_pokok"));
            System.out.print("Potongan");
            System.out.print(result.getInt("potongan"));
            System.out.print("Gaji Yang Diterima");
            System.out.print(result.getInt("gaji_diterima")); 
        }        
    }
//========================================================
//========================================================   
    public static void Menyimpan()throws SQLException{
        
        Integer[] listJ={1, 2, 3, 4, 5};
        int hari_masuk;
        int gaji_pokok1;
        int gaji_pokok = 0;
        int potongan;
        int gaji_diterima;
    
        String text2 = "\n== 2. Save - Menambahkan Data Pegawai Penerima Gaji PT ABC ==";
        System.out.println(text2.toUpperCase());

        Scanner Input = new Scanner (System.in);

        try {
            System.out.println("ID Pegawai \t:");
            String id_pegawai = Input.next();
            System.out.println("Nama Pegawai \t:");
            String nama = Input.next();
            System.out.println("Jabatan Pegawai \t:");
            System.out.print("1. (Direktur)  \n" );
            System.out.print("2. (Manajer) \n");
            System.out.print("3. (Karyawan)  \n");
            System.out.print("4. (Cleaning Service - Office Boy)  \n");
            System.out.print("5. (Satpam)  \n");
            System.out.print("Inputkan Jabatan: \n");
            Integer jabatan = Input.nextInt();

            if (jabatan==listJ[0]){
                System.out.print("Jabatan            : Direktur \t");
                jabatan = Integer.parseInt("Direktur");
        
                }
            if (jabatan==listJ[1]){
                System.out.print("Jabatan            : Manajer \t");
                jabatan = Integer.parseInt("Manajer");
        
                }
            if (jabatan==listJ[2]){
                System.out.print("Jabatan            : Karyawan\t ");
                jabatan = Integer.parseInt("Karyawan");
        
                }
            if (jabatan==listJ[3]){
                System.out.print("Jabatan            : Cleaning Service - Office Boy\t ");
                jabatan = Integer.parseInt("Cleaning Service - Office Boy");
        
                }
            if (jabatan==listJ[4]){
                System.out.print("Jabatan            : Satpam \t");
                jabatan = Integer.parseInt("Satpam");
        
                }

            if (jabatan.equals(1)){
                gaji_pokok1=60000000;
                System.out.print("Gaji Pokok         : Rp "+gaji_pokok1+"\t");
                }
            if (jabatan.equals(2)){
                gaji_pokok1=30000000;
                System.out.print("Gaji Pokok         : Rp "+gaji_pokok1+"\t");
                }
            if (jabatan.equals(3)){
                gaji_pokok1=10000000;
                System.out.print("Gaji Pokok         : Rp "+gaji_pokok1+"\t");
                }
            if (jabatan.equals(4)){
                gaji_pokok1=5000000;
                System.out.print("Gaji Pokok         : Rp "+gaji_pokok1+"\t");
                }
            if (jabatan.equals(5)){
                gaji_pokok1=8000000;
                System.out.print("Gaji Pokok         : Rp "+gaji_pokok1+"\t");
                }
            gaji_pokok1 = gaji_pokok;
        
            
            int hari_masuk1 = Input.nextInt();
            ArrayList<Integer> hari = new ArrayList<Integer>();
            for (int i=0; i<30; i++)
            {
                hari.add(i+1);
            }
            System.out.println("Jumlah Hari Masuk\t:");
            hari_masuk = Input.nextInt();
            hari_masuk = hari.get(hari_masuk-1);
            
            
            potongan = (30-hari_masuk)*200000;
            System.out.println("Potongan Gaji      : Rp "+potongan+" \t ");

            
            gaji_diterima = gaji_pokok - potongan;
            System.out.println("Total gaji         : Rp"+gaji_diterima+" \t");  

            String sql = "INSERT INTO gaji (id_pegawai, nama_pegawai, jabatan, hari_masuk, gaji_pokok, potongan, gaji_diterima ) VALUES ('"+id_pegawai+"','"+nama+"','"+jabatan+"','"+hari_masuk+"','"+gaji_pokok+"','"+potongan+"','"+gaji_diterima+"')";

            Statement statement = conn.createStatement();
            statement.execute(sql);
            System.out.println("Data Berhasil Diinputkan");
        }
        catch (SQLException e){
            System.err.println("Terjadi Kesalahan");
        }
        catch (InputMismatchException e){
            System.err.println("Terjadi Kesalahan 2");
        }
    }
//========================================================
//========================================================
    public static void Mengupdate()throws SQLException{
        String text3 = "\n== 3. Update - Mengubah Data Pegawai Penerima Gaji PT ABC";
        System.out.println(text3.toUpperCase());

        Scanner Input = new Scanner (System.in);

        try {
            Melihat();
            System.out.print("Masukkan ID Peagawai yang ingin di ubah");
            String id_pegawai = Input.next();

            String sql = "SELECT * FROM gaji WHERE id_pegawai =" +id_pegawai;

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            if (result.next()){
                
                System.out.println("Jabatan Pegawai ["+result.getString("jabatan")+"]\t");
                String jabatan = Input.nextLine();
                System.out.println("Jumlah Hari Masuk ["+result.getInt("hari_masuk")+"]\t");
                Integer hari_masuk = Input.nextInt();
                System.out.println("Gaji Pokok ["+result.getInt("gaji_pokok")+"]\t");
                Integer gaji_pokok = Input.nextInt();
                System.out.println("Potongan ["+result.getInt("potongan")+"]\t");
                Integer potongan = Input.nextInt();
                System.out.println("Gaji yang Diterima ["+result.getInt("gaji_diterima")+"]\t");
                Integer gaji_diterima = Input.nextInt();

                sql = "UPDATE gaji SET jabatan ='"+jabatan+"', hari_masuk = '"+hari_masuk+"',gaji_pokok ='"+gaji_pokok+"', potongan = '"+potongan+"', gaji_diterima = '"+gaji_diterima+"' WHERE id_pegawai = '"+id_pegawai+"'";

                if (statement.executeUpdate(sql)>0){
                    System.out.println("Berhasil Mengubah Data Pegawai Penerima Gaji PT ABC (id_pegwai "+id_pegawai+")");
                }
            }
            statement.close();
        }
        catch(SQLException e ){
            System.err.println("Terjadi Kesalahan Dalam Mengubah Data");
            System.err.println(e.getMessage());
        }
    }
//========================================================
//========================================================
    public static void Menghapus()throws SQLException{
        String text4 = "\n== 4. Delete - Menghapus Data Pegawai Penerima Gaji PT ABC";
        System.out.println(text4.toUpperCase());

        Scanner Input = new Scanner (System.in);

        try{
            Melihat();
            System.out.println ("Masukkan ID Pegawai Yang Akan Dihapus");
            String id_pegawai = Input.nextLine();

            String sql = "DELETE FROM gaji WHERE id_pegawai =" +id_pegawai;
            Statement statement = conn.createStatement();

            if (statement.executeUpdate(sql)>0){
                System.out.println("Berhasil Menghaspus Data Pegawai Penerima Gaji PT ABC (id_pegawi "+id_pegawai+")");
            }
        }
        catch(SQLException e){
            System.out.println("Terjadi Kesalahan Dalam Menghapus Data");
        }
    }
//========================================================
//========================================================
    public static void Mencari()throws SQLException{
        String text5 = "\n== 5. Search - Mencari Data Pegawai Penerima Gaji PT ABC";
        System.out.println(text5.toUpperCase());

        Scanner Input = new Scanner (System.in);

        System.out.print("Masukkan Nama Pegawai :");

        String keyword = Input.nextLine();
        Statement statement = conn.createStatement();
        String sql = "SELECT * FROM gaji WHERE nama LIKE '%"+keyword+"%'";
        ResultSet result = statement.executeQuery(sql);

        while (result.next()){
            System.out.print("\nID Pegawai \t");
            System.out.print(result.getString("id_pegawai"));
            System.out.print("\nNama Pegawai\t");
            System.out.print(result.getString("nama"));
            

            System.out.print("\nJabatan Pegawai \t");
            System.out.print(result.getString("jabatan"));
            
            System.out.print("\nJumlah Hari Masuk\t");
            System.out.print(result.getInt("hari_masuk"));
            System.out.print("\nGaji Pokok Pegawai\t");
            System.out.print(result.getInt("gaji_pokok"));
            System.out.print("\nPotongan\t");
            System.out.print(result.getInt("potongan"));
            System.out.print("\nGaji Yang Diterima\t");
            System.out.print(result.getInt("gaji_diterima"));
            System.out.print("\n");
        }
    }
}
