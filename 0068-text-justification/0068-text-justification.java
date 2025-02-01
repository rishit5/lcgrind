class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new LinkedList<>();
        int currSum = 0;
        int end = 0;
        String lastString1 = "";
        for (int i = 0; i < words.length; i++) {
            currSum += words[i].length() + 1;
            if (i == words.length - 1 || currSum + words[i+1].length() > maxWidth) {
                double totalGaps = i - end;
                double letters = currSum - totalGaps - 1;
                double spaces = maxWidth - letters;
                double spacesLeft = spaces;
                String currResult = words[end];
                lastString1 = words[end];
                System.out.println(spaces + " " + totalGaps);
                for (int j = end+1; j <= i; j++) {
                    lastString1 += " " + words[j];
                    double spacesTaken = Math.min(Math.ceil(spacesLeft/totalGaps), spacesLeft);
                    spacesLeft -= spacesTaken;
                    totalGaps -= 1;
                    for (int o = 0; o < spacesTaken - 1; o++) {
                        currResult += " ";
                    }
                    currResult += " " +  words[j];
                }
                if (end == i) {
                    for (int p = currResult.length(); p < maxWidth; p++) {
                        currResult += " ";
                    }
                }
                result.add(currResult);
                currSum = 0;
                end = i+1;
            }
        }
        result.set(result.size() - 1, lastString1);
        if (result.get(result.size() - 1).length() < maxWidth) {
            String lastString = result.get(result.size() - 1);
            for (int i = result.get(result.size() - 1).length(); i < maxWidth; i++) {
                lastString += " ";
            }
            result.set(result.size() - 1, lastString);
        }
        return result;
    }
}