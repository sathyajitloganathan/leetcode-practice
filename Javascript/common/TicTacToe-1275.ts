function tictactoe(moves: number[][]): string {
    const boardSize: number = 3;
    const playingBoard: string[][] = Array.from(Array(boardSize)).map(() =>
        Array.from(Array(boardSize)).map(() => "")
    );

    const isGameComplete = (board: string[][]): string => {
        const progressPairs = Array.from(Array(boardSize * 2 + 2)).map(() => [
            0, 0,
        ]);

        for (let row = 0; row < board.length; row++) {
            for (let col = 0; col < board.length; col++) {
                const playerIndex =
                    board[row][col] == "X"
                        ? 0
                        : board[row][col] == "O"
                        ? 1
                        : null;
                if (playerIndex != null) {
                    progressPairs[row][playerIndex] =
                        progressPairs[row][playerIndex] + 1;
                    progressPairs[boardSize + col][playerIndex] =
                        progressPairs[boardSize + col][playerIndex] + 1;

                    if (row == col) {
                        progressPairs[boardSize*2][playerIndex] =
                            progressPairs[boardSize*2][playerIndex] + 1;
                    } 
                    if (row == board.length - col - 1) {
                        progressPairs[boardSize*2 + 1][playerIndex] =
                            progressPairs[boardSize*2 + 1][playerIndex] + 1;
                    }
                }
            }
        }

        let winner: string = "Pending";
        progressPairs.every((pair) => {
            if (pair[0] >= boardSize) {
                winner = "A";
                return false;
            } else if (pair[1] >= boardSize) {
                winner = "B";
                return false;
            }
            return true;
        });
        return moves.length == 9 && winner == "Pending" ? "Draw" : winner;
    };

    moves.forEach((move, index) => {
        const isX = index % 2 == 0;
        playingBoard[move[0]][move[1]] = isX ? "X" : "O";
    });
    
    return isGameComplete(playingBoard);
}

tictactoe([[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]);