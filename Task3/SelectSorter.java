package Task3;

public class SelectSorter implements Sorter {

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
        for(int i = 0;i<this.a.length-1;i++){
            int minIndex = i;
            for(int j = i+1;j<this.a.length;j++){
                if(this.a[j]<this.a[minIndex]){
                    minIndex = j;
                }
            }
            if(i!=minIndex){
                swap(i,minIndex);
            }
        }
    }

    @Override
    public String getPlan() {
        return this.plan;
    }

}

