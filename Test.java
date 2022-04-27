public class Test {
    public static void main(String[] args) {
        Grille grille=new Grille(10,15,15);
        new FrameJeu(grille.getGrille(), 15);
    }  
}
