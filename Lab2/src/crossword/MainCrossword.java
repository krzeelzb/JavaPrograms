package crossword;

public class MainCrossword {
    public static void main(String[] argv){
        CwDB check= new CwDB("/home/ela/Pulpit/cwdb.txt");
        check.createDB("/home/ela/Pulpit/cwdb.txt");
        check.get("Agata");
        check.getSize();
        check.add("Ela","studentka");
        check.saveDB("/home/ela/Pulpit/cwdb1.txt");
        check.remove("Ela");
        check.saveDB("/home/ela/Pulpit/cwdb1.txt");

        InteliCwDb checkInteli= new InteliCwDb(("/home/ela/Pulpit/cwdb.txt"));
        checkInteli.createDB("/home/ela/Pulpit/cwdb.txt");



        checkInteli.getRandom("Matematyka");
        checkInteli.findAll("Matematyka");
        checkInteli.getRandom(7);
        checkInteli.add("Ela","Studentka");
        checkInteli.saveDB("/home/ela/Pulpit/cwdb1.txt");


    }
}
