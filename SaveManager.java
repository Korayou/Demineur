import java.awt.Dimension;
import java.io.*;

/**
 * La classe <code>SaveManager</code> sert à sauvegarder la partie en cours
 *  
 * @version 1.1
 * @author Kayyissa Haïssous
 */
public class SaveManager {

    /**
    * Méthode pour récupérer les infos et les écrires dans le fichier voulu
    * @param grille la grille de jeu
    * @param nomFichier le nom du fichier de sauvegarde
    */
    public void save(Grille grille, String nomFichier) {
        Dimension taille = grille.getDimensionGrille();

        String metaData= (int) taille.getWidth()+"x"+ (int) taille.getHeight()+"x"+ grille.getMines()+"\n";
        try {
            BufferedWriter fichier = new BufferedWriter(new FileWriter(nomFichier));
            Case[] toSave = grille.getPlateau();

            fichier.write(metaData);

            for(Case c : toSave) {
                fichier.write(c.toString());
            }
            
            fichier.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
    * Méthode qui charge les infos de sauvegarde 
    * @param nomFichier le nom du fichier de save
    * @return sauvegarde
    */
    public SaveData load(String nomFichier) {
        String toReturn="";
        String ligne;
        int mines=0;
        Dimension dimension=new Dimension(0,0);
        SaveData toRet=new SaveData(null, null, 0);

        try {
            BufferedReader fichier = new BufferedReader(new FileReader(nomFichier));

            ligne=fichier.readLine();
            String[] infos = ligne.split("x");

            int largeur = Integer.parseInt(infos[0]);
            int hauteur = Integer.parseInt(infos[1]);
            mines = Integer.parseInt(infos[2]);

            dimension = new Dimension(largeur, hauteur);

            while((ligne = fichier.readLine()) != null) {
                toReturn += ligne;
            }

            fichier.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        toRet.cases=toReturn;
        toRet.taille=dimension;
        toRet.mines=mines;

        File save = new File(nomFichier);
        save.delete();

        return toRet;
    }

    /**
    * La classe <code>SaveDate</code> correspond aux données de sauvegarde d'une partie
    */
    public class SaveData{
        public Dimension taille;
        public String cases;
        public int mines;

        public SaveData(Dimension taille, String cases, int mines) {
            this.taille = taille;
            this.cases = cases;
        }

        public String toString() {
            return (int) taille.getWidth()+"x"+(int) taille.getHeight()+"x"+mines+"\n"+cases;
        }
    }
}