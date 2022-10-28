class RandomizedSet {
    List<Integer> set;
    Map<Integer,Integer> map;
    Random random;
    private int in;
    
    public RandomizedSet() {
        set = new ArrayList();
        random = new Random();
        map = new HashMap();
        in = 0;
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))return false;
        map.put(val,in);
        in+=1;
        set.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        
        int ind = map.get(val);
        Collections.swap(set,ind,in-1);
        map.put(set.get(ind),ind);
        map.remove(val);
        set.remove(in-1);
        in-=1;
        return true;
    }
    
    public int getRandom() {
        int ind = random.nextInt(in);
        return set.get(ind);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
