public class MyStringBuilder1 {
    
    private StringBuilder stringBuilder;

    public MyStringBuilder1(String s) {
        stringBuilder = new StringBuilder(s);
    }

   /**
    * This function appends a MyStringBuilder1 to the current MyStringBuilder1 and then returns 'this'
    * @param s new MyStringBuilder1
    * @return MyStringBuilder1 with appended 's'
    */
    public MyStringBuilder1 append(MyStringBuilder1 s) {
        stringBuilder.append(s);
        return this;
    }

    // append int
    public MyStringBuilder1 append(int i) {
        stringBuilder.append(i);
        return this;
    }

    /**
     * this function returns the character at index i
     * @param i the index
     * @return the character at index i
     */
    public char charAt(int i) {
        return stringBuilder.charAt(i);
    }

    /**
     * this function returns MyStringBuilder1 with its contents in lowercase
     * @return MyStringBuilder1 with its contents in lowercase
     */
    public MyStringBuilder1 toLowerCase() {
        return new MyStringBuilder1(stringBuilder.toString().toLowerCase());
    }

    /**
     * this function returns a string between [begin, end]
     * @param begin begin index
     * @param end end index
     * @return hthe string between index [begin, end]
     */
    public MyStringBuilder1 substring(int begin, int end) {
        return new MyStringBuilder1(stringBuilder.substring(begin, end));
    }

    @Override public String toString() {
        return stringBuilder.toString();
    }
}
