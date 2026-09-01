class RandomizedSet {
    ArrayList<Integer> list;
    HashMap<Integer, Integer> map;   // store (val, index)
    Random random;
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        list.add(val);
        map.put(val, list.size()-1);    // map: (key, value) => Eg. (1, 0)

        return true;
    }
    
    public boolean remove(int val) {   // Eg. remove(20) from [10, 20, 30]
        if(!map.containsKey(val)) return false;
        int n = list.size();

        int index = map.get(val);   // get the index of currValue
        int lastValue = list.get(n-1);   // get the last Value

        // set the lastValue to currValue's index  eg. [10, 30, 30]
        list.set(index, lastValue);
        map.put(lastValue, index);  // also update this in map

        // Now remove the lastValue  Eg. [10, 30]
        list.remove(n-1);
        map.remove(val);

        return true;
    }
    
    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */