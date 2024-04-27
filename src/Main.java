import java.io.*;

public class Main {
    public static void main(String[] args) {
        String dirpath= "Folder"+ File.separator+"SubFolder";
        File dir=new File(dirpath);
        if(!dir.exists()){
            dir.mkdirs();
        }
        File f=new File(dirpath+File.separator+"MyFile.txt");
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(f.getAbsolutePath());
        System.out.println(f.canRead());
        System.out.println(f.getName());
        System.out.println(f.getParent());
        System.out.println(f.getPath());
        System.out.println(dir.isDirectory());
        try {
            System.out.println(f.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileWriter fw=new FileWriter(f);
            fw.write("Filewriter Object writing to file");
            fw.flush();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileReader fr=new FileReader(f);
            int i;
            System.out.println("Reading from File reader");
            while((i=fr.read())!=-1){
                System.out.print((char)i);
            }
            fr.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileOutputStream fos=new FileOutputStream(f,true);
            String str="\n FileOutput Stream writing";
            fos.write(str.getBytes());
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            FileInputStream fis=new FileInputStream(f);
            int i;
            System.out.println("\nReading from file input stream");
            while((i=fis.read())!=-1){
                System.out.print((char)i);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}