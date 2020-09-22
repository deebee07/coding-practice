public class Solution extends Reader4 {

    private char[] cache = new char[4];
    private int readIdx = 0;
    private int cacheSize = 0;
    
    public int read(char[] buf, int n) {
        int writeIdx = 0;
        //read the remaining characters from cache
        while (readIdx < cacheSize && writeIdx < n) {
            buf[writeIdx++] = cache[readIdx++];
        }
        //read a new chunk of characters from read4 API
        while (writeIdx < n) {
            cacheSize = read4(cache);
            readIdx = 0;
            if (cacheSize == 0) {  //no more characters from the read4 API, break immediately to avoid infinite loop
                break;
            }
            for (int i = 0; i < cacheSize && writeIdx < n; i++) {
                buf[writeIdx++] = cache[readIdx++];
            }
        }
        return writeIdx;
    }
}