class Solution {

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Pair<Integer, String>>> userVists = new HashMap<>();
        for (int i = 0; i < username.length; i++) {
            userVists.putIfAbsent(username[i], new ArrayList<>());
            userVists.get(username[i]).add(new Pair(timestamp[i], website[i]));
        }
        Map<String, Integer> resultMap = new HashMap<>();
        String result = "";
        Integer maxRes = 0;
        for (String user : userVists.keySet()) {
            List<Pair<Integer, String>> visits = userVists.get(user);
            Collections.sort(visits, (a, b) -> a.getKey() - b.getKey());
            Set<String> keys = new HashSet<>();
            for (int i = 0; i < visits.size(); i++) {
                for (int j = i + 1; j < visits.size(); j++) {
                    for (int k = j + 1; k < visits.size(); k++) {
                        String key = visits.get(i).getValue() + "_" + visits.get(j).getValue() + "_" + visits.get(k).getValue();
                        if (keys.contains(key)) {
                            continue;
                        } else {
                            resultMap.putIfAbsent(key, 0);
                            resultMap.put(key, resultMap.get(key) + 1);
                            if (resultMap.get(key) > maxRes || (resultMap.get(key) == maxRes && key.compareTo(result) < 0)) {
                                maxRes = resultMap.get(key);
                                result = key;
                            }
                            keys.add(key);
                        }
                    }
                }
            }
        }
        List<String> finalResult = new ArrayList<>();
        String[] resultArray = result.split("_");
        for (int i = 0; i < resultArray.length; i++) {
            finalResult.add(resultArray[i]);
        }
        return finalResult;
    }
}