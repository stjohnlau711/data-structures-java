import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MinHeap { //minHeap implementation

    private ArrayList<Integer> items;

    public MinHeap(){
        items = new ArrayList<Integer>();
    }

    private void upHeap(){
        int k = items.size() - 1;
        while(k > 0){
            int p = (k-1)/2;
            int item = items.get(k);
            int parent = items.get(p);

            if(item < parent){
                //swap parent and item
                int temp = parent;
                parent = item;
                item = parent;

                //move child pointer to parent
                k = p;
            } else {
                break;
            }
        }
    }

    public void insert(int item){
        items.add(item);
        upHeap();
    }

    private void downHeap(){
        int k = 0;
        int l = (2 * k) + 1;
        while(l < items.size()){
            int min = l; //left child
            int r = l + 1; //right child (2k + 2)
            if(r < items.size()){ //if so, there exists a right child
                if(items.get(r) < items.get(l)){
                    min++; //if right child is smaller than left child,
                    //then the minimum element should be changed to the right child
                }
            }
            if(items.get(k) > items.get(min)){ //if so, parent > child, so we need to switch
                //swap element at k (child) with element at max (parent)
                int temp = items.get(k);
                items.add(k, items.get(min));
                items.add(min, temp);
                k = min;
                l = (2*k) + 1;
            } else {
                break;
            }
        }
    }

    public int delete(){
        if(items.size() == 0){
            throw new NoSuchElementException();
        }
        if(items.size() == 1){
            return items.remove(0);
        }

        int hold = items.get(0);
        items.set(0, items.remove(items.size() - 1)); //last item removed
        // and put in 1st position
        downHeap();
        return hold;
    }
}
