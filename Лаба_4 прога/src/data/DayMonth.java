package data;

public class DayMonth {
    public static int day = 1, month = 1;

    public static void nextDay(){
        day++; if (day == 31) { month++; day -= 30; }
        System.out.println("Наступает новый день");
    }

    public static void nextMoyth(){
        month++; if (month == 13) { month = 1; }
        System.out.println("Наступает новый месяц");
    }

    public static String getData(){
        return day + " день " + month + " месяца";
    }
}
