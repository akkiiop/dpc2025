class missingInArray{
    public static int findMissing(int arr[],int n){
        int xor1=0,xor2=0;
        for(int i=0;i<n;i++){
            xor2=xor2 ^ arr[i];
            xor1=xor1 ^ (i+1);
        }
    
        xor1 = xor1 ^ (n + 1);
        return (xor1 ^ xor2);
    }

    public static void main(String args[]){
        int[] arr = {1, 2, 4, 5};
        int n = arr.length;
        System.out.println("Missing number is: " + findMissing(arr, n));
    }
}
