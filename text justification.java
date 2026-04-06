import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            
            // Determine how many words can fit in the current line
            while (last < words.length) {
                if (words[last].length() + count + 1 > maxWidth) break;
                count += words[last].length() + 1;
                last++;
            }

            StringBuilder builder = new StringBuilder();
            int diff = last - index - 1; // Number of gaps between words

            // Case 1: Last line or only one word in the line (Left-justified)
            if (last == words.length || diff == 0) {
                for (int i = index; i < last; i++) {
                    builder.append(words[i]);
                    if (i < last - 1) builder.append(" ");
                }
                // Pad the remaining width with spaces
                for (int i = builder.length(); i < maxWidth; i++) {
                    builder.append(" ");
                }
            } 
            // Case 2: Regular line (Fully-justified)
            else {
                int spaces = (maxWidth - count) / diff; // Base spaces per gap
                int r = (maxWidth - count) % diff;    // Extra spaces to distribute from left
                
                for (int i = index; i < last; i++) {
                    builder.append(words[i]);
                    if (i < last - 1) {
                        // Apply base 1 space + calculated extra spaces
                        int spaceToApply = 1 + spaces + ((i - index < r) ? 1 : 0);
                        for (int j = 0; j < spaceToApply; j++) {
                            builder.append(" ");
                        }
                    }
                }
            }

            result.add(builder.toString());
            index = last;
        }

        return result;
    }
}
