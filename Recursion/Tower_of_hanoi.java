class Hanoi {

    public long toh(int n, int from, int to, int aux) {
        // Your code here
        return solve(n, from, to, aux);
    }
    
    public long solve(int n, int from, int to, int aux){
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            System.out.println("move disk " + n + " from rod " + from + " to rod " + to);
            return 1;
        }
        
        long count = solve(n-1, from, aux, to);
        
        count += 1;
        
        System.out.println("move disk " + n + " from rod " + from + " to rod " + to);
        
        count += solve(n-1, aux, to, from);
        
        return count;
        
    }
}