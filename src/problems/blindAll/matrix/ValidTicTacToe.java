package problems.blindAll.matrix;

public class ValidTicTacToe {
    public static boolean validTicTacToe(String[] board) {
        int countXO = 0;
        int n = board.length;

        // Check for 3 points in all rows
        int[] rows = new int[n];

        // Check for 3 points in all cols
        int[] cols = new int[n];

        boolean xwin = false;
        boolean owin = false;

        // Both sided diagonals.
        int dia = 0;
        int antiDia = 0;

        for (int i = 0; i < n; i++) {
            String currString = board[i];
            for (int j = 0; j < n; j++) {
                int currentVal = 0;
                if (currString.charAt(j) == 'X') {
                    currentVal = 1;
                } else if (currString.charAt(j) == 'O') {
                    currentVal = -1;
                }
                rows[i] = rows[i] + currentVal;
                cols[j] = cols[j] + currentVal;

                if (i == j) {
                    dia = dia + currentVal;
                }

                if (n - i - 1 == j) {
                    antiDia = antiDia + currentVal;
                }

                countXO = countXO + currentVal;
            }
        }

        xwin = rows[0] == 3 || rows[1] == 3 || rows[2] == 3 ||
                cols[0] == 3 || cols[1] == 3 || cols[2] == 3 ||
                dia == 3 || antiDia == 3;

        owin = rows[0] == -3 || rows[1] == -3 || rows[2] == -3 ||
                cols[0] == -3 || cols[1] == -3 || cols[2] == -3 ||
                dia == -3 || antiDia == -3;

        // since X starts first, if X wins, XO count is 1 and if O wins, XO count is 0.
        if (xwin && countXO == 0 || owin && countXO == 1) {
            return false;
        }
        // Either one of them, X or O wins
        return (countXO == 0 || countXO == 1) && (!xwin || !owin);
    }

    public static void main(String[] args) {
        validTicTacToe(new String[]{"O  ", "   ", "   "});
    }
}
