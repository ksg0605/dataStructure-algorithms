// 해시함수에 키값을 넣고 객체의 주소값을 계산한 후 해시테이블을 찾고 그에 맞는 슬롯을 찾는다는 개념을 알면 쉽게 코딩할 수 있다.
// key - hashFunction - datastructure.hashTable - slot 의 구조를 이해하면 편하다.

package datastructure.hashTable;

public class MyHash {
    public Slot[] hashTable;

    public MyHash(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String value;

        Slot(String value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LinearMyHash mainObject = new LinearMyHash(20);
        System.out.println(mainObject.saveData("DaveLee", "01022223333"));
        System.out.println(mainObject.saveData("fun-coding", "01033334444"));
        System.out.println(mainObject.getData("fun-coding"));
    }

    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % hashTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);

        if (this.hashTable[address] != null) {
            this.hashTable[address].value = value;
        }
        else {
            this.hashTable[address] = new Slot(value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);

        if (this.hashTable[address] != null) {
            return this.hashTable[address].value;
        }
        else {
            return null;
        }
    }

}