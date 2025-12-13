package Lab_day6.LibraryProject.Utilities;

public class Flusher {
    public static void flush() {
        System.out.print("\033[H\033[2J"); // ANSI escape codes (works in most modern terminals)
        System.out.flush();
    }
}
