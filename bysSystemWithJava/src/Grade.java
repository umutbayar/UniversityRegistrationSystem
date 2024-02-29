import java.text.DecimalFormat;

/**
 * The Grade class represents a student's grade with information such as the percentage out of 100,
 * the corresponding Gano, and the letter grade. It provides methods to convert between these
 * representations and perform validations on the input grades.
 *
 * @author mehmet_sina
 * @version 1.0
 * @since 2023-12-10
 */
public class Grade {

    private double outOfHundred;
    private double gano;
    private String letterGrade;

    /**
     * Default constructor for Grade.
     * Creates an instance with default values.
     */
    public Grade() {
        // Default constructor
    }

    /**
     * Constructor for Grade with specified percentage out of 100, Gano, and letter grade.
     *
     * @param outOfHundred The percentage out of 100.
     * @param gano         The Gano equivalent of the grade.
     * @param letterGrade  The letter grade.
     */
    public Grade(double outOfHundred, double gano, String letterGrade) {
        this.outOfHundred = outOfHundred;
        this.gano = gano;
        this.letterGrade = letterGrade;
    }

    /**
     * Retrieves the percentage out of 100.
     *
     * @return The percentage out of 100.
     */
    public double getOutOfHundred() {
        return outOfHundred;
    }

    /**
     * Sets the percentage out of 100.
     *
     * @param outOfHundred The new percentage out of 100 to set.
     */
    public void setOutOfHundred(double outOfHundred) {
        this.outOfHundred = outOfHundred;
    }

    /**
     * Retrieves the Gano equivalent of the grade.
     *
     * @return The Gano equivalent.
     */
    public double getGano() {
        return gano;
    }

    /**
     * Sets the Gano equivalent of the grade.
     *
     * @param gano The new Gano equivalent to set.
     */
    public void setGano(double gano) {
        this.gano = gano;
    }

    /**
     * Retrieves the letter grade.
     *
     * @return The letter grade.
     */
    public String getLetterGrade() {
        return letterGrade;
    }

    /**
     * Sets the letter grade.
     *
     * @param letterGrade The new letter grade to set.
     */
    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }

    /**
     * Converts the percentage out of 100 to Gano and returns the numeric Gano value.
     *
     * @param hundredNot The percentage out of 100.
     * @return The numeric Gano value.
     * @throws IllegalArgumentException If the grade is not between 0 and 100.
     */
    public double convertHundredToGano(double hundredNot) {
        if (hundredNot < 0 || hundredNot > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100");
        }
        double result = hundredNot / 25;

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formattedResult = decimalFormat.format(result);

        formattedResult = formattedResult.replace(",", "."); // Virgülü nokta ile değiştir
        double numericValue = Double.parseDouble(formattedResult);

        this.gano = Double.parseDouble(formattedResult);
        return numericValue;
    }

    /**
     * Converts the percentage out of 100 to the corresponding letter grade.
     *
     * @param hundred The percentage out of 100.
     * @throws IllegalArgumentException If the grade is not between 0 and 100.
     */
    public void convertHundredToLetterGrade(double hundred) {
        if (hundred < 0 || hundred > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100");
        }
        hundred = convertHundredToGano(hundred);
        String letterGrade;
        if (4.00 >= hundred && hundred > 3.50) {
            letterGrade = "AA";
        } else if (3.50 >= hundred && hundred > 3.00) {
            letterGrade = "BA";
        } else if (3.00 >= hundred && hundred > 2.50) {
            letterGrade = "BB";
        } else if (2.50 >= hundred && hundred > 2.00) {
            letterGrade = "CB";
        } else if (2.00 >= hundred && hundred > 1.50) {
            letterGrade = "CC";
        } else if (1.50 >= hundred && hundred > 1.00) {
            letterGrade = "DC";
        } else if (1.00 >= hundred && hundred > 0.50) {
            letterGrade = "DD";
        } else if (0.50 >= hundred && hundred > 0.00) {
            letterGrade = "FD";
        } else {
            letterGrade = "FF";
        }
        this.letterGrade = letterGrade;
    }
}
