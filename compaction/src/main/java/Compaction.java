class Compaction {

    /**
     * Compacts all consecutive '1' repetitions into a single appearance
     * in place of a source array. e.g. 2,2,1,1,1,3,0 => 2,2,1,3,0
     * The source array should end with '0' to indicate it's new end
     *
     * @param source source array to be compacted
     */
    static void compact(int[] source) {
        int j=0;
        for (int i=0; i<source.length && source[i] != 0; i++) {
            if (!(i>0 && source[i]==1 && source[i-1]==1)) {
                source[j] = source[i];
                j++;
            }
        }
        source[j] = 0;
    }
}
