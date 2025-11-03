public enum DifficultyLevel {
    EASY("Easy",10),
    MEDIUM("Medium",5),
    HARD("Hard",3);
    private final  String names;
    private final int chances;

     DifficultyLevel(String names, int chances)
    {
        this.names = names;
        this.chances = chances;
    }

    public int getChances() {
        return chances;
    }
    public String getNames() {
        return names;
    }

    public static DifficultyLevel choice(int choice)
   {
       switch(choice)
       {
           case 1:
               return EASY;
           case 2:
               return MEDIUM;
           case 3:
               return HARD;
           default:
               return null;
       }
   }

}
