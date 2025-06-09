import java.util.Scanner;

public class mainMla {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        try {
            String citation = CitationGenerator.generateMlaCitation(input);
            System.out.println(citation);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
