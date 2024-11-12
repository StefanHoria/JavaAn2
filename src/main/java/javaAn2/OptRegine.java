package javaAn2;

public class OptRegine {
    final int N = 8;

    public boolean rezolvaProblema() {
        int [][] tabla = new int [N][N];

        if(!plaseazaRegine(tabla,0)) {
            System.out.println("Nu exista solutii !");
            return false;
        }

        afiseazaTabla(tabla);
        return true;
    }

    private boolean esteSigur(int[][] tabla, int linie, int coloana) {
        for(int i = 0; i < coloana; i++ ) {
            if (tabla[linie][i] == 1)
                return false;
        }

        for(int i = linie,j = coloana; i >= 0 && j>=0; i--,j--) {
            if(tabla[i][j] == 1)
                return false;
        }

        for(int i = linie, j = coloana; j >= 0 && i < N; i++, j--) {
            if(tabla[i][j] == 1)
                return false;
        }

        return true;
    }

    private boolean plaseazaRegine(int [][] tabla, int coloana) {
        if(coloana >= N)
            return true;

        for(int i = 0; i < N; i++) {
            if(esteSigur(tabla, i, coloana)) {
                tabla[i][coloana] = 1;

                if(plaseazaRegine(tabla, coloana +1))
                    return true;
                tabla[i][coloana] = 0;
            }
        }
        return false;
    }

    private void afiseazaTabla(int [][] tabla) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print((tabla[i][j] == 1 ? "R" : ". "));
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        OptRegine regine = new OptRegine();
        regine.rezolvaProblema();
    }
}


