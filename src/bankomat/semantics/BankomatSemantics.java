package bankomat.semantics;

public class BankomatSemantics {
    private String code;
    public String amount;

    public BankomatSemantics() {
        code = "";
        amount = "";
    }

    public void reset() {
        code = "";
        amount = "";
    }

    public void addCode(String digit) {
        code += digit;
        System.out.println(code);
    }

    public void removeCode() {
        code = code.substring(0, code.length() - 1);
        System.out.println(code);
    }

    public void addAmount(String digit) {
        amount += digit;
        System.out.println(amount);

    }

    public void removeAmount() {
        amount = amount.substring(0, amount.length() - 1);
    }

    public boolean codeIsCorrect() {
        return code.equals("1234");
    }

    public String getAmount() {
        return amount;
    }
}