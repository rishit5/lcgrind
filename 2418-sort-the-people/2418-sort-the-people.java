class Solution {
    class People {
        public String name;
        public int height;
        
        public People(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }
    
    public String[] sortPeople(String[] names, int[] heights) {
        ArrayList<People> peopleList = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            peopleList.add(new People(names[i], heights[i]));
        }
        String[] result = new String[names.length];
        peopleList.sort((a, b) -> b.height - a.height);
        for (int i = 0; i < names.length; i++) {
            result[i] = peopleList.get(i).name;
        }
        return result;
    }
}