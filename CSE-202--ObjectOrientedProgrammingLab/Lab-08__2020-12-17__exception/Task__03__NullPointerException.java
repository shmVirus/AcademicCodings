import java.sql.Struct;

public class Task__03__NullPointerException {
        public static void main(String[] args) {
            String nullVariable = null;
            try {
                int stringLength = nullVariable.length();
                System.out.println("String Lenght: " + stringLength);
            }
            catch (NullPointerException exception) {
                System.out.println("Exception Message: " + exception.getMessage());
            }
        }
    }