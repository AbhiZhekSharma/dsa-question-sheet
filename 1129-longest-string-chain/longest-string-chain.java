class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());      // shorting

        HashMap<String,Integer> dp=new HashMap<>();           // word -> chain length 
         int ans=1;
         for(String word:words){                            // every word
         dp.put(word,1);                                     // minimum chain = 1
         for(int i=0;i<word.length();i++){                      // remove one character
         String prev=word.substring(0,i)+word.substring(i+1);      // make previous word

                if(dp.containsKey(prev)){
                    dp.put(word,
                        Math.max(dp.get(word),dp.get(prev)+1));    // extend chain
                }
            }
             ans=Math.max(ans,dp.get(word));                          // update answer
        }
        return ans;
    }
}