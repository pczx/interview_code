package container;

import java.util.ArrayList;
import java.util.Iterator;

public class RemoveListElement {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
//        removeWayOne(arrayList);
//        removeWayTwo(arrayList);
        removeWayThree(arrayList);
        System.out.println(arrayList);
    }

    private static void removeWayOne(ArrayList<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == 3) {
                arrayList.remove(i);
                i--;
            }
        }
    }

    private static void removeWayTwo(ArrayList<Integer> arrayList) {
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            if (arrayList.get(i) == 3) {
                arrayList.remove(i);
            }
        }
    }

    private static void removeWayThree(ArrayList<Integer> arrayList) {
        Iterator<Integer> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().equals(3)) {
                it.remove();
            }
        }
    }
}
