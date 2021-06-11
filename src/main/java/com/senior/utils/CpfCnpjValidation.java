package com.senior.utils;

public class CpfCnpjValidation {

    private static final int[] valuesPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] valuesCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    public static boolean isValid(String cpfCnpj) {
        return (isValidCPF(cpfCnpj) || isValidCNPJ(cpfCnpj));
    }

    private static int calculateDigit(String str, int[] values) {
        int sum = 0;
        for (int indice=str.length()-1, digit; indice >= 0; indice-- ) {
            digit = Integer.parseInt(str.substring(indice,indice+1));
            sum += digit*values[values.length-str.length()+indice];
        }
        sum = 11 - sum % 11;
        return sum > 9 ? 0 : sum;
    }

    private static String padLeft(String text, char character) {
        return String.format("%11s", text).replace(' ', character);
    }

    private static boolean isValidCPF(String cpf) {
        cpf = cpf.trim().replace(".", "").replace("-", "");
        if ((cpf==null) || (cpf.length()!=11)) return false;

        for (int j = 0; j < 10; j++)
            if (padLeft(Integer.toString(j), Character.forDigit(j, 10)).equals(cpf))
                return false;

        Integer digit1 = calculateDigit(cpf.substring(0,9), valuesPF);
        Integer digit2 = calculateDigit(cpf.substring(0,9) + digit1, valuesPF);

        return cpf.equals(cpf.substring(0,9) + digit1.toString() + digit2.toString());
    }

    private static boolean isValidCNPJ(String cnpj) {
        cnpj = cnpj.trim().replace(".", "").replace("-", "");
        if ((cnpj==null)||(cnpj.length()!=14)) return false;

        Integer digit1 = calculateDigit(cnpj.substring(0,12), valuesCNPJ);
        Integer digit2 = calculateDigit(cnpj.substring(0,12) + digit1, valuesCNPJ);

        return cnpj.equals(cnpj.substring(0,12) + digit1.toString() + digit2.toString());
    }
}
