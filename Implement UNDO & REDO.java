/*
You are given a text document that is initially empty. You need to complete the following functions:

void append(char x) - Append the character x to the end of the document.
void undo() - Undo the most recent APPEND operation (remove the last appended character).
void redo() - Reapply the most recent undone operation (restore the last character removed by UNDO).
string read() - Return the current content of the document as a string.
There will be a sequence of q queries arr[] on the document. The queries are represented in numeric form:

1 x - Call append(x)
2 - Call undo()
3 - Call redo()
4 - Call read()
The driver code will process the queries, call the corresponding functions, and finally print the outputs of all READ() operations.
You only need to implement the above four functions.
*/
class Solution {
    private StringBuilder readString;
    private StringBuilder redoTracker;
    
    public Solution() {
        readString = new StringBuilder();
        redoTracker = new StringBuilder();
    }
    
    public void append(char x) {
        // append x into document
        readString.append(x);
    }

    public void undo() {
        // undo last change
        char lastChar = readString.charAt(readString.length() - 1);
        readString.deleteCharAt(readString.length() - 1);
        redoTracker.append(lastChar);
    }

    public void redo() {
        // redo changes
        char lastRedoChar = redoTracker.charAt(redoTracker.length() - 1);
        redoTracker.deleteCharAt(redoTracker.length() - 1);
        readString.append(lastRedoChar);
    }

    public String read() {
        // read the document
        return readString.toString();
    }
}
