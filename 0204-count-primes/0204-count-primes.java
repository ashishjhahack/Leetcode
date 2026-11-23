class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];    // fill every no. true
        Arrays.fill(isPrime, true);

        if(n <= 2) return 0;

        isPrime[0] = false;   // b/c 0 and 1 are non prime no.
        isPrime[1] = false;

        for(int i=2; i*i<n; i++){
            // if not marked by false then enter it
            if(isPrime[i]){
                for(int j=i*i; j<n; j+=i){
                    isPrime[j] = false;
                }
            }
        }

        // calculate total prime no.
        int count = 0;
        for(int i=2; i<n; i++){
            if(isPrime[i]) count++;
        }
        return count;
    }
}