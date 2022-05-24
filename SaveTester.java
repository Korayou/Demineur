public class SaveTester {
    public static void main(String[] args) {
        Grille grille = new Grille(10,10,10, null, null);
        SaveManager saveManager = new SaveManager();

        saveManager.save(grille, "test_sauvegarde.txt");
        SaveManager.SaveData donnees = saveManager.load("test_sauvegarde.txt");
    }
}