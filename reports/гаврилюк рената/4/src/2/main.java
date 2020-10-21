class Laba4{
    public static void main(String[] args) {
        //task 2
        Page page = new Page();
        page.addWord(new Word("1"));
        page.addWord(new Word("2"));
        page.addWord(new Word("3"));
        page.addWord(new Word("4"));
        page.addWord(new Word("\n"));
        page.addWord(new Word("5"));
        page.addWord(new Word("6"));
        page.addWord(new Word("7"));
        page.addWord(new Word("8"));
        System.out.println(page.toString());
    }
}