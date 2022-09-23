import java.util.HashMap;
import java.util.HashSet;

class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        HashSet<String> globalSet = new HashSet<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (!Character.toString(board[r][c]).equals(".")) {
                    if (!globalSet
                            .contains("g" + r/3 + c/3 + board[r][c])
                            && !globalSet.contains("r" + r + board[r][c])
                            && !globalSet.contains("c" + c + board[r][c])) {
                        
                                globalSet.add("g" + r/3 + c/3 + board[r][c]);
                                globalSet.add("r" + r + board[r][c]);
                                globalSet.add("c" + c + board[r][c]);
                    } else {
                        return false;
                    }
                } 
            }
        }
        return true;

    }

    public static void main(String[] args) {
        ValidSudoku vs = new ValidSudoku();
        char[][] board = new char[][] {
            { '5','3','.','.','7','.','.','.','.' },
            { '6','.','3','1','9','5','.','.','.' },
            { '.','9','8','.','.','.','.','6','.' },
            { '8','.','.','.','6','.','.','.','3' },
            { '4','.','.','8','.','3','.','.','1' },
            { '7','.','.','.','2','.','.','.','6' },
            { '.','6','.','.','.','.','2','8','.' },
            { '.','.','.','4','1','9','.','.','5' },
            { '.','.','.','.','8','.','.','7','9' }
        };
        System.out.println(vs.isValidSudoku(board));
    }
}
