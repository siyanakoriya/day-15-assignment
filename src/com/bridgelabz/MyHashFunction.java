package com.bridgelabz;

public class MyHashFunction {
    MyMapNode[] table;
    String[] strArray;
    int bucketSize;

    public MyHashFunction(String strArray, int bucketSize) {

        this.table = new MyMapNode[bucketSize];
        this.bucketSize = bucketSize;
        this.strArray = strArray.spliit (" ");
        hashTable();
    }

    private boolean isEmpty() {
        for (MyMapNode element : table) {
            if (element != null) {
                return false;
            }
        }
        return true;
    }

    private void hashTable() {
        for (int i = 0; i < strArray.length; i++) {
            int bucketIndex = Math.abs(strArray[i].hashCode() % bucketSize);
            if (table[bucketIndex] == null) {
                table[bucketIndex] = new MyMapNode(strArray[i]);
            } else {
                MyMapNode currNode = table[bucketIndex];
                while (currNode != null) {
                    if (currNode.data.equals(strArray[i])) {
                        currNode.frequency++;
                        break;
                    }
                    if(currNode.next == null) {
                        currNode.next = new MyMapNode(strArray[i]);
                        break;
                    }
                    currNode = currNode.next;
                }
            }
        }
    }

    public void showTable() {
        if (isEmpty()) {
            return;
        } else {
            for (MyMapNode element : table) {
                MyMapNode currNode =element;
                while (currNode != null) {
                    System.out.println(currNode.data + " " + currNode.frequency);
                    currNode = currNode.next;
                }
            }
        }
    }

    public void deleteData(String data) {
        int bucketIndex = Math.abs(data.hashCode() % bucketSize);
        if(isEmpty()) {
            return;
        }
        MyMapNode currNode = table[bucketIndex];
        while(currNode != null) {
            if(currNode.data.equals(data)) {
                MyMapNode temp = currNode.next;
                table[bucketIndex] = temp;
                break;
            }
            currNode = currNode.next;
        }
    }
}