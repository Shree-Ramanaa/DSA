class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> wordsOnBoard = new ArrayList<String>();
        Trie root = new Trie();

        for(String word: words){
                Trie cur = root;

                for(char i : word.toCharArray()){
                    if(cur.node[i - 'a'] == null){
                        cur.node[i - 'a'] = new Trie();
                    }
                    cur = cur.node[i - 'a'];
                }
                cur.word = word;
                cur.isWord = true;
        }

        searchWords(wordsOnBoard, board, root);
        return wordsOnBoard;
    }
    
    private void searchWords(List<String> wordsOnBoard, char[][] board, Trie root){
                for(int row = 0; row < board.length; row++){
                        for(int col = 0; col < board[0].length; col++){
                            checkWord(wordsOnBoard, board, row, col, root);
                        }
                }
    }
    private void checkWord(List<String> wordsOnBoard, char[][] board, int row, int col, Trie root){
        if(root == null)return;

        if(root.isWord == true){
            wordsOnBoard.add(root.word);
            root.isWord = false;
        }

        if(row < 0 || col < 0 || row == board.length || col == board[0].length)return;
        if(board[row][col] == '1')return;

        
        char letter = board[row][col]; 
        board[row][col] = '1';

        checkWord(wordsOnBoard, board, row + 1, col, root.node[letter - 'a']);
        checkWord(wordsOnBoard, board, row - 1, col, root.node[letter - 'a']);
        checkWord(wordsOnBoard, board, row, col + 1, root.node[letter - 'a']);
        checkWord(wordsOnBoard, board, row, col - 1, root.node[letter - 'a']);

        board[row][col] =  letter;             
    }

    private class Trie{
        boolean isWord;
        String word;
        Trie parent;
        Trie[] node = new Trie[26];
    }
}
