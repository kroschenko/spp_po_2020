import java.util.Vector;

class Page{
    private Vector<Word> mPage;

    public Page(){
        mPage = new Vector<>();
    }

    public void addWord(Word word){
        mPage.add(word);
    }

    public String toString(){
        String str = new String();
        for (Word word : mPage) {
            str += word.getWord();
            if(!word.getWord().equals("\n")){
                str += " ";
            }
        }
        return str;
    }
}