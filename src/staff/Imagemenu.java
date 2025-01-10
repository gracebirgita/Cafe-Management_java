/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staff;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;



//public class Imagemenu {
//    private Image image;
//    
//    public Imagemenu(String resource) {
//        try {
//            // Membaca gambar dari path
//            this.image = ImageIO.read(new File(resource));
//        } catch (IOException e) {
//            System.err.println("Gambar tidak ada di path " + resource);
//        }
//    }
//    
//    public Image getImage(){
//        return this.image;
//    }
//    
//    public void setImage(String resource){
//         try {
//            this.image = ImageIO.read(new File(resource));
//        } catch (IOException e) {
//            System.err.println("Gambar tidak ada di path " + resource);
//            e.printStackTrace();
//        }
//        
//    }
//    
//}

//public class Imagemenu {
//    private Image image;
//
//    public Imagemenu(String resource) {
//       try {
//        // Membaca gambar dari path
//        this.image = ImageIO.read(new File(resource));
//        if (this.image == null) {
//            System.err.println("Gambar gagal dimuat dari path: " + resource);
//        }
//    } catch (IOException e) {
//        System.err.println("Gambar tidak ada di path " + resource);
//        e.printStackTrace();
//    }
//    }
//
//    public Image getImage() {
//        return this.image;
//    }
//
//    public void setImage(String resource) {
//        try {
//            this.image = ImageIO.read(new File(resource));
//        } catch (IOException e) {
//            System.err.println("Gambar tidak ada di path " + resource);
//            e.printStackTrace();
//        }
//    }
//}

class Imagemenu {
    private ImageIcon imageIcon;

    public Imagemenu(String imagePath) {
        this.imageIcon = new ImageIcon(imagePath);
    }

    public Image getImage() {
        return imageIcon.getImage();
    }
}