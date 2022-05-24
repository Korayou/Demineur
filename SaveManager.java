import java.awt.Dimension;
import java.io.*;

public class SaveManager {
    
    public void save(Grille grille, String nomFichier) {
        Dimension taille = grille.getDimensionGrille();

        String metaData= (int) taille.getWidth()+"x"+ (int) taille.getHeight()+"\n";
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

    public SaveData load(String nomFichier) {
        String toReturn="";
        String ligne;
        Dimension dimension=new Dimension(0,0);
        SaveData toRet=new SaveData(null, null);

        try {
            BufferedReader fichier = new BufferedReader(new FileReader(nomFichier));

            ligne=fichier.readLine();
            String[] taille = ligne.split("x");

            int largeur = Integer.parseInt(taille[0]);
            int hauteur = Integer.parseInt(taille[1]);

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
        return toRet;
    }

    public class SaveData{
        public Dimension taille;
        public String cases;

        public SaveData(Dimension taille, String cases) {
            this.taille = taille;
            this.cases = cases;
        }

        public String toString() {
            return (int) taille.getWidth()+"x"+(int) taille.getHeight()+"\n"+cases;
        }
    }
}