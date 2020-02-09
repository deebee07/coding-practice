class Staircase {

    public int CountWays(int n) {
      if (n < 2) return 1;
      if (n == 2) return 2;
      int n1=1, n2=1, n3=2, temp;
      for(int i=3; i<=n; i++) {
        temp = n1 + n2 + n3;
        n1 = n2;
        n2 = n3;
        n3 = temp;
      }
      return n3;
    }
  
    public static void main(String[] args) {
      Staircase sc = new Staircase();
      System.out.println(sc.CountWays(3));
      System.out.println(sc.CountWays(4));
      System.out.println(sc.CountWays(5));
    }
  }