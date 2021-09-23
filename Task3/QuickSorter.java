package Task3;

public class QuickSorter implements Sorter {

    private int[] a;

    @Override
    public void load(int[] a) {
        this.a = a;
    }

    private void swap(int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        plan += "" + a[i] + "<->" + a[j] + "\n";
    }

    private String plan = "";

    @Override
    public void sort() {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            quicksort(0, this.a.length-1);
        }
    }
    
    void quicksort(int low,int high){
        if(low>high)return;
        int temp = this.a[low];
        int i = low;
        int j=high;
        while(i<j){
            while(temp<=this.a[j] && i<j){
                j--;
            }
            while(temp>=this.a[i] && i<j){
                i++;
            }
            if(i<j){
                swap(i,j);
            }
        }
        swap(low,i);
        quicksort(low, j-1);
        quicksort(j+1, high);
    }


    @Override
    public String getPlan() {
        return this.plan;
    }

}

