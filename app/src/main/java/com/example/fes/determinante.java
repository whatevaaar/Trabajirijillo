package com.example.fes;

public class determinante {

    public int calcula_determinante(int A1, int B1, int C1, int A2, int B2, int C2,int A3, int B3, int C3){
        int resultado;
        resultado=(A1*B2*C3+B1*C2*A3+A2*B3*C1)-(C1*B2*A3 + B1*A2*C3 + C2*B3*A1);
        return resultado;
    }
}
